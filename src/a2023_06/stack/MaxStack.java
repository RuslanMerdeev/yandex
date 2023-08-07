package a2023_06.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxStack<T extends Comparable> extends Stack<T>{

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();
        MaxStack<Integer> maxStack = new MaxStack<>();

        do {
            line = r.readLine();
            String[] data = line.trim().split(" ");

            switch (data[0]) {
                case "push":
                    maxStack.push(Integer.parseInt(data[1]));
                    break;

                case "pop":
                    maxStack.pop();
                    break;

                case "max":
                    System.out.println(maxStack.max());
                    break;
            }
        } while (r.ready());
    }

    Stack<Node<T>> s;

    private class Node<E> {
        E val;
        E max;
        public Node(E val, E max)
        {
            this.val = val;
            this.max = max;
        }
    }

    public MaxStack() { this.s = new Stack<>(); }

    @Override
    public T pop() {
        return this.s.pop().val;
    }

    @Override
    public T push(T x)
    {
        if (s.isEmpty()) {
            this.s.push(new Node<>(x, x));
        }
        else {
            T max = max(this.s.peek().max, x);
            this.s.push(new Node<>(x, max));
        }
        return x;
    }

    public T max() { return this.s.peek().max; }

    private T max(T first, T second) {
        return (first.compareTo(second)) > 0 ? first : second;
    }
}

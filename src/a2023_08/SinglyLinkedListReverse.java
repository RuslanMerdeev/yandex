package a2023_08;

public class SinglyLinkedListReverse {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        void print() {
            Node<T> head = this;
            while(head.next != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.println(head.data);
        }
    }

    <T> Node<T> reverse(Node<T> head) {
        Node<T> prev = null;

        while(head.next != null) {
            Node<T> next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

    public static void main(String[] args) {
        SinglyLinkedListReverse reverse = new SinglyLinkedListReverse();
        Node<Integer> head = new Node<>(0, new Node<>(1, new Node<>(2, null)));
        head.print();
        head = reverse.reverse(head);
        head.print();
    }
}

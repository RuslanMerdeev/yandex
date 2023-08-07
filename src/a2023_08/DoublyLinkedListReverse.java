package a2023_08;

public class DoublyLinkedListReverse {

    class Node {

        int data;
        Node prev;
        Node next;

        Node (int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        void print() {
            Node head = this;
            do {
                System.out.print(head.data + " -> ");
                head = head.next;
            } while (head.next != null);
            System.out.println(head.data);
        }

        void swap() {
            Node next = this.next;
            this.next = this.prev;
            this.prev = next;
        }
    }

    public Node reverse(Node head) {
        while (head.next != null) {
            head.swap();
            head = head.prev;
        }
        head.swap();
        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedListReverse reverse = new DoublyLinkedListReverse();
        Node node = reverse.fill(new Integer[]{1, 2, 3, 4, 5});
        node.print();
        node = reverse.reverse(node);
        node.print();
    }

    Node fill (Integer[] numbers) {
        Node prev = null;
        Node head = null;
        for (Integer number : numbers) {
            Node curr = new Node(number, prev, null);
            if (head == null) {
                head = curr;
            }
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;
        }
        return head;
    }
}

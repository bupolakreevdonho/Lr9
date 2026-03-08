package Lr9.example5;

public class LinkedListHead {
    private Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListHead list = new LinkedListHead();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.printList();
    }
}

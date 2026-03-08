package Lr9.example5;

public class LinkedListTail {
    private Node head;
    private Node tail;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
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
        LinkedListTail list = new LinkedListTail();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.printList();
    }
}


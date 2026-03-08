package Lr9.example4;

public class LinkedListExample {
    private Node head;

    // Добавление элемента в начало
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Вывод списка
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListExample list = new LinkedListExample();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        list.printList();
    }
}

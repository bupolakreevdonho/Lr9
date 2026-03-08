package Lr9.example8;

// Класс, представляющий узел списка
public class Node {
    public int value; // Информационное поле (данные)
    public Node next; // Адресное поле (ссылка на следующий узел)

    // Конструктор для удобного создания узла
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

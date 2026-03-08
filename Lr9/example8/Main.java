package Lr9.example8;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("=== Демонстрация работы методов ===");

        // Создание списка с головы (цикл)
        list.createHead(5);
        System.out.println("createHead (5 элементов): " + list.toString());

        // Очистим список для следующего примера
        list = new LinkedList();

        // Создание списка с хвоста (цикл)
        list.createTail(5);
        System.out.println("createTail (5 элементов): " + list.toString());

        // Добавление в начало
        list.addFirst(99);
        System.out.println("addFirst(99): " + list.toString());

        // Добавление в конец
        list.addLast(100);
        System.out.println("addLast(100): " + list.toString());

        // Вставка по индексу (например, на позицию 2)
        list.insert(777, 2);
        System.out.println("insert(777, 2): " + list.toString());

        // Удаление первого
        list.removeFirst();
        System.out.println("removeFirst(): " + list.toString());

        // Удаление последнего
        list.removeLast();
        System.out.println("removeLast(): " + list.toString());

        // Удаление по индексу (например, позиция 2)
        list.remove(2);
        System.out.println("remove(2): " + list.toString());

        System.out.println("\n=== Работа рекурсивных методов ===");

        // Рекурсивное создание с головы
        LinkedList listRec = new LinkedList();
        listRec.createHeadRec(5);
        System.out.println("createHeadRec (5 элементов): " + listRec.toStringRec());

        // Рекурсивное создание с хвоста
        LinkedList listRec2 = new LinkedList();
        listRec2.createTailRec(5);
        System.out.println("createTailRec (5 элементов): " + listRec2.toStringRec());
    }
}

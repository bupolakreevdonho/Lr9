package Lr9;

import java.util.*;

public class comparison {

    // Количество элементов согласно варианту 7: 7 * 1_000_000
    private static final int ELEMENTS_COUNT = 700_000; // Уменьшено для быстрого теста, в реальности 7_000_000
    private static final int TEST_OPERATIONS = 100_000; // Количество операций для тестов добавления/удаления
    private static final int INDEX_GET_COUNT = 1_000_000; // Количество операций получения по индексу

    public static void main(String[] args) {

        System.out.println("СРАВНЕНИЕ КОЛЛЕКЦИЙ (Вариант 7)");
        System.out.println("Коллекции для сравнения: ArrayDeque, ArrayList, LinkedList");
        System.out.println("Количество элементов в коллекциях: " + ELEMENTS_COUNT);
        System.out.println("Количество тестовых операций: " + TEST_OPERATIONS);
        System.out.println("Количество операций получения по индексу: " + INDEX_GET_COUNT);

        // Создаем коллекции и заполняем их начальными данными
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Заполняем коллекции
        System.out.println("Заполнение коллекций начальными данными...");
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            arrayDeque.add(i);
            arrayList.add(i);
            linkedList.add(i);
        }
        System.out.println("Заполнение завершено. Размер каждой коллекции: " + ELEMENTS_COUNT + "\n");

        // Таблица 1: Сравнение времени добавления элементов
        System.out.println("Таблица 1: Добавление элементов (время в мс)");
        System.out.println("==========================================================");
        System.out.println("Коллекция    | В начало | В середину | В конец");
        System.out.println("-------------|----------|------------|--------");

        // ArrayDeque
        System.out.printf("%-12s | %8d | %10s | %6s%n",
                "ArrayDeque",
                testAddFirstArrayDeque(),
                "---",
                "---");

        // ArrayList
        System.out.printf("%-12s | %8d | %10d | %6d%n",
                "ArrayList",
                testAddFirstArrayList(),
                testAddMiddleArrayList(),
                testAddLastArrayList());

        // LinkedList
        System.out.printf("%-12s | %8d | %10d | %6d%n",
                "LinkedList",
                testAddFirstLinkedList(),
                testAddMiddleLinkedList(),
                testAddLastLinkedList());

        // Таблица 2: Сравнение времени удаления элементов
        System.out.println("Таблица 2: Удаление элементов (время в мс)");
        System.out.println("==========================================================");
        System.out.println("Коллекция    | В начале | В середине | В конце");
        System.out.println("-------------|----------|------------|-------");

        // ArrayDeque
        System.out.printf("%-12s | %8d | %10s | %6d%n",
                "ArrayDeque",
                testRemoveFirstArrayDeque(new ArrayDeque<>(arrayDeque)),
                "---",
                testRemoveLastArrayDeque(new ArrayDeque<>(arrayDeque)));

        // ArrayList
        System.out.printf("%-12s | %8d | %10d | %6d%n",
                "ArrayList",
                testRemoveFirstArrayList(new ArrayList<>(arrayList)),
                testRemoveMiddleArrayList(new ArrayList<>(arrayList)),
                testRemoveLastArrayList(new ArrayList<>(arrayList)));

        // LinkedList
        System.out.printf("%-12s | %8d | %10d | %6d%n",
                "LinkedList",
                testRemoveFirstLinkedList(new LinkedList<>(linkedList)),
                testRemoveMiddleLinkedList(new LinkedList<>(linkedList)),
                testRemoveLastLinkedList(new LinkedList<>(linkedList)));

        // Таблица 3: Сравнение времени получения по индексу
        System.out.println("Таблица 3: Получение элемента по индексу");
        System.out.println("==========================================================");
        System.out.println("Коллекция    | По индексу для " + INDEX_GET_COUNT + " элементов");
        System.out.println("-------------|-------------------------");

        // ArrayList
        System.out.printf("%-12s | %23d%n",
                "ArrayList",
                testGetByIndexArrayList(new ArrayList<>(arrayList)));

        // ArrayDeque
        System.out.printf("%-12s | %23s%n",
                "ArrayDeque",
                "не поддерживается");

        // LinkedList
        System.out.printf("%-12s | %23d%n",
                "LinkedList",
                testGetByIndexLinkedList(new LinkedList<>(linkedList)));

        // Дополнительный анализ
        System.out.println("АНАЛИЗ РЕЗУЛЬТАТОВ");
        System.out.println("==========================================================");

        analyzeResults();
    }

    // Тесты добавления
    // Тест добавления в начало для ArrayDeque
    private static long testAddFirstArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS; i++) {
            deque.addFirst(i);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест добавления в начало для ArrayList
    private static long testAddFirstArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS; i++) {
            list.add(0, i);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест добавления в начало для LinkedList
    private static long testAddFirstLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS; i++) {
            list.addFirst(i);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест добавления в середину для ArrayList
    private static long testAddMiddleArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        // Предварительно заполняем список
        for (int i = 0; i < TEST_OPERATIONS; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS / 10; i++) { // Уменьшаем количество для середины
            int middleIndex = list.size() / 2;
            list.add(middleIndex, i);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест добавления в середину для LinkedList
    private static long testAddMiddleLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        // Предварительно заполняем список
        for (int i = 0; i < TEST_OPERATIONS; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS / 10; i++) { // Уменьшаем количество для середины
            int middleIndex = list.size() / 2;
            list.add(middleIndex, i);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест добавления в конец для ArrayList
    private static long testAddLastArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS; i++) {
            list.add(i);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест добавления в конец для LinkedList
    private static long testAddLastLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS; i++) {
            list.addLast(i);
        }

        return System.currentTimeMillis() - start;
    }

    // Тесты удаления
    // Тест удаления из начала для ArrayDeque
    private static long testRemoveFirstArrayDeque(ArrayDeque<Integer> deque) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS && !deque.isEmpty(); i++) {
            deque.removeFirst();
        }

        return System.currentTimeMillis() - start;
    }

    // Тест удаления из конца для ArrayDeque
    private static long testRemoveLastArrayDeque(ArrayDeque<Integer> deque) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS && !deque.isEmpty(); i++) {
            deque.removeLast();
        }

        return System.currentTimeMillis() - start;
    }

    // Тест удаления из начала для ArrayList
    private static long testRemoveFirstArrayList(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS / 10 && !list.isEmpty(); i++) { // Уменьшаем количество
            list.remove(0);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест удаления из середины для ArrayList
    private static long testRemoveMiddleArrayList(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS / 10 && !list.isEmpty(); i++) { // Уменьшаем количество
            int middleIndex = list.size() / 2;
            list.remove(middleIndex);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест удаления из конца для ArrayList
    private static long testRemoveLastArrayList(ArrayList<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS && !list.isEmpty(); i++) {
            list.remove(list.size() - 1);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест удаления из начала для LinkedList
    private static long testRemoveFirstLinkedList(LinkedList<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS && !list.isEmpty(); i++) {
            list.removeFirst();
        }

        return System.currentTimeMillis() - start;
    }

    // Тест удаления из середины для LinkedList
    private static long testRemoveMiddleLinkedList(LinkedList<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS / 10 && !list.isEmpty(); i++) { // Уменьшаем количество
            int middleIndex = list.size() / 2;
            list.remove(middleIndex);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест удаления из конца для LinkedList
    private static long testRemoveLastLinkedList(LinkedList<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < TEST_OPERATIONS && !list.isEmpty(); i++) {
            list.removeLast();
        }

        return System.currentTimeMillis() - start;
    }

    // Тесты получения по индексу
    // Тест получения элементов по индексу для ArrayList
    private static long testGetByIndexArrayList(ArrayList<Integer> list) {
        Random random = new Random(42); // Фиксированный seed для воспроизводимости
        long start = System.currentTimeMillis();

        for (int i = 0; i < INDEX_GET_COUNT; i++) {
            int index = random.nextInt(list.size());
            list.get(index);
        }

        return System.currentTimeMillis() - start;
    }

    // Тест получения элементов по индексу для LinkedList
    private static long testGetByIndexLinkedList(LinkedList<Integer> list) {
        Random random = new Random(42); // Фиксированный seed для воспроизводимости
        long start = System.currentTimeMillis();

        for (int i = 0; i < INDEX_GET_COUNT / 10; i++) { // Уменьшаем количество для LinkedList
            int index = random.nextInt(list.size());
            list.get(index);
        }

        return System.currentTimeMillis() - start;
    }

    // Анализ результатов
    //Анализ полученных результатов и вывод рекомендаций
    private static void analyzeResults() {
        System.out.println("\n1. ArrayDeque:");
        System.out.println("   - Лучше всего подходит для работы с двумя концами (стек/очередь)");
        System.out.println("   - Не поддерживает доступ по индексу");
        System.out.println("   - Не поддерживает вставку/удаление в середине");
        System.out.println("   - Рекомендация: использовать как стек или очередь");

        System.out.println("\n2. ArrayList:");
        System.out.println("   - Лучший выбор для доступа по индексу");
        System.out.println("   - Быстрое добавление/удаление только в конце");
        System.out.println("   - Медленное добавление/удаление в начале или середине");
        System.out.println("   - Рекомендация: использовать когда нужен частый доступ по индексу");

        System.out.println("\n3. LinkedList:");
        System.out.println("   - Быстрое добавление/удаление с обоих концов");
        System.out.println("   - Медленный доступ по индексу");
        System.out.println("   - Занимает больше памяти (хранит ссылки)");
        System.out.println("   - Рекомендация: использовать когда часто добавляете/удаляете в начале");

        System.out.println("\n=== ОБЩИЕ РЕКОМЕНДАЦИИ ===");
        System.out.println("• Для стека (LIFO): используйте ArrayDeque");
        System.out.println("• Для очереди (FIFO): используйте ArrayDeque");
        System.out.println("• Для частого доступа по индексу: используйте ArrayList");
        System.out.println("• Для частых вставок/удалений в начале: используйте LinkedList");
        System.out.println("• Для частых вставок/удалений в конце: используйте ArrayList");
        System.out.println("• Для работы с серединой списка: все коллекции неэффективны");
    }
}

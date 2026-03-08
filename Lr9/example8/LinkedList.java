package Lr9.example8;

import java.util.Scanner;

public class LinkedList {
    private Node head; // Ссылка на первый элемент списка

    // --- Конструктор ---
    public LinkedList() {
        this.head = null; // Изначально список пуст
    }

    // ========== МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ ЦИКЛА ==========

    // а) Ввод с головы (createHead()) - заполняем список числами 1,2,3...
    public void createHead(int count) {
        for (int i = count; i >= 1; i--) {
            // Каждый новый элемент становится головой, а старая голова уходит в next
            head = new Node(i, head);
        }
    }

    // б) Ввод с хвоста (createTail()) - заполняем список числами 1,2,3...
    public void createTail(int count) {
        for (int i = 1; i <= count; i++) {
            Node newNode = new Node(i, null);
            if (head == null) {
                head = newNode; // Если список пуст, новый узел - это голова
            } else {
                Node ref = head;
                // Идем до последнего элемента (у которого next == null)
                while (ref.next != null) {
                    ref = ref.next;
                }
                // Прицепляем новый узел в конец
                ref.next = newNode;
            }
        }
    }

    // в) Вывод (toString()) - возвращаем строку вида "1 -> 2 -> 3"
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            sb.append(ref.value);
            if (ref.next != null) {
                sb.append(" -> ");
            }
            ref = ref.next;
        }
        return sb.toString();
    }

    // г) Добавление в начало (AddFirst())
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    // д) Добавление в конец (AddLast())
    public void addLast(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = newNode;
    }

    // е) Вставка по номеру (Insert())
    public void insert(int value, int position) {
        // Считаем, что позиции считаются с 0 (0 - первый элемент)
        if (position == 0) {
            addFirst(value);
            return;
        }
        Node newNode = new Node(value, null);
        Node ref = head;
        // Ищем элемент, который будет стоять перед новым (на позиции position-1)
        for (int i = 0; i < position - 1; i++) {
            if (ref == null) {
                System.out.println("Ошибка: позиция больше длины списка");
                return;
            }
            ref = ref.next;
        }
        // Перебрасываем ссылки
        newNode.next = ref.next;
        ref.next = newNode;
    }

    // ж) Удаление с головы (RemoveFirst())
    public void removeFirst() {
        if (head != null) {
            head = head.next; // Теперь голова - это следующий элемент
        }
    }

    // з) Удаление последнего (RemoveLast())
    public void removeLast() {
        if (head == null) return; // Список пуст
        if (head.next == null) { // В списке только один элемент
            head = null;
            return;
        }
        Node ref = head;
        // Ищем предпоследний элемент (у которого next.next == null)
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null; // Делаем его последним
    }

    // и) Удаление по номеру (Remove())
    public void remove(int position) {
        if (position == 0) {
            removeFirst();
            return;
        }
        Node ref = head;
        // Ищем элемент, предшествующий удаляемому
        for (int i = 0; i < position - 1; i++) {
            if (ref == null || ref.next == null) {
                System.out.println("Ошибка: позиция больше длины списка");
                return;
            }
            ref = ref.next;
        }
        // Перепрыгиваем через удаляемый элемент
        if (ref.next != null) {
            ref.next = ref.next.next;
        }
    }

    // ========== МЕТОДЫ С ИСПОЛЬЗОВАНИЕМ РЕКУРСИИ ==========

    // к) Ввод с головы (createHeadRec())
    // Вспомогательный рекурсивный метод для заполнения
    private Node createHeadRecHelper(int count, int current) {
        if (current > count) {
            return null; // Базовый случай: возвращаем null (конец списка)
        }
        // Рекурсивно создаем хвост, а потом создаем голову
        Node nextNode = createHeadRecHelper(count, current + 1);
        return new Node(current, nextNode);
    }

    public void createHeadRec(int count) {
        head = createHeadRecHelper(count, 1);
    }


    // л) Ввод с хвоста (createTailRec())
    private Node createTailRecHelper(int count, int current) {
        if (current > count) {
            return null;
        }
        // Сначала создаем голову, потом рекурсивно прицепляем к ней хвост
        Node newNode = new Node(current, null);
        newNode.next = createTailRecHelper(count, current + 1);
        return newNode;
    }

    public void createTailRec(int count) {
        head = createTailRecHelper(count, 1);
    }


    // м) Вывод (toStringRec())
    // Рекурсивно проходим по списку и собираем строку
    private String toStringRecHelper(Node node) {
        if (node == null) {
            return ""; // Базовый случай: конец списка
        }
        // Если это последний элемент, не добавляем стрелку
        if (node.next == null) {
            return Integer.toString(node.value);
        }
        // Рекурсивный случай: текущее значение + " -> " + результат для хвоста
        return node.value + " -> " + toStringRecHelper(node.next);
    }

    public String toStringRec() {
        return toStringRecHelper(head);
    }
}
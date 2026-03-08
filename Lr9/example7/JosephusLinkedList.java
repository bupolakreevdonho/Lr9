package Lr9.example7;
import java.util.LinkedList;
import java.util.List;

public class JosephusLinkedList {
    public static void solveJosephus(int n) {
        List<Integer> people = new LinkedList<>();

        // Заполняем список
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }

        int index = 0;
        System.out.println("Процесс выбывания (LinkedList):");

        while (people.size() > 1) {
            index = (index + 1) % people.size();
            System.out.println("Выбыл человек №" + people.remove(index));
        }

        System.out.println("Выжил человек №" + people.get(0));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        solveJosephus(10);
        long endTime = System.nanoTime();
        System.out.println("Время выполнения: " + (endTime - startTime) + " наносекунд");
    }
}

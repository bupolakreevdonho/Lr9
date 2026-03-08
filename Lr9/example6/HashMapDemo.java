package Lr9.example6;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // Создание и заполнение HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Заполняем 10 элементов
        map.put(0, "Значение 0");
        map.put(1, "Строка 1");
        map.put(2, "Короткая");
        map.put(3, "Длинная строка для теста");
        map.put(4, "Пример");
        map.put(5, "Средний текст");
        map.put(6, "Шестой элемент");
        map.put(7, "Седьмой");
        map.put(8, "Восьмой элемент");
        map.put(9, "Девятый");

        // Поиск строк с ключом > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        // Вывод строки с ключом = 0
        StringBuilder zeroKeyStrings = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                zeroKeyStrings.append(entry.getValue()).append(", ");
            }
        }
        System.out.println("Строка с ключом 0: " + zeroKeyStrings.toString().trim());

        // Перемножение ключей с длиной строки > 5
        long product = 1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
            }
        }
        System.out.println("Произведение ключей с длиной строки > 5: " + product);
    }
}

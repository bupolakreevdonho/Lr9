import java.util.Scanner;

public class Converter {

    // Рекурсивный метод перевода числа в двоичную систему
    public static void convertToBinary(int number) {
        // Базовый случай
        if (number == 0)
            return;

        // Рекурсивный вызов
        convertToBinary(number / 2);

        // Вывод остатка от деления
        System.out.print(number % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое положительное число: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Ошибка: число должно быть положительным");
            return;
        }

        System.out.print("Двоичное представление числа " + number + ": ");

        // Обработка особого случая
        if (number == 0) {
            System.out.println("0");
        } else {
            convertToBinary(number);
            System.out.println();
        }
    }
}

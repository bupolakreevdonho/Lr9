package Lr9.example3;

import java.util.Scanner;

public class ArrayRecursion {
    // Размер массива
    private static int size;
    private static int[] array;
    private static Scanner scanner = new Scanner(System.in);

    // Рекурсивный метод ввода массива
    public static void readArray(int index) {
        if (index >= size) return; // Базовый случай

        System.out.print("Введите элемент [" + index + "]: ");
        array[index] = scanner.nextInt();
        readArray(index + 1); // Рекурсивный вызов
    }

    // Рекурсивный метод вывода массива
    public static void printArray(int index) {
        if (index >= size) return; // Базовый случай

        System.out.print(array[index] + " ");
        printArray(index + 1); // Рекурсивный вызов
    }

    public static void main(String[] args) {
        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        size = scanner.nextInt();

        // Создание массива
        array = new int[size];

        // Ввод элементов
        System.out.println("\nВведите элементы массива:");
        readArray(0);

        // Вывод элементов
        System.out.println("\nСодержимое массива:");
        printArray(0);
    }
}

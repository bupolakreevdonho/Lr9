package Lr9.example1;

public class Recursion5 {

    public static int fibonacci(int n, String indent) {
        // Показываем, что функция вызвана
        System.out.println(indent + "fib(" + n + ") вызван");

        // Базовые случаи - рекурсия останавливается
        if (n == 0) {
            System.out.println(indent + "  → возвращает 0 (базовый случай)");
            return 0;
        }
        if (n == 1) {
            System.out.println(indent + "  → возвращает 1 (базовый случай)");
            return 1;
        }

        // Функция вызывает сама себя дважды
        System.out.println(indent + "  нужно вычислить fib(" + (n-1) + ") + fib(" + (n-2) + ")");

        int fib1 = fibonacci(n - 1, indent + "  ");
        int fib2 = fibonacci(n - 2, indent + "  ");
        int result = fib1 + fib2;

        // Результат
        System.out.println(indent + "  → fib(" + n + ") = " + fib1 + " + " + fib2 + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Дерево рекурсивных вызовов для fib(5) ===\n");
        int result = fibonacci(5, "");
        System.out.println("\nИтоговый результат: " + result);
    }
}


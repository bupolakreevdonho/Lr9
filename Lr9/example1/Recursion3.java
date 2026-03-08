package Lr9.example1;

public class Recursion3 {
    public static void m(int x) {
        System.out.println("До вызова: " + x);
        if (x >= 20) return;
        m(2 * x + 1);
        System.out.println("После вызова: " + x);
    }

    public static void main(String[] args) {
        m(0);
    }
}

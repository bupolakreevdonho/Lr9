package Lr9.example1;

public class Recursion2 {

    public static void m(int x) {
        if (x >= 20) return;
        m(2 * x + 1);
        System.out.println(x);
    }

    public static void main(String[] args) {
        m(0);
    }
}

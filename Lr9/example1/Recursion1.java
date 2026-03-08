package Lr9.example1;

public class Recursion1 {

    public static void m(int x) {
        if (x >= 20) return;
        System.out.println(x);
        m(2 * x + 1);
    }

    public static void main(String[] args) {
        m(0);
    }
}


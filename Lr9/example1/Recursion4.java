package Lr9.example1;

public class Recursion4 {
    public static int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("5! = " + fact(5));
    }
}

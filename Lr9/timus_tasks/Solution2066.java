package Lr9.timus_tasks;

import java.util.Scanner;
import java.util.Arrays;

public class Solution2066 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int a, b, c;

        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();

        int[] exp = {a+b+c, a-b-c, a*b*c,
                a+b-c, a-b+c, a+b*c,
                a*b+c, a-b*c, a*b-c};

        int m = Arrays.stream(exp).min().orElse(0);
        System.out.println(m);}
}

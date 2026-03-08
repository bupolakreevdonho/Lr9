package Lr9.timus_tasks;

import java.util.Scanner;

public class Solution1924 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int sum = N*(N+1)/2;
        if(sum%2==0)System.out.println("black");
        else System.out.println("grimy");
    }
}

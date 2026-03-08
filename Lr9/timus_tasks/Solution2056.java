package Lr9.timus_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Solution2056 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        List<Integer> grades = new ArrayList<>();
        for(int i=0; i<N; i++){
            grades.add(input.nextInt());}
        String typeScholarship = checkScholarshipType(grades);
        System.out.println(typeScholarship);}

    public static String checkScholarshipType(List<Integer> grades){
        if(grades.stream().anyMatch(g->g==3)) return "None";
        if(grades.stream().allMatch(g->g==5)) return "Named";
        Optional<Integer> sum = grades.stream().reduce(Integer::sum);
        float avg =(float) sum.orElse(0) / grades.size();
        if(avg>=4.5)return "High";
        else return "Common";
    }
}

package tech.wec.iLoveZQW;

import java.util.Arrays;
import java.util.Scanner;

public class HighestGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        int m;
        String opt;
        int a, b;
        while(input.hasNext()) {
            n = input.nextInt();
            m = input.nextInt();
            int[] grades = new int[n];
            for (int i = 0; i < n; i++) {
                grades[i] = input.nextInt();
            }
            while(m-- > 0 && input.hasNext()){
                opt = input.next();
                a = input.nextInt();
                b = input.nextInt();
                switch (opt){
                    case "Q":
                        System.out.println(getHighest(grades, a, b));
                        break;
                    case "U":
                        grades[a-1] = b;
                        break;
                }
            }
        }
    }

    private static int getHighest(int[] grades, int left, int right){
        if (right < left){
            int tmp = right;
            right = left;
            left = tmp;
        }
        int max = 0;
        for (int i = left-1; i <= right-1; i++){
            if(max < grades[i])
                max = grades[i];
        }
        return max;
    }
}

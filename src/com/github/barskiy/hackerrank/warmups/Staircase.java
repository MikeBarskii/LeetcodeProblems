package com.github.barskiy.hackerrank.warmups;

public class Staircase {
    static void staircase(int n) {
        for(int i = 0; i < n;i++) {
            int j = 0;
            for(; j < n-i-1; j++)
                System.out.print(" ");
            for(; j < n; j++)
                System.out.print("#");
            System.out.println();
        }
    }
}

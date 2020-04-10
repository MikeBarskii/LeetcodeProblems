package com.github.barskiy.hackerrank.warmups;

public class PlusMinus {

    static void plusMinus(int[] arr) {
        double plus = 0, minus = 0, zero = 0;
        for (int num: arr) {
            if (num > 0)
                plus++;
            else if (num<0)
                minus++;
            else
                zero++;
        }
        System.out.println(plus/arr.length);
        System.out.println(minus/arr.length);
        System.out.println(zero/arr.length);
    }
}

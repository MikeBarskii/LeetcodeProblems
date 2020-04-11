package com.github.barskiy.leetcode.explore.arrayandstring.introinstring;

public class AddBinary {

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int pointerA = a.length() - 1, pointerB = b.length() - 1, sum = 0;

        while (pointerA >= 0 || pointerB >= 0) {
            if (pointerB >= 0) sum += b.charAt(pointerB--) - '0';
            if (pointerA >= 0) sum += a.charAt(pointerA--) - '0';

            sb.append(sum % 2);
            sum /= 2;
        }
        if (sum != 0) sb.append(sum);

        return sb.reverse().toString();
    }
}
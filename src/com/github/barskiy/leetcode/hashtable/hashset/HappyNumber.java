package com.github.barskiy.leetcode.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        new HappyNumber().isHappy(149);
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int res = 0;
            while (n != 0) {
                res += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (!set.add(res)) return false;
            n = res;
        }
        return true;
    }
}

package com.github.barskiy.leetcode.problems.math.substracttheproductandsumofdigits_1281;

public class Solution {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n != 0) {
            int last = n % 10;
            n /= 10;
            sum += last;
            product *= last;
        }

        return product - sum;
    }
}

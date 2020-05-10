package com.github.barskiy.leetcode.problems.backtracking.permutationsequence_60;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        String res = solve.getPermutation(3, 2);
        System.out.println(res);
    }

    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fact *= i;
            numbers.add(i);
        }

        int first = 1;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int sizeOfBlock = fact / n;
            int index = (k - first) / sizeOfBlock;
            first += index * sizeOfBlock;

            sb.append(numbers.get(index));
            numbers.remove(index);

            fact /= n;
            n--;
        }

        return sb.toString();
    }

}

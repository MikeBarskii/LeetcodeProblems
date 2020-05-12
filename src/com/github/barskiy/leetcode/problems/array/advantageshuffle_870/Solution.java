package com.github.barskiy.leetcode.problems.array.advantageshuffle_870;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int[] res = solve.advantageCount(new int[]{12, 24, 8, 32},
                new int[]{13, 25, 32, 11});
        System.out.println(Arrays.toString(res));
    }

    public int[] advantageCount(int[] A, int[] B) {
        Map<Integer, Deque<Integer>> valueOfBToIndexes = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            Deque<Integer> indexesOfValue = valueOfBToIndexes.getOrDefault(B[i], new ArrayDeque<>());
            indexesOfValue.offer(i);
            valueOfBToIndexes.put(B[i], indexesOfValue);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] res = new int[B.length];
        int i = 0, j = 0, last = B.length - 1;
        while (j <= last && i < A.length) {
            Deque<Integer> indexes;
            if (A[i] <= B[j]) {
                indexes = valueOfBToIndexes.get(B[last--]);
            } else {
                indexes = valueOfBToIndexes.get(B[j++]);
            }
            res[indexes.pop()] = A[i++];
        }

        return res;
    }

}

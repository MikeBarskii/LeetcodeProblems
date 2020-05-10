package com.github.barskiy.leetcode.problems.array.findthetownjudge_997;

public class Solution {

    public int findJudge(int N, int[][] trust) {
        int[] trusted = new int[N + 1];
        for (int[] pair : trust) {
            int person = pair[0];
            int possibleJudge = pair[1];
            trusted[person]--;
            trusted[possibleJudge]++;
        }

        for (int i = 1; i < trusted.length; i++) {
            if (trusted[i] == N-1)
                return i;
        }

        return -1;
    }
}

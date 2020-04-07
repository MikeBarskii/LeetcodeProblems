package com.github.barskiy.arrayandstring.twopointertechnique;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int k = 0;
        for (int num : nums) {
            if (num != 1) {
                max = Math.max(max, k);
                k = 0;
            } else k++;
        }
        return Math.max(max, k);
    }
}

package com.github.barskiy.leetcode.arrayandstring.twopointertechnique;

import java.util.Arrays;

public class ArrayPartition1 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }

        return res;
    }
}

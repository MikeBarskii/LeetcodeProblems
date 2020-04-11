package com.github.barskiy.leetcode.explore.arrayandstring.twopointertechnique;

import java.util.LinkedList;
import java.util.List;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        List<Integer> values = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (num >= s)
                return 1;

            sum += num;
            values.add(num);

            if (sum >= s) {
                int last = values.get(0);
                while (sum - last >= s) {
                    values.remove(0);
                    sum -= last;
                    last = values.get(0);
                }
                res = Math.min(values.size(), res);
            }
        }

        return (res == Integer.MAX_VALUE ? 0 : res);
    }

    public int minSubArrayLenOneMoreSolution(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= s) return 1;

            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i + 1 - left);
                sum -= nums[left++];
            }
        }

        return (res == Integer.MAX_VALUE ? 0 : res);
    }

}

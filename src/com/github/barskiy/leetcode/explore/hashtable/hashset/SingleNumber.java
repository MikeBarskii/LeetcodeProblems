package com.github.barskiy.leetcode.explore.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (values.contains(num)) values.remove(num);
            else
                values.add(num);
        }
        return values.iterator().next();
    }

    public int singleNumberOneMoreSolution(int[] nums) {
        int number = 0;
        for (int i : nums) number = number ^ i;
        return number;
    }
}

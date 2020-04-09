package com.github.barskiy.leetcode.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> passedValues = new HashSet<>();
        for (int num : nums) {
            if (passedValues.contains(num))
                return true;
            else
                passedValues.add(num);
        }
        return false;
    }
}

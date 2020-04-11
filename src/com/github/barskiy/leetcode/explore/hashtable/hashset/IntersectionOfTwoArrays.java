package com.github.barskiy.leetcode.explore.hashtable.hashset;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> values1 = new HashSet<>();
        for (int num : nums1) values1.add(num);

        Set<Integer> values2 = new HashSet<>();
        for (int num : nums2) values2.add(num);

        values1.retainAll(values2);

        int[] res = new int[values1.size()];
        int i = 0;
        for (Integer num : values1) res[i++] = num;

        return res;
    }
}

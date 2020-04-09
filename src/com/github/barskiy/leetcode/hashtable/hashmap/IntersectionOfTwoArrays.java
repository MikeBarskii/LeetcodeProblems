package com.github.barskiy.leetcode.hashtable.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> values1 = new HashMap<>();
        Map<Integer, Integer> values2 = new HashMap<>();

        fillMapWithValueToCount(nums1, values1);
        fillMapWithValueToCount(nums2, values2);

        List<Integer> commonValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> valueToCount : values1.entrySet()) {
            Integer number = valueToCount.getKey();
            if (values2.containsKey(number)) {
                int minAmount = Math.min(values1.get(number), values2.get(number));
                for (int i = 0; i < minAmount; i++) {
                    commonValues.add(number);
                }
            }
        }

        int[] res = new int[commonValues.size()];
        int i = 0;
        for (Integer commonValue : commonValues) res[i++] = commonValue;

        return res;
    }

    private void fillMapWithValueToCount(int[] nums, Map<Integer, Integer> values) {
        for (int num : nums) {
            if (values.containsKey(num))
                values.put(num, values.get(num) + 1);
            else
                values.put(num, 1);
        }
    }
}

package com.github.barskiy.leetcode.problems;

import java.util.*;

public class TopKFrequentElements347 {

    public static void main(String[] args) {
        new TopKFrequentElements347().topKFrequent(new int[] {1,1,1,2,2,3}, 2);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToFrequent = new HashMap<>();
        Map<Integer, Set<Integer>> frequentToNumber = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            int frequent;
            if (numberToFrequent.containsKey(num))
                frequent = numberToFrequent.get(num) + 1;
            else
                frequent = 1;

            Set<Integer> set;
            if (frequentToNumber.containsKey(frequent))
                set = frequentToNumber.get(1);
            else
                set = new HashSet<>();

            set.add(num);
            numberToFrequent.put(num, frequent);
            frequentToNumber.put(frequent, set);
            max = Math.max(max, frequent);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(frequentToNumber.get(max).iterator().next());
            max--;
            while (!frequentToNumber.containsKey(max))
                max--;
        }

        return res;
    }

}

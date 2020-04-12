package com.github.barskiy.leetcode.explore.hashtable.conclusion;

import java.util.*;

// Could be solved with head, but ask with 2 hash maps
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numberToFrequent = new HashMap<>();
        Map<Integer, Set<Integer>> frequentToNumber = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            int frequent = numberToFrequent.getOrDefault(num, 0) + 1;
            numberToFrequent.put(num, frequent);

            if (frequentToNumber.containsKey(frequent))
                frequentToNumber.get(frequent).add(num);
            else
                frequentToNumber.put(frequent, new HashSet<>() {{
                    add(num);
                }});

            max = Math.max(max, frequent);

            if (frequentToNumber.containsKey(--frequent))
                frequentToNumber.get(frequent).remove(num);
        }

        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < k) {
            while (!frequentToNumber.containsKey(max))
                max--;
            if (frequentToNumber.get(max).isEmpty()) {
                frequentToNumber.remove(max);
            } else {
                int next = getNextMostFrequentElement(frequentToNumber, max);
                frequentToNumber.get(max).remove(next);
                res.add(next);
                i++;
            }
        }

        return res;
    }

    private int getNextMostFrequentElement(Map<Integer, Set<Integer>> map, int max) {
        ArrayList<Integer> list = new ArrayList<>(map.get(max));
        Collections.sort(list);
        return list.get(0);
    }

}

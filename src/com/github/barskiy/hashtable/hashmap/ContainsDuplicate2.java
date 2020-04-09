package com.github.barskiy.hashtable.hashmap;

import java.util.*;

public class ContainsDuplicate2 {

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate2().containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> numToIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (numToIndices.containsKey(value)) {
                List<Integer> indices = numToIndices.get(value);
                for (Integer index : indices)
                    if (i - index <= k)
                        return true;
                indices.add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                numToIndices.put(value, indices);
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicateOneMoreSolution(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}

package com.github.barskiy.leetcode.explore.hashtable.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> restaurantToRating = new HashMap<>();

        for (int i = 0; i < list1.length; i++)
            restaurantToRating.put(list1[i], i);

        List<String> res = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE, commonIndex;
        for (int i = 0; i < list2.length; i++) {
            if (restaurantToRating.containsKey(list2[i])) {
                commonIndex = restaurantToRating.get(list2[i]) + i;
                if (commonIndex < minIndex) {
                    res.clear();
                    res.add(list2[i]);
                    minIndex = commonIndex;
                } else if (commonIndex == minIndex)
                    res.add(list2[i]);
            }
        }

        return res.toArray(new String[0]);
    }
}

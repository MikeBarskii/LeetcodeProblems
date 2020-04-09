package com.github.barskiy.hashtable.designthekey;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> orderedStringToOriginal = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (orderedStringToOriginal.containsKey(sorted)) {
                List<String> strings = orderedStringToOriginal.get(sorted);
                strings.add(str);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                orderedStringToOriginal.put(sorted, strings);
            }
        }

        return new ArrayList<>(orderedStringToOriginal.values());
    }
}

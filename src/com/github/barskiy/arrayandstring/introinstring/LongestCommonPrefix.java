package com.github.barskiy.arrayandstring.introinstring;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","dogi", "dogiq"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Set<String> prefixes = new HashSet<>();
        String firstString = strs[0];
        for (int i = 1; i <= firstString.length(); i++)
            prefixes.add(firstString.substring(0, i));

        for (String str : strs) {
            if (prefixes.isEmpty())
                return "";
            Set<String> prefixesForDeletion = new HashSet<>();
            for (String prefix : prefixes)
                if (!str.startsWith(prefix))
                    prefixesForDeletion.add(prefix);
            prefixes.removeAll(prefixesForDeletion);
        }

        String maxPrefix = "";
        for (String prefix : prefixes) {
            if (prefix.length() > maxPrefix.length())
                maxPrefix = prefix;
        }

        return maxPrefix;
    }

    public String longestCommonPrefixOneMoreSolution(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length && !prefix.isEmpty(); i++) {
            while (strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        }

        return prefix;
    }
}

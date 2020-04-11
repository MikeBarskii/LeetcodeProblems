package com.github.barskiy.leetcode.explore.arrayandstring.conclusion;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] strings = s.trim().split(" +");
        for (int i = strings.length - 1; i > 0; i--) {
            builder.append(strings[i]).append(" ");
        }

        return builder.append(strings[0]).toString();
    }
}

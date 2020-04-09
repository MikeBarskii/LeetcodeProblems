package com.github.barskiy.leetcode.arrayandstring.conclusion;

public class ReverseWordsInString3 {

    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ')
                builder.append(c);
            else {
                res.append(builder.reverse().toString()).append(" ");
                builder = new StringBuilder();
            }
        }
        return res.append(builder.reverse()).toString();
    }
}

package com.github.barskiy.leetcode.explore.arrayandstring.introinstring;

public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;

        for (int i = 0, needlePoint = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length())
                return -1;

            if (haystack.charAt(i) == needle.charAt(needlePoint)) {

                int j = i;
                while (needlePoint < needle.length()
                        && haystack.charAt(j) == needle.charAt(needlePoint)) {
                    j++;
                    needlePoint++;
                }

                if (j - i == needle.length())
                    return i;
                else
                    needlePoint = 0;
            }
        }
        return -1;
    }
}

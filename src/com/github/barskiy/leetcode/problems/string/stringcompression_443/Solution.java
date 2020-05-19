package com.github.barskiy.leetcode.problems.string.stringcompression_443;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.compress(new char[]{'a', 'a', 'a', 'a', 'a', 'b'});
        System.out.println(res);
    }

    public int compress(char[] chars) {
        int left = 0, right = 0, indexToWrite = 0;
        while (right < chars.length) {
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
            }

            chars[indexToWrite] = chars[left];
            if (right - left > 1) {
                String count = getStringFromDigit(right - left);

                for (int i = count.length() - 1; i >= 0; i--) {
                    chars[++indexToWrite] = count.charAt(i);
                }
            }

            indexToWrite++;
            left = right;
        }

        return indexToWrite;
    }

    private String getStringFromDigit(int digit) {
        StringBuilder sb = new StringBuilder();
        while (digit != 0) {
            sb.append(digit % 10);
            digit /= 10;
        }
        return sb.toString();
    }
}

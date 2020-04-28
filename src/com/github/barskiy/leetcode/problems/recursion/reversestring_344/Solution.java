package com.github.barskiy.leetcode.problems.recursion.reversestring_344;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        char[] s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        solve.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    //Could be solved more optimal with two pointers technique
    public void reverseString(char[] s) {
        swapByLeftIndex(s, 0);
    }

    private void swapByLeftIndex(char[] s, int leftIndex) {
        if (leftIndex == s.length / 2) return;

        swap(s, leftIndex, s.length - leftIndex - 1);

        swapByLeftIndex(s, leftIndex + 1);
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}

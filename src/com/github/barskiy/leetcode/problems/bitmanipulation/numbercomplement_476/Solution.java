package com.github.barskiy.leetcode.problems.bitmanipulation.numbercomplement_476;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.findComplementOptimized(5);
        System.out.println(res);
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //https://leetcode.com/problems/number-complement/discuss/95992/java-1-line-bit-manipulation-solution
    public int findComplementOptimized(int num) {
        // 5 -> 0101 => Integer.highestOneBit(num) == 0100;
        // mask:   highestOneBit << 1   =>   0100 << 1   =>   1000
        // mask "-1":    1000 - 1  == 0111
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        // ~num   =>   5 is 0101  =>   ~5 is 1010, but we need only last 3 bits
        int reverse = ~num;
        // ~num & mask    =>    1010 & 0111 == 0010    =>   res = 2
        return reverse & mask;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int findComplement(int num) {
        char[] chars = Integer.toBinaryString(num).toCharArray() ;
        int res = 0, last = chars.length - 1;
        for (int i = last; i >= 0; i--) {
            if (chars[i] == '0') res += Math.pow(2, last - i);
        }
        return res;
    }
}

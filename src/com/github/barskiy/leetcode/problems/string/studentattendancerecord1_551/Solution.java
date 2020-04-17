package com.github.barskiy.leetcode.problems.string.studentattendancerecord1_551;

public class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean checkRecord(String s) {
        int absentCounter = 0, lateContinuousCounter = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'L')
                lateContinuousCounter++;
             else
                lateContinuousCounter--;

            if (c == 'A') absentCounter++;

            if (lateContinuousCounter > 2 || absentCounter > 1)
                return false;
        }

        return true;
    }
}

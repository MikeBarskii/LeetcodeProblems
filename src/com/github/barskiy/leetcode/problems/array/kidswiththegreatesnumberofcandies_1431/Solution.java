package com.github.barskiy.leetcode.problems.array.kidswiththegreatesnumberofcandies_1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;

        for (int candy : candies) {
            if (candy > max) max = candy;
        }

        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}

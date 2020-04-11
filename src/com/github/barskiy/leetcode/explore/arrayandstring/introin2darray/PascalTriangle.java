package com.github.barskiy.leetcode.explore.arrayandstring.introin2darray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        res.add(prev);

        for (int i = 1; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            for (int j = 1; j < i; j++)
                line.add(prev.get(j - 1) + prev.get(j));
            line.add(1);

            res.add(line);
            prev = line;
        }
        return res;
    }

}

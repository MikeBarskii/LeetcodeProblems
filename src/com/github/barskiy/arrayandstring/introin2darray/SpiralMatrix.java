package com.github.barskiy.arrayandstring.introin2darray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
//        matrix[2][0] = 7;
//        matrix[2][1] = 8;
//        matrix[2][2] = 9;
//        matrix[3][0] = 10;
//        matrix[3][1] = 11;
//        matrix[3][2] = 12;
        System.out.println(spiralOrder(matrix));
        System.out.println();


    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return Collections.emptyList();

        int minI = 0, maxI = matrix.length - 1, minJ = 0, maxJ = matrix[0].length - 1;
        int i = 0, j = 0;

        List<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);
        while (minI <= maxI && minJ <= maxJ) {
            while (j < maxJ)
                res.add(matrix[i][++j]);
            while (i < maxI)
                res.add(matrix[++i][j]);
            maxJ--;
            maxI--;
            if (minI > maxI || minJ > maxJ)
                return res;
            while (j != minJ)
                res.add(matrix[i][--j]);
            minJ++;
            minI++;
            while (i != minI)
                res.add(matrix[--i][j]);
        }

        return res;
    }
}

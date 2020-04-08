package com.github.barskiy.arrayandstring.conclusion;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[k++] = nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroesOneMoreSolution(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}

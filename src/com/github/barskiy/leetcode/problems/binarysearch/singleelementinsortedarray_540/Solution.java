package com.github.barskiy.leetcode.problems.binarysearch.singleelementinsortedarray_540;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
        System.out.println(res);
    }

    // https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100754/Java-Binary-Search-short-(7l)-O(log(n))-w-explanations
    public int singleNonDuplicateAgain(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--;

            if (nums[mid] != nums[mid + 1])
                right = mid;
            else left = mid + 2;
        }

        return nums[left];
    }

    // https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/discuss/100732/Short-compare-numsi-with-numsi1?page=2
    // https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100733/java-binary-search-with-detailed-explanation
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
           if (nums[mid] == nums[mid ^ 1]) // mid ^ 1 stay even as even, change odd to odd-1
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public int singleNonDuplicateRecursive(int[] nums) {
        if (nums.length == 1) return nums[0];
        return singleFindHelper(nums, 0, nums.length - 1);
    }

    private int singleFindHelper(int[] nums, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if ((mid == 0 && nums[mid] != nums[mid + 1])
                || (mid == nums.length - 1 && nums[mid] != nums[mid - 1])
                || (mid + 1 < nums.length && mid - 1 >= 0 && nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]))
            return nums[mid];

        return Math.max(singleFindHelper(nums, left, mid - 1), singleFindHelper(nums, mid + 1, right));
    }
}

package com.github.barskiy.leetcode.problems.recursion.openthelock_752;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        int res = solve.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(res);
    }

    // Time Complexity: O(V+E)
    // Space Complexity: O(E)
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();

        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String currentLockPosition = queue.poll();
                if (deadendsSet.contains(currentLockPosition)) {
                    size--;
                    continue;
                }

                if (target.equals(currentLockPosition))
                    return level;

                StringBuilder sb = new StringBuilder(currentLockPosition);
                for (int i = 0; i < 4; i++) {
                    char currentPos = sb.charAt(i);
                    String s1 = sb.substring(0, i)
                            + (currentPos == '9' ? 0 : currentPos - '0' + 1)
                            + sb.substring(i + 1);
                    String s2 = sb.substring(0, i)
                            + (currentPos == '0' ? 9 : currentPos - '0' - 1)
                            + sb.substring(i + 1);

                    if (!visited.contains(s1) && !deadendsSet.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }

                    if (!visited.contains(s2) && !deadendsSet.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }

                size--;
            }
            level++;
        }

        return -1;
    }

}

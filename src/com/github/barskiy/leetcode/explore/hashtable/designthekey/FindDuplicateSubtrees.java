package com.github.barskiy.leetcode.explore.hashtable.designthekey;

import java.util.*;

public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;

        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        root1.left = new TreeNode(4);
        root2.left = root4;
        root2.right = root5;

        root4.left = new TreeNode(4);

        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(root));
    }

    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        ans = new ArrayList<>();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x -> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }


    // Work partly. Will fail on a very big tree with Time Exceed
    public List<TreeNode> findDuplicateSubtreesOneBadSolution(TreeNode root) {
        HashSet<TreeNode> duplicatedNodes = new HashSet<>();
        getDuplicates(root, new HashMap<>(), duplicatedNodes);

        return new ArrayList<>(duplicatedNodes);
    }

    private void getDuplicates(TreeNode root, Map<Integer, List<TreeNode>> map, Set<TreeNode> res) {
        if (root == null) return;

        if (!map.containsKey(root.val)) {
            List<TreeNode> trees = new ArrayList<>();
            trees.add(root);
            map.put(root.val, trees);
        } else {
            List<TreeNode> trees = map.get(root.val);
            boolean isDuplicateExist = false;
            for (TreeNode tree : trees) {
                if (compareTreeNodes(root, tree)) {
                    res.add(tree);
                    isDuplicateExist = true;
                }
            }
            if (!isDuplicateExist) {
                trees.add(root);
                map.put(root.val, trees);
            }
        }

        getDuplicates(root.left, map, res);
        getDuplicates(root.right, map, res);
    }

    private boolean compareTreeNodes(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return node1.val == node2.val &&
                compareTreeNodes(node1.left, node2.left) &&
                compareTreeNodes(node1.right, node2.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode[" +
                    "val=" + val +
                    ']';
        }
    }

}

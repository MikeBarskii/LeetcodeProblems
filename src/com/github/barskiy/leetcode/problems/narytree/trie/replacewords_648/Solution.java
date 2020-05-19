package com.github.barskiy.leetcode.problems.narytree.trie.replacewords_648;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solve = new Solution();
        String res = solve.replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"),
                "a aa a aaaa aaa aaa aaa aaaa bbb baba a");
        System.out.println(res);
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(trie.searchPrefix(word)).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }


    class Trie {

        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                Map<Character, TrieNode> children = cur.children;
                if (children.containsKey(c))
                    cur = children.get(c);
                else {
                    cur = new TrieNode();
                    children.put(c, cur);
                }
            }
            cur.isLeaf = true;
        }

        public String searchPrefix(String prefix) {
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < prefix.length(); i++) {
                if (cur.isLeaf)
                    return sb.toString();

                char c = prefix.charAt(i);
                Map<Character, TrieNode> children = cur.children;
                if (children.containsKey(c))
                    cur = children.get(c);
                else
                    break;
                sb.append(c);
            }

            return (cur.isLeaf) ? sb.toString() : prefix;
        }


        class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isLeaf = false;
        }
    }
}

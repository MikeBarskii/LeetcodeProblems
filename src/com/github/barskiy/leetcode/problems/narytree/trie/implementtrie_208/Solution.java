package com.github.barskiy.leetcode.problems.narytree.trie.implementtrie_208;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }

    static class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                Map<Character, TrieNode> children = cur.children;
                if (!children.isEmpty() && children.containsKey(c))
                    cur = children.get(c);
                else {
                    cur = new TrieNode();
                    children.put(c, cur);
                }
            }
            cur.isLeaf = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefixOrWord(word);
            return (node != null && node.isLeaf);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return (searchPrefixOrWord(prefix) != null);
        }

        private TrieNode searchPrefixOrWord(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                Map<Character, TrieNode> children = cur.children;
                if (children.isEmpty() || !children.containsKey(c))
                    return null;
                else
                    cur = children.get(c);
            }

            return cur;
        }

        static class TrieNode {
            private Map<Character, TrieNode> children = new HashMap<>();
            private boolean isLeaf = false;
        }

    }
}

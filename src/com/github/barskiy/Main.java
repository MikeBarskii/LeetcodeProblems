package com.github.barskiy;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello LeetCode");


        System.out.println(new Main().backspaceCompare(
                "hd#dp#czsp#####",
                "hd#dp#cs#zspj######"));
    }

    public boolean backspaceCompare(String S, String T) {
        int p1 = S.length();
        int p2 = T.length();
        while (p1 != 0 || p2 != 0) {
            p1 = getIndexOfNonDeletedChar(S, p1 - 1);
            p2 = getIndexOfNonDeletedChar(T, p2 - 1);

            if (p1 == -1 && p2 == -1)
                return true;

            if (p1 == -1 || p2 == -1)
                return false;

            if (S.charAt(p1) != T.charAt(p2))
                return false;
        }

        return true;
    }

    private int getIndexOfNonDeletedChar(String s, int pointer) {
        int charsForDeletion = 0;
        while (pointer >= 0 && (s.charAt(pointer) == '#' || charsForDeletion != 0)) {
            if (s.charAt(pointer) == '#')
                charsForDeletion++;
            else
                charsForDeletion--;
            pointer--;
        }

        return (pointer >= 0 ? pointer : -1);
    }
}

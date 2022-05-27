package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panfx
 * @date 2021/3/28 16:12
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(xxx("abcdaef"));
    }
    public static int xxx(String s) {
        int j = 0;
        char[] cs = s.toCharArray();
        List<Character> clist = new ArrayList<Character>();
        for (char c : cs) {
            List<Character> x = new ArrayList<>();
            for (int i = 0; i < clist.size(); i++) {
                x.add(clist.get(i));
                if (clist.get(i) == c) {
                    if (j < clist.size()) {
                        j = clist.size();
                    }

                    break;
                } else {
                    clist.add(c);
                }
            }

            if (clist.size() == 0) {
                clist.add(c);
            }

            if (clist.size() > x.size()) {
                clist.removeAll(x);
            }
        }
        return j;
    }
}

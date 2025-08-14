package com.rikkei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("000","111","222","333","444","555","666","777","888","999"));
        String s = "aaabbcc";
        System.out.println(s.substring(4,7));
    }
}
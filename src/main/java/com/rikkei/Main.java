package com.rikkei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
    public static int reverse(int x) {
        StringBuilder sbl = new StringBuilder(x+"");
        sbl = sbl.reverse();
        if(x<0){
            sbl.delete(sbl.length()-1, sbl.length());
            sbl.insert(0,"-");
        }
        return Integer.parseInt(sbl.toString());
    }
}
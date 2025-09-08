package com.rikkei;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        getNoZeroIntegers(2);
    }
    public static int[] getNoZeroIntegers(int n) {
        int initial = 1, result=0;
        while(result>=0){
            result = n - initial;
            String str1 = result + "";
            String str2 = initial +"";
            if(str1.contains("0") || str2.contains("0")){
                initial++;
                continue;
            }
            return new int[]{initial,result};
        }
        return new int[]{0,0};
    }
}
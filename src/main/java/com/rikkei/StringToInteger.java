package com.rikkei;

public class StringToInteger {
    public int myAtoi(String s) {
        s = s.trim();
        int result=0;
        boolean isNegative = false;
        int pointer = 0;

        if(s.length()<1) return 0;

        if(s.charAt(0)=='-'){
            isNegative = true;
            pointer++;
        }else if(s.charAt(0)=='+'){
            pointer++;
        }

        while(pointer<s.length()){
            int num = s.charAt(pointer)-'0';
            if(num<0||num>9) break;
            if(result > (Integer.MAX_VALUE-num)/10){
                result = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                break;
            }
            result = result*10 + num;
            pointer++;
        }
        return isNegative ? -result : result;
    }
}

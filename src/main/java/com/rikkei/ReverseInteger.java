package com.rikkei;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        boolean isNegative = x < 0;
        x = isNegative ? -x : x;
        StringBuilder sb = new StringBuilder(x+"").reverse();
        try{
            result = Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            return 0;
        }
        return isNegative ? -result : result;
    }
}

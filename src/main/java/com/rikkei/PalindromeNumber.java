package com.rikkei;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int result = 0;
        if(x<0) return false;
        int value = x;
        while(value!=0){
            int unit = value%10;
            value/=10;
            result = result*10 + unit;
        }
        return result==x;
    }
}

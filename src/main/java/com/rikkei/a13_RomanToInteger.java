package com.rikkei;

public class a13_RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;

        for(int i=0; i<s.length()-1; i++){
            int c = value(s.charAt(i));
            int c1 = value(s.charAt(i+1));
            if(c<c1) {
                result -= c;
            }else{
                result += c;
            }
        }
        result += value(s.charAt(s.length()-1));

        return result;
    }

    public Integer value(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

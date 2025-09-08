package com.rikkei;

public class ConvertToSumOfNoZero {
    public int[] getNoZeroIntegers(int n) {
        int i=1;
        int result = n-i;
        while(result>=0){
            if(checkZero(i)||checkZero(result)){
                i++;
                result = n - i;
                continue;
            }
            return new int[]{i,result};
        }
        return new int[]{0,0};
    }
    public boolean checkZero(int n){
        while(n!=0){
            if(n%10==0) return true;
            n/=10;
        }
        return false;
    }
}

package com.rikkei;

public class a1390_FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            int count = 0;
            for(int j=1; j*j<=nums[i]; j++){
                if(count>4) {
                    break;
                }
                if(nums[i]%j==0){
                    count++;
                    sum+=j;
                    int k = nums[i]/j;
                    if(k!=j){
                        count++;
                        sum+=k;
                    }
                }
            }
            if(count==4) result+=sum;
        }
        return result;
    }
}

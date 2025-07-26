package com.rikkei;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        int[] newNums = new int[2];
        for(int i=0; i<nums.length; i++){
            Integer diff = target - nums[i];
            if(map.containsKey(diff)){
                newNums = new int[]{i, map.get(diff)};
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return newNums;
    }
}

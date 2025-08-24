package com.rikkei;

import java.util.HashMap;
import java.util.Map;
// class Solution {
//     public int longestSubarray(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int left = 0, count = 0;
//         final int BINARY_ONE = 1;
//         final int BINARY_ZERO = 0;
//         for(int right=0; right<nums.length; right++){
//             map.put(nums[right], map.getOrDefault(nums[right],0)+1);

//             while(map.getOrDefault(BINARY_ZERO,0)>=2){
//                 map.put(nums[left], map.get(nums[left])-1);
//                 left++;
//             }
//             count = Math.max(map.getOrDefault(BINARY_ONE,0), count);
//         }

//         return map.containsKey(0) ? count: count-1;
//     }
// }
public class LongestSubArrayOfOneAfterDeleteOneEle {
    public int longestSubarray(int[] nums) {
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}

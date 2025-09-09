package com.rikkei;
/*
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 */
public class MostContainerWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = -1;
        while(left<right){
            int ver = Math.min(height[left], height[right]);
            int hoz = right-left;
            area = Math.max(ver*hoz,area);
            while(left<right && height[left]<=ver) left++;
            while(left<right && height[right]<=ver) right--;
        }
        return area;
    }
}

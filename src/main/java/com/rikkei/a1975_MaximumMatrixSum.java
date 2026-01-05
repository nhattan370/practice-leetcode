package com.rikkei;

public class a1975_MaximumMatrixSum {
    class Solution {
        public long maxMatrixSum(int[][] matrix) {
            int countNe = 0, minAbs = Integer.MAX_VALUE;
            long sum = 0;
            for(int[] row :matrix){
                for(int x :row){
                    if(x<0) {
                        x = -x;
                        countNe++;
                    }
                    sum += x;
                    minAbs = Math.min(x,minAbs);
                }
            }
            if(countNe%2!=0) sum -= minAbs*2L;
            return sum;
        }
    }
}

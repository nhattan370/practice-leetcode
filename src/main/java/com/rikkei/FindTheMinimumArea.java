package com.rikkei;
//3195. Find The Minimum Area
public class FindTheMinimumArea {
    public int minimumArea(int[][] grid) {
        int topHoz=Integer.MAX_VALUE, bottomHoz=Integer.MIN_VALUE,
                leftVer=Integer.MAX_VALUE, rightVer=Integer.MIN_VALUE;

        for(int x=0; x < grid.length; x++){
            for(int y=0; y < grid[x].length; y++){
                if(grid[x][y]==1){
                    topHoz  = Math.min(topHoz,x);
                    bottomHoz = Math.max(bottomHoz,x);
                    leftVer = Math.min(leftVer,y);
                    rightVer = Math.max(rightVer,y);
                }
            }
        }
        return bottomHoz >= 0 ? (bottomHoz - topHoz+1)*(rightVer - leftVer + 1) : 0;
    }
}

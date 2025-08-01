package com.rikkei;

import java.util.ArrayList;
import java.util.List;

public class PascalTriAngle {
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> prevRow;
        List<Integer> row = null;
        Integer num;
        for(int i=0; i<numRows; i++){
            row = new ArrayList<>();
            row.add(1);
            if(i>0){
                prevRow = triangle.get(i-1);
                for(int j=1; j<i; j++){
                    num = prevRow.get(j-1) + prevRow.get(j);
                    row.add(num);
                }
                row.add(1);
            }
            triangle.add(row);
        }
        return triangle;
    }
}

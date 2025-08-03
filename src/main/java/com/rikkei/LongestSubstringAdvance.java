package com.rikkei;

public class LongestSubstringAdvance {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int index = 0;
        int start = 0;
        int[] values = new int[128];
        for(int i=0;i<s.length();i++) {
            start = Math.max(start, values[s.charAt(i)]);
            values[s.charAt(i)] = ++index;
            result = Math.max(result, index-start);
        }
        return result;

    }
}

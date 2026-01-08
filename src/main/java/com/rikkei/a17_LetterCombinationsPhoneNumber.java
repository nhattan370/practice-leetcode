package com.rikkei;

import java.util.ArrayList;
import java.util.List;

public class a17_LetterCombinationsPhoneNumber {
    String[] letters = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(list, sb, digits, 0);
        return list;
    }

    private void backtrack(List<String> list, StringBuilder sb, String digits, int step){
        if(step>=digits.length()){
            list.add(sb.toString());
            return;
        }

        char ch = digits.charAt(step);
        int num = ch - '0';

        for(int i=0; i<letters[num].length(); i++){
            sb.append(letters[num].charAt(i));
            backtrack(list, sb, digits, step + 1);
            sb.delete(sb.length()-1, sb.length());
        }
    }
}

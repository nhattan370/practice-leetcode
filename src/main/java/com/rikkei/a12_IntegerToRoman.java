package com.rikkei;

public class a12_IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sbd = new StringBuilder();

        String roman[] = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        Integer number[] = new Integer[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i=0; i<number.length; i++){
            if(num>0){
                while(num>=number[i]){
                    num-=number[i];
                    sbd.append(roman[i]);
                }
            }else{
                break;
            }
        }
        return sbd.toString();
    }
}

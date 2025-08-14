package com.rikkei;
/*
Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
 */
public class ThreeSameDigitNumber {
    public String largestGoodInteger(String num) {
        String [] arr = {"999","888","777","666","555","444","333","222","111","000"};
        for(String ele: arr){
            if(num.contains(ele)) return ele;
        }
        return "";
    }
}

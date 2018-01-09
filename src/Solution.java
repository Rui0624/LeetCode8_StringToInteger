
public class Solution {
	public int myAtoi(String str) {
		if(str.isEmpty()) return 0;
        int sign = 1; // mark the positive or negetive
        int base = 0; // find the current number
        int n = str.length();
        int i = 0;
        while(i < n && str.charAt(i) == ' ')
        	i++; // if next char is ' ', keep search the next until not ' '
        
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
        	sign = (str.charAt(i) == '+') ? 1 : -1;
        	i++;
        } // by using the '+' '-" to judge the sign
        
        while(i<n && str.charAt(i) >= '0' && str.charAt(i) <= '9'){//by search one by one in the str, and compare the ASCII if there is a number
        	//if the number is out of bound. the max is 2147483647, check the last number if 7
        	if(base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 7))
        			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        	
        	base = 10 * base + (str.charAt(i++) - '0'); // the base number  * 10 and plus the current number
        }
        	
        return sign * base; // return the number with the sign
    }
}


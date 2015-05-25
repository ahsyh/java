package com.leetcode.q009;

public class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int a,b;
        a=0;
        b=str.length()-1;
        for(;;){
        	if(a<b){
        		if(str.charAt(a)!=str.charAt(b))
        			return false;
        		a++;
        		b--;
        	}
        	else
        		break;
        }
        return true;
    }
}
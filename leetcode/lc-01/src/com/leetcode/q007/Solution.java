package com.leetcode.q007;

public class Solution {
    public int reverse(int x) {
    	int sign=(x>=0)?1:-1;
    	x*=sign;
    	
    	StringBuffer strbuff = new StringBuffer(Integer.toString(x));
    	String reString = new String(strbuff.reverse());
    	
    	return sign*Integer.parseInt(reString);
    }
}

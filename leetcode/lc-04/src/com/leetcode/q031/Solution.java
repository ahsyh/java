package com.leetcode.q031;



public class Solution {
    static int[] d = new int[18000];
    
    public int longestValidParentheses(String s1) {
    	String s = new String(s1+'#');
    	
    	int length = s1.length();
    	if(length==0)
    		return 0;

    	int longest=0;
    	
    	d[length]=0;
    	d[length-1]=0;
    	for(int i=length-2;i>=0;i--){
			d[i]=0;
			
			int j=i+d[i+1]+1;

    		if(s.charAt(i)=='('&&s.charAt(j)==')'){
    			d[i]=d[i+1]+2+d[j+1];
    		}
    		
    		if(d[i]>longest){
    			longest = d[i];
    		}
    	}
    	return longest;
    }
}

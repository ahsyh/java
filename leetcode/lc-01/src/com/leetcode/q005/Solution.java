package com.leetcode.q005;

public class Solution {
	String PreHandle(String s){
		String res="^";
		
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			res += ("#"+ch);
		}
		res += "#$";
		return res;
	}
	
	int min(int a, int b){
		return a>b?b:a;
	}

	public String longestPalindrome(String s) {
    	String T = PreHandle(s);
    	int[] p = new int[T.length()];
    	
    	int C = 0;
    	int R = 0;
    	
    	for(int i=1;i<p.length-1;i++){
    		p[i]=(R>i)?(min(p[2*C-i],R-i)):0;
    		while(T.charAt(i+p[i]+1)==T.charAt(i-p[i]-1))
    			p[i]++;

    		if((i+p[i])>R)
    		{
    			C = i;
    			R = i+p[i];
    		}
    	}
    	
    	int maxLen = 0;
    	int center = 0;
    	for(int i=1;i<p.length-1;i++){
    		if(p[i]>maxLen){
    			center = i;
    			maxLen = p[i];
    		}
    	}
    	
    	return s.substring((center-1-maxLen)/2,(center-1-maxLen)/2+maxLen);
    }
}

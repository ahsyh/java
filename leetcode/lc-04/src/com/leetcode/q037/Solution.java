package com.leetcode.q037;

public class Solution {
	private String getNext(String s){
		String res=new String("");
		
		int last = s.charAt(0) - '0';
		int count = 1;
		
		for(int i=1;i<s.length();i++){
			int curr = s.charAt(i) - '0';
			if(curr==last)count++;
			else{
				res += Integer.toString(count);
				res += Integer.toString(last);
				last = curr;
				count = 1;
			}
			
		}
		res += Integer.toString(count);
		res += Integer.toString(last);
		
		return res;
	}

	public String countAndSay(int n) {
    	String res = new String("1");
    	
    	for(int i=0;i<n;i++){
    		res = getNext(res);
    	}
    
    	return res;
    }
}

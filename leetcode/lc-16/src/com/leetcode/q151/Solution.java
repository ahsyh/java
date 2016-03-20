package com.leetcode.q151;

public class Solution {
    public String reverseWords(String s) {
        String res = new String("");
        String[] parts = s.trim().split(" ");

        int i=parts.length;
        
        if(i<=0)
            return res;

        for(;i>0;i--){
        	if(parts[i-1].length()==0)
        		continue;
        	if(i!=1)
        		res += parts[i-1]+" ";
        	else
        		res += parts[i-1];
        }

        return res;
    }
}


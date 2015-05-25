package com.leetcode.q014;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String buf=new String();
        
        int num = strs.length;
        if(num<=0)
        	return buf;
        
        for(int i=0;;i++){
        	int j;
        	boolean pass=true;
        	for(j=0;j<num;j++){
        		if(strs[j].length()<i+1||strs[j].charAt(i)!=strs[0].charAt(i)){
        			pass=false;
        			break;
        		}
        	}
        	if(pass){
        		buf += strs[0].charAt(i);
        	}
        	else
        		break;
        }
        
        return buf;
    }
}

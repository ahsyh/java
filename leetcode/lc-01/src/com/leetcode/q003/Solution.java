package com.leetcode.q003;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int length = s.length();
    	if(length<=1)
    		return length;
    		
    	int pos=0;
    	int maxLength=0;
    	int[] hash=new int[256];
    	
    	for(int i=0;i<256;i++)
    		hash[i]=-1;
    	
    	for(;pos<length;pos++){
    		char ch=s.charAt(pos);
    		
    		int val=(int)ch;
    		int lastpos=-1;
    		boolean needUpdate=false;
    		if(hash[val]!=-1){
    			lastpos=hash[val];
    			if(ch==s.charAt(lastpos))
    				needUpdate=true;
    		}
			if((pos-lastpos)>maxLength){
				maxLength = pos-lastpos;
			}
			hash[val]=pos;
			if(needUpdate){
	        	for(int i=0;i<256;i++){
	        		if(hash[i]<lastpos)
	        			hash[i]=lastpos;
	        	}
			}
    	}

    	return maxLength;
    }
}

package com.leetcode.q054;

public class Solution {
    public boolean canJump(int[] A) {
        int maxpos = 0;
        int length = A.length-1;
        
        for(int i=0;i<=length;i++){
        	if(maxpos<i)
        		return false;
        	if((i+A[i])>maxpos)
        		maxpos = i+A[i];
        	
        	if(maxpos>=length)
        		return true;
        }
        
        return true;
    }
}

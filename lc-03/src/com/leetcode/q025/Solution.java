package com.leetcode.q025;

public class Solution {
    public int removeDuplicates(int[] A) {
    	int read, write;
    	read=write=0;
    	
    	while(read<A.length){
    		if(read>0&&A[read]==A[read-1])
    			read++;
    		else
    		{
    			if(write!=read)
    				A[write]=A[read];
    			read++;
    			write++;
    		}
    	}
    	
    	return write;
    }
}


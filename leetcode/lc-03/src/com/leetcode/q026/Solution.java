package com.leetcode.q026;

public class Solution {
    public int removeElement(int[] A, int elem) {
    	int read, write;
    	
    	read=write=0;
    	
    	while(read<A.length){
    		if(A[read]==elem)
    			read++;
    		else{
    			if(read!=write)
    				A[write]=A[read];
    			read++;
    			write++;
    		}
    	}
    	
    	return write;
    }
}


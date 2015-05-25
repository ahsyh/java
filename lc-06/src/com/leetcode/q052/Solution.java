package com.leetcode.q052;

public class Solution {
    public int maxSubArray(int[] A) {
    	
    	int max=A[0];
    	int consecutive=A[0];

    	for(int i=1;i<A.length;i++){
			consecutive += A[i];
    		
    		if(A[i]>consecutive)
    			consecutive = A[i];
   		
    		max = (consecutive > max)? consecutive: max;
    	}
        return max;
    }
}

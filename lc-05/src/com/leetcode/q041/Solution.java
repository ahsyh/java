package com.leetcode.q041;

public class Solution {
    private int mtrap(int[] A, int begin, int end) {
        if(begin>=(end-1))
        	return 0;
        int water = 0;
        int i=0;
        if(A[begin]<A[end]){
        	i = begin+1;
        	while(true){
        		if(A[i]<A[begin]){
        			water += A[begin] - A[i];
        			i++;
        		}
        		else
        			break;
        	}
        	return water + mtrap(A, i, end);
        }
        else{
        	i = end - 1;
        	while(true){
        		if(A[i]<A[end]){
        			water += A[end] - A[i];
        			i--;
        		}
        		else 
        			break;
        	}
        	return water + mtrap(A, begin, i);
        }
        
    }

    public int trap(int[] A) {
        return mtrap(A, 0, A.length-1);
    }
}

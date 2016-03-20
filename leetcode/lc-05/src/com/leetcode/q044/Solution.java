package com.leetcode.q044;

public class Solution {
    public int jump(int[] A) {
    	int size = A.length;
    	int[] neededStep = new int[size];
    	
    	for(int i=0;i<size;i++){
    		neededStep[i] = 0xFFFFFFF;
    	}
    	
    	neededStep[0]=0;
    	for(int i=0;i<size;i++){
			int val = neededStep[i]+1;
    		for(int j=A[i];j>=1;j--){
    			if((i+j)<size&&neededStep[i+j]>val){
    				neededStep[i+j]=val;
    			}
    			else if((i+j)<size){
    				break;
    			}
    		}
    	}
    	
        return neededStep[size-1];
    }
}


package com.leetcode.q040;

public class Solution {
    public int firstMissingPositive(int[] A) {
    	boolean[] checked = new boolean[A.length+2];
    	
    	for(int i=0;i<A.length+2;i++){
    		checked[i] = false;
    	}
    	
    	for(int i=0;i<A.length;i++){
    		if(A[i]>0&&A[i]<=A.length){
    			checked[A[i]]=true;
    		}
    	}

    	for(int i=1;i<A.length+2;i++){
    		if(!checked[i]) 
    			return i;
    	}
    	return -1;
    }
}

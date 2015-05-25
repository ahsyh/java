package com.leetcode.q152;

public class Solution {
    public int maxProduct(int[] nums) {

    	int N = 0;
    	int P = 0;
    	
    	int max = nums[0];
    	for(int i=0;i<nums.length;i++){
    	    if(nums[i]>max)
    	        max = nums[i];
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		int n = nums[i];
    		int newN=0;
    		int newP=0;

    		if(n>0){
    			if(n>n*P){
    				newP=n;
    			}
    			else{
    				newP=n*P;
    			}
    			
    			if(N<n*N){
    				newN=N;
    			}
    			else{
    				newN=n*N;
    			}
    		}
    		else{
   				newP=N*n;
    			
    			if(P*n<n){
    				newN=P*n;
    			}
    			else{
    				newN=n;
    			}
    		}
    		
    		P=newP;
    		N=newN;

    		if(P!=0&&P>max)
    			max = P;
    	}
    	
    	return max;
    }
}


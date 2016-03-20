package com.leetcode.q011;

public class Solution {
	private int min(int a, int b){
		return (a>b)?b:a;
	}

	private int max(int a, int b){
		return (a>b)?a:b;
	}

	public int maxArea(int[] height) {
    	int maxSize=0;
    	int left = 0;
    	int right = height.length-1;
    	
    	while(left<right){
    		maxSize=max(maxSize, min(height[left],height[right])*(right-left));
    		if(height[left]<height[right]){
    			left++;
    		}
    		else{
    			right--;
    		}
    		
    	}
    	
    	return maxSize;
    }
}

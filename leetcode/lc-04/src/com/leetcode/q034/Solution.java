package com.leetcode.q034;

public class Solution {
    public int searchInsert(int[] A, int target) {
		if(A.length==0)
			return -1;
		
		int left = 0;
		int right = A.length;
		
		while(left<=right){
			if((right-left)<5){
				for(int i=left;i<=right;i++){
					if(A[i]>=target)
						return i;
				}
				return right+1;
			}
			
			int mid = (left+right)/2;
			
			if(A[mid]==target)
				return mid;
			else if(A[mid]>target)
				right = mid;
			else
				left = mid;
		}
		
		return 0;
    }
}

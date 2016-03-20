package com.leetcode.q033;

public class Solution {
	private int getLPos(int[] A, int target){
		if(A.length==0)
			return -1;
		
		if(A.length==1){
			if(A[0]==target)
				return 0;
			else
				return -1;
		}

		int left=0;
		int right = A.length-1;
		
		if(A[left]==target){
			return left;
		}
		
		while(left<right){
			if((right-left)<5){
				for(int i=left;i<=right;i++){
					if(A[i]==target)
						return i;
				}
				return -1;
			}
			
			int mid = (left+right)/2;
			
			if(A[mid]<target){
				left = mid;
			}
			else
				right = mid;
		}
		return 0;
	}

	private int getRPos(int[] A, int target){
		if(A.length==0)
			return -1;
		
		if(A.length==1){
			if(A[0]==target)
				return 0;
			else
				return -1;
		}

		int left=0;
		int right = A.length-1;
		
		if(A[right]==target){
			return right;
		}
		
		while(left<right){
			if((right-left)<5){
				for(int i=right;i>=left;i--){
					if(A[i]==target)
						return i;
				}
				return -1;
			}
			
			int mid = (left+right)/2;
			
			if(A[mid]>target){
				right = mid;
			}
			else
				left = mid;
		}
		return 0;
	}

	public int[] searchRange(int[] A, int target) {
    	int[] result = new int[2];
    	
    	result[0] = getLPos(A,target);
    	if(result[0]==-1)
    		result[1]=-1;
    	else
    		result[1] = getRPos(A,target);
    	
    	return result;
    }
}

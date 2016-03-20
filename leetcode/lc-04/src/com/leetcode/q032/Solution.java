package com.leetcode.q032;

public class Solution {
	private void getEdge(int[] A, int[] pos){
        int v_p3;
        int p_p1=0,p_p2,p_p3,p_p4=0;

        int length = A.length;

        v_p3 = A[0];
        p_p3 = 0;
        p_p2 = length-1;
        
        int left=0;
        int right=length-1;
        while(left<right){
        	if(left==right-1){
        		p_p4=left;
        		p_p1=right;
        		break;
        	}
        	int mid = (left+right)/2;
        	if(A[mid]>v_p3)
        		left = mid;
        	else
        		right = mid;
        }
        
        pos[0]=p_p1;
        pos[1]=p_p2;
        pos[2]=p_p3;
        pos[3]=p_p4;
        
        return;
	}
	
	private int getPos(int[] A, int left, int right, int target){
		if(A[left]==target)
			return left;
		if(A[right]==target)
			return right;
		if(A[left]>target||A[right]<target)
			return -1;
		
		while(left<(right-1)){
			int mid = (left+right)/2;
			if(A[mid]==target)
				return mid;
			else if(A[mid]>target)
				right=mid;
			else
				left=mid;
		}
		
		return -1;
	}

	public int search(int[] A, int target) {
        
        int length = A.length;
        
        if(length<5){
        	for(int i=0;i<length;i++){
        		if(A[i]==target)
        			return i;
        	}
        	return -1;
        }
        
        if(A[0]<A[length-1])
        	return getPos(A,0,length-1,target);
        
        int[] pos = new int[4];
        getEdge(A,pos);
        
        if(target<=A[pos[1]])
        	return getPos(A,pos[0],pos[1],target);
        else
        	return getPos(A,pos[2],pos[3],target);
    }
}

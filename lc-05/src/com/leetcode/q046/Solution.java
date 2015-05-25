package com.leetcode.q046;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	private void reverseNum(int[] num, int l, int r){
		if(l<0)
			return;
		if(r>=num.length)
			return;
		
		while(l<r){
			int tmp = num[l];
			num[l] = num[r];
			num[r] = tmp;
			l++;
			r--;
		}
	}

	private boolean nextPermute(int[] num){
		//find the longest descent sequence
		int size = num.length;
		int i=size-2;
		for(;i>=0;i--){
			if(num[i]<num[i+1])
				break;
		}
		if(i<0)
			return false;
		
		reverseNum(num,i+1,size-1);
		
		int pos = i;
		
		while(num[i]<=num[pos])
			i++;
		
		int tmp = num[i];
		num[i] = num[pos];
		num[pos] = tmp;
		
		return true;
	}
	
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	//sort number
    	Arrays.sort(num);
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	do{
    		ArrayList<Integer> one = new ArrayList<Integer>();
    		for(int i=0;i<num.length;i++){
    			one.add(num[i]);
    		}
    		res.add(one);
    		
    	}while(nextPermute(num));

    	return res;
    }
}

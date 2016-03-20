package com.leetcode.q045;

import java.util.ArrayList;


public class Solution {
	private void swap(int[] num, int l,int r){
		if(l==r)
			return;
		int val = num[l];
		num[l] = num[r];
		num[r]= val;	
	}

	private void lpermute(ArrayList<ArrayList<Integer>> res, int[] num, int curr){
		if(curr>=num.length-1){
			ArrayList<Integer> one = new ArrayList<Integer>();
			for(int i=0;i<num.length;i++){
				one.add(num[i]);
			}
			res.add(one);
			return;
		}
		
		for(int i=curr;i<num.length;i++){
			swap(num,curr,i);
			lpermute(res,num,curr+1);
			swap(num,curr,i);
		}
	}
    
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	
    	lpermute(res,num,0);

    	return res;
    }
}


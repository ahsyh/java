package com.leetcode.q038;

import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
	
	private void searchSum(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> one, int[] candidates, int target){
		if(target<candidates[0])
			return;
		
		int size = one.size();
		for(int i=0;i<candidates.length;i++){
			if(candidates[i]>target)
				return;
			else if(candidates[i]==target){
// 				if(size==0||(size>0&&candidates[i]>=one.get(size-1))){
					one.add(candidates[i]);
					res.add(new ArrayList<Integer>(one));
					one.remove(size);
//				}
				return;
			}
			else if(size>0&&candidates[i]<one.get(size-1)){
				continue;
			}
			else{
				if(target-candidates[i]>=candidates[i]){
					one.add(candidates[i]);
					searchSum(res,one,candidates,target-candidates[i]);
					one.remove(size);
				}
			}
		}
		
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>	one = new ArrayList<Integer>();
        
        searchSum(res, one, candidates, target);
        
        return res;
    }
}

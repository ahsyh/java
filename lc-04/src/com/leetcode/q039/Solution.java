package com.leetcode.q039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Solution {
	public class ComparatorInt implements Comparator<Integer> {

		public int compare(Integer arg0, Integer arg1) {
			return arg0.compareTo(arg1);
		}

	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<ArrayList<ArrayList<Integer>>>();
    	for(int i=0;i<target+1;i++){
    		res.add(new ArrayList<ArrayList<Integer>>());
    	}
    	
    	
    	Arrays.sort(num);
    	for(int i=num.length-1; i>=0; i-- ){
    		for(int j=target;j>0;j--){
    			int val = num[i];
    			
    			if(val>j)
    				continue;
    			else if(val==j){
    				ArrayList<Integer> tmp =  new ArrayList<Integer>();
    				tmp.add(val);
    				if(!res.get(j).contains(tmp))
    					res.get(j).add(tmp);
    			}
    			else{
    				//val < j
        			int low = j-val;
    				for(ArrayList<Integer> x: res.get(low)){
    					ArrayList<Integer> tmp = new ArrayList<Integer>(x);
    					tmp.add(val);
    					tmp.sort(new ComparatorInt());
        				if(!res.get(j).contains(tmp))
        					res.get(j).add(tmp);
    				}
    			}
    		}
    	}
    	
    	return res.get(target);
    }
}

package com.leetcode.q001;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	//
    	int[] res = new int[2];
    	
    	HashMap<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
    	
    	for(int i=0;i<numbers.length;i++){
    		if(map.containsKey(numbers[i])){
    			map.get(numbers[i]).add(i);
    		}
    		else{
    			LinkedList<Integer> a = new LinkedList<Integer>();
    			a.add(i);
    			map.put(numbers[i], a);
    		}
    	}

    	for(int i=0;i<numbers.length;i++){
    		int left = target - numbers[i];
    		
    		if(map.containsKey(left)){
    			if(left!=numbers[i]){
        			int b=map.get(left).getFirst();
        			if(b>i){
            			res[0]=i+1;
        				res[1]=b+1;
        			}
        			else{
        				res[0]=b+1;
        				res[1]=i+1;
        			}
        			break;
    			}
    			else{
    				int length = map.get(left).size();
    				if(length<=1)
    					continue;
    				else{
    					int a,b;
    					a=map.get(left).getFirst();
    					b=map.get(left).getLast();
    					if(a>b){
                			res[0]=b+1;
            				res[1]=a+1;
    					}
    					else{
                			res[0]=a+1;
            				res[1]=b+1;
    					}
    				}
    			}
    		}

    	}
    	

    	return res;
    }
}
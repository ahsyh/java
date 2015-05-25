package com.leetcode.q015;

import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// sort array
		Arrays.sort(num);

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < num.length - 2; i++) {
			if(i>0&&num[i]==num[i-1])
				continue;

			int left = i+1;
			int right = num.length-1;
			while(left<right){
				int tmp = num[left] + num[right] + num[i];
				if(tmp==0){
					//check if same with last 
					int index = res.size()-1;
					if(res.size()>0
							&&res.get(index).get(0)==num[i]
							&&res.get(index).get(1)==num[left]
							&&res.get(index).get(2)==num[right]
							){
						
					}
					else{
						ArrayList<Integer> each = new ArrayList<Integer>();
						each.add(num[i]);
						each.add(num[left]);
						each.add(num[right]);
						res.add(each);
					}
					left++;
					right--;
				}
				else if(tmp<0)
					left ++;
				else
					right --;
			}

		}

		return res;
	}
}

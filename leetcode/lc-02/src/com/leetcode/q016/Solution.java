package com.leetcode.q016;

import java.util.Arrays;

public class Solution {
	private int mabs(int a, int b, int c, int t){
		int n = a+b+c-t;
		if(n<0)	n=-n;
		return n;
	}

	public int threeSumClosest(int[] num, int target) {
		// sort array
		Arrays.sort(num);

		int res = num[0]+num[1]+num[2];
		int gap = mabs(num[0],num[1],num[2],target);

		for (int i = 0; i < num.length - 2; i++) {
			if(i>0&&num[i]==num[i-1])
				continue;

			int left = i+1;
			int right = num.length-1;
			while(left<right){
				int tmp = num[left] + num[right] + num[i];
				int t1 = mabs(num[i],num[left],num[right],target);
				if(t1<gap){
					gap = t1;
					res = tmp;
				}
				if(tmp==target){
					return target;
				}
				else if(tmp<target)
				{
					left ++;
				}
					
				else
					right --;
			}

		}

		return res;        
    }
}

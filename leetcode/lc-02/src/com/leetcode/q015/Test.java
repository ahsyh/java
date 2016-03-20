package com.leetcode.q015;

import java.util.ArrayList;

public class Test {
	static void test1(int[] num){
		Solution s = new Solution();
		ArrayList<ArrayList<Integer>> d = s.threeSum(num);
		System.out.println(d.toString());
	}

	public static void main(String[] args){
		test1(new int[]{-1,0,1,2,-1,-4});
		return;
	}
}

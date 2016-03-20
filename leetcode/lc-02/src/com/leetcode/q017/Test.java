package com.leetcode.q017;

public class Test {
	static void test1(int[] num,int t){
		Solution s = new Solution();
		
		System.out.println(s.fourSum(num, t).toString());
	}

	public static void main(String[] args){
		test1(new int[]{-1,0,1,0,2,-2},0);
		test1(new int[]{1,1},2);
		return;
	}
}
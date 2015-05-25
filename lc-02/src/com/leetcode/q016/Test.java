package com.leetcode.q016;


public class Test {
	static void test1(int[] num,int t){
		Solution s = new Solution();
		
		System.out.println(s.threeSumClosest(num, t));
	}

	public static void main(String[] args){
		test1(new int[]{-1,0,1,2,-1,-4},1);
		test1(new int[]{1,1,1,0},-100);
		return;
	}
}


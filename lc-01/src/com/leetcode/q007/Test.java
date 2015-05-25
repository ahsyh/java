package com.leetcode.q007;

import com.leetcode.q007.Solution;

public class Test {
	static void test1(int ss){
		Solution s = new Solution();
		int d = s.reverse(ss);
		System.out.println(d);
	}

	public static void main(String[] args){
		test1(0);
		test1(1234);
		test1(2345);
		test1(9876);
		test1(-1234);
		test1(-2345);
		test1(-9876);
		return;
	}
}

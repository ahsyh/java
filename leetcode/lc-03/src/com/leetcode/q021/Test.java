package com.leetcode.q021;

public class Test {
	static void test1(int n){
		Solution s = new Solution();

		System.out.println(s.generateParenthesis(n).toString());
	}

	public static void main(String[] args){
		test1(3);
		return;
	}
}

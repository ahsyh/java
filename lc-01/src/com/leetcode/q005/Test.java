package com.leetcode.q005;

public class Test {
	static void test1(String ss){
		Solution s = new Solution();
		String res = s.longestPalindrome(ss);
		System.out.println(res);
	}

	public static void main(String[] args){
		test1("aaaabaaa");
		test1("aaaa");
		test1("abc");
		return;
	}
}

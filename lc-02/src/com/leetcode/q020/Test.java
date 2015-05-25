package com.leetcode.q020;

public class Test {
	static void test1(String ss){
		Solution s = new Solution();

		if(s.isValid(ss))
			System.out.println("yes");
		else
			System.out.println("no");
	}

	public static void main(String[] args){
		test1("{}");
		test1("(){}");
		test1("(){[]}");
		test1("()){[]}");
		test1("{}{{}}");
		return;
	}
}

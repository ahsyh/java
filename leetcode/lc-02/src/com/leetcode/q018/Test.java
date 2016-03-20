package com.leetcode.q018;


public class Test {
	static void test1(String digits){
		Solution s = new Solution();
		
		System.out.println(s.letterCombinations(digits).toString());
	}

	public static void main(String[] args){
		test1("23");
		return;
	}
}
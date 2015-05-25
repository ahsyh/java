package com.leetcode.q151;

public class Test {
	public static void main(String args[]){
		Solution s = new Solution();
		
		System.out.println(s.reverseWords(""));
		System.out.println(s.reverseWords(" 1"));
		System.out.println(s.reverseWords("it is a testing sentence"));
		System.out.println(s.reverseWords(" "));
	}

}

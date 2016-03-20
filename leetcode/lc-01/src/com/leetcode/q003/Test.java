package com.leetcode.q003;

public class Test {
	static void test1(String ss){

		Solution s = new Solution();
		int d = s.lengthOfLongestSubstring(ss);
		System.out.println(d);
	}

	public static void main(String[] args){
		test1("hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac");
		test1("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco");
		test1("a");
		test1("aaaa");
		test1("abc");
		return;
	}
}
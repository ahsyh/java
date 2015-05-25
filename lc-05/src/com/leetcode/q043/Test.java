package com.leetcode.q043;

public class Test {
	private static long now=0;
	private static void test(String s1, String s2){
		Solution s = new Solution();
		
		if(s.isMatch(s1, s2)){
			System.out.println("["+s1+"] ["+s2+"] match" );	
		}
		else{
			System.out.println("["+s1+"] ["+s2+"] not match" );	
		}
	}
	
	private static void printTime(){
		long t=System.nanoTime();
		//long t=System.currentTimeMillis();
		if(now!=0){
			System.out.println((t-now)/100000);
		}
		now = t;
	}

	public static void main(String[] argss) {
		printTime();
		test("aa","a");
		printTime();
		test("aa","aa");
		printTime();
		test("aaa","aa");
		printTime();
		test("aa","*");
		printTime();
		test("a","a*");
		printTime();
		test("aa","a*");
		printTime();
		test("ab","?*");
		printTime();
		test("aab","*ab");
		printTime();
		test("aab","*b");
		printTime();
		test("aab","c*a*b");
		printTime();
		test("","");
		printTime();
		test("abc","");
		printTime();
		test("","*");
		printTime();
		test("","*?");
		printTime();
		test("aaacaacc","*b*");
		printTime();
		test("acbbaabac", "a****bc");
		printTime();
		test("baaaaba", "a*baa*");
		printTime();		
		test("c", "*?*");
		test("c", "*?****");
		test("c", "??");
		printTime();
	}
}

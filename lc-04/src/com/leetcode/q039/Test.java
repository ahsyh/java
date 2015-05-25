package com.leetcode.q039;

import java.util.ArrayList;


public class Test {
	private static void test(int[] can, int t){
		Solution s1 = new Solution();
		
		ArrayList<ArrayList<Integer>> res = s1.combinationSum2(can, t);
		
		for(ArrayList<Integer> one : res){
			System.out.print("{");
			for(Integer i:one){
				System.out.print(i.toString()+",");
			}
			System.out.println("}");
		}
					
	}

	public static void main(String[] argss) {
		test(new int[]{1,1,2,5,6,7,10},8);
		
	}
}

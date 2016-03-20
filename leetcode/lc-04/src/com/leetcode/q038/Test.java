package com.leetcode.q038;

import java.util.ArrayList;

public class Test {
	private static void test(int[] can, int t){
		Solution s1 = new Solution();
		
		ArrayList<ArrayList<Integer>> res = s1.combinationSum(can, t);
		
		for(ArrayList<Integer> one : res){
			System.out.print("{");
			for(Integer i:one){
				System.out.print(i.toString()+",");
			}
			System.out.println("}");
		}
					
	}

	public static void main(String[] argss) {
		test(new int[]{2,3,7},7);
	}
}


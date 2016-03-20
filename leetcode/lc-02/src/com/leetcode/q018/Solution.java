package com.leetcode.q018;

import java.util.ArrayList;

public class Solution {
	char[][] letters = new char[][]{
			{' '},
			{'$'},
			{'a','b','c'},
			{'d','e','f'},
			{'g','h','i'},
			{'j','k','l'},
			{'m','n','o'},
			{'p','q','r','s'},
			{'t','u','v'},
			{'w','x','y','z'}
	};
	
    public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		StringBuffer oneRes = new StringBuffer();
		
		generateCombinations(res, oneRes, digits, 0);
		
		return res;
    }
	
	private void generateCombinations(ArrayList<String> res, StringBuffer oneRes, String d, int pos){
		if(pos>=d.length()){
			res.add(oneRes.toString());
			return;
		}
		
		int n=d.charAt(pos)-'0';
		
		for(int i=0;i<letters[n].length;i++){
			if(letters[n][i]!='$'){
				if(oneRes.length()<pos+1){
					oneRes.append(letters[n][i]);
				}
				else{
					oneRes.setCharAt(pos, letters[n][i]);
				}
				generateCombinations(res,oneRes,d,pos+1);
			}
		}
		
		return;
	}
}


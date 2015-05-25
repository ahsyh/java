package com.leetcode.q029;

import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int wordLen;
		int wordNum;

		if (L.length <= 0 || S.length() <= 0) {
			return res;
		}
		wordLen = L[0].length();
		wordNum = L.length;
		if (wordLen == 0) {
			return res;
		}
		if (S.length() < wordLen * wordNum) {
			return res;
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < L.length; i++) {
			if (map.containsKey(L[i])) {
				int j = map.get(L[i]) + 1;
				map.put(L[i], j);
			} else
				map.put(L[i], 1);
		}

		HashMap<String, Integer> check = new HashMap<String, Integer>();

		for (int i = 0; i <= S.length() - wordLen * wordNum; i++) {
			for (String e : map.keySet()) {
				check.put(e, 0);
			}
			int j;
			for (j = 0; j < wordNum; j++) {
				int k = i + j * wordLen;
				String pat=new String(S.substring(k, k + wordLen));
				if (map.containsKey(pat)) {
					int val = check.get(pat);
					int max = map.get(pat);
					if (val < max) {
						val++;
						check.put(pat, val);
					} else
						break;
				} else {
					break;
				}

			}
			if (j >= wordNum)
				res.add(i);
		}

		return res;
	}
}

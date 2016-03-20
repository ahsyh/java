package com.leetcode.q017;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	class pair {
		int first;
		int second;

		public pair(int a, int b) {
			first = a;
			second = b;
		}
	}

	class OneResult {
		int no1;
		int no2;
		int no3;
		int no4;

		OneResult(int p1, int p2, int p3, int p4) {
			int[] tmp = new int[] { p1, p2, p3, p4 };
			Arrays.sort(tmp);
			no1 = tmp[0];
			no2 = tmp[1];
			no3 = tmp[2];
			no4 = tmp[3];
		}

		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}

			if (o.getClass() == OneResult.class) {
				OneResult n = (OneResult) o;
				return (n.no1 == no1) && (n.no2 == no2) && (n.no3 == no3)
						&& (n.no4 == no4);
			}
			return false;
		}

		public int hashCode() {
			return no1 + no2 * 10000 + no3 * 20000 + no4 * 30000;
		}
	}

	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// sort array
		Arrays.sort(num);

		Map<Integer, ArrayList<pair>> map = new HashMap<Integer, ArrayList<pair>>();
		// Map<Integer, Integer> checked = new HashMap<Integer, Integer>();
		Set<Integer> checked = new HashSet<Integer>();
		Set<OneResult> res_set = new HashSet<OneResult>();

		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int n = num[i] + num[j];
				ArrayList<pair> val;
				if (map.containsKey(n)) {
					val = map.get(n);
					val.add(new pair(i, j));
				} else {
					val = new ArrayList<pair>();
					val.add(new pair(i, j));
					map.put(n, val);
				}
			}
		}

		for (int e : map.keySet()) {
			int p = target - e;

			if (checked.contains(p))
				continue;
			if (checked.contains(e))
				continue;
			checked.add(p);
			checked.add(e);

			int i1 = 0;
			int i2 = 0;
			ArrayList<pair> array1 = map.get(e);
			ArrayList<pair> array2 = map.get(p);
			if (array1 == null || array2 == null)
				continue;

			for (i1 = 0; i1 < array1.size(); i1++) {
				for (i2 = 0; i2 < array2.size(); i2++) {
					if(e==p&&i1==i2)
						continue;

					int a1 = array1.get(i1).first;
					int a2 = array1.get(i1).second;
					int b1 = array2.get(i2).first;
					int b2 = array2.get(i2).second;

					if ((a1 == b1) || (a1 == b2) || (a2 == b1) || (a2 == b2)) {

					} else {
						OneResult res = new OneResult(num[a1], num[a2],
								num[b1], num[b2]);
						res_set.add(res);
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (OneResult e : res_set) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(e.no1);
			tmp.add(e.no2);
			tmp.add(e.no3);
			tmp.add(e.no4);
			res.add(tmp);
		}

		return res;
	}
}

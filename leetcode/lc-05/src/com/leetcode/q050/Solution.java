package com.leetcode.q050;

import java.util.ArrayList;

public class Solution {
	private void collect(ArrayList<String[]> res, int[] rows, int row, int rd, int ld, int curr, int n){
		if(curr>=n){
			StringBuffer oneLine = new StringBuffer();
			String[] one = new String[n];
			for(int i=0;i<n;i++){
				oneLine.append('.');
			}
			for(int i=0;i<n;i++){
				int cursor = 1;
				for(int j=0;j<n;j++){
					if((cursor&rows[i])>0)
						oneLine.setCharAt(j, 'Q');
					else
						oneLine.setCharAt(j, '.');
					cursor<<=1;
				}
				
				one[i] = new String(oneLine);
			}
			res.add(one);
			return;
		}
		
		int mask = ~(~0<<n);
		int avail = (~(row|rd|ld))&mask;
		
		int pos;
		while(avail>0){
			pos = avail & (-1*avail);
			avail -= pos;
			rows[curr] = pos;
			collect(res, rows, row|pos, (rd|pos)<<1, (ld|pos)>>1, curr+1, n);
		}
	}

	public ArrayList<String[]> solveNQueens(int n) {
		int[] rows = new int[n];
    	ArrayList<String[]> res = new ArrayList<String[]>();

    	collect(res, rows, 0, 0, 0, 0, n);
    			
    	return res;
    }
}


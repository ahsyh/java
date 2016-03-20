package com.leetcode.q051;

public class Solution {
	private void collect(int[] res, int row, int rd, int ld, int curr, int n){
		if(curr>=n){
			res[0]++;
			return;
		}
		
		int mask = ~(~0<<n);
		int avail = (~(row|rd|ld))&mask;
		
		int pos;
		while(avail>0){
			pos = avail & (-1*avail);
			avail -= pos;
			collect(res, row|pos, (rd|pos)<<1, (ld|pos)>>1, curr+1, n);
		}
	}

	public int totalNQueens(int n) {
		int[] res = new int[1];
		res[0] = 0;

    	collect(res, 0, 0, 0, 0, n);
    			
    	return res[0];
    }
}


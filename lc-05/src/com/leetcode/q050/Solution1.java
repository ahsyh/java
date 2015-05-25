package com.leetcode.q050;

import java.util.ArrayList;

public class Solution1 {
	private boolean valid(StringBuffer[] one, int curr, int pos){
		int n = one.length;
		
		for(int i=0;i<curr;i++){
			//compare no.i and no.curr
			if(one[i].charAt(pos)=='Q')
				return false;
			//TODO: two position of diagonal
			int diag_a,diag_b;
			
			diag_a = pos - (curr-i);
			diag_b = pos + (curr-i);
			if(diag_a>=0&&one[i].charAt(diag_a)=='Q')
				return false;
			if(diag_b<n&&one[i].charAt(diag_b)=='Q')
				return false;
		}

		return true;
	}

	private void searchAll(ArrayList<String[]> res, StringBuffer[] one, int curr){
		int n = one.length;
		
		if(curr>=n){
			String[] tmp = new String[n];
			for(int i=0;i<n;i++){
				tmp[i]=new String(one[i].toString());
			}
			res.add(tmp);
			return;
		}
		
		for(int i=0;i<n;i++){
			one[curr].setCharAt(i, 'Q');
			if(valid(one, curr, i))
				searchAll(res,one,curr+1);
			one[curr].setCharAt(i, '.');
		}
		
	}

	public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> res = new ArrayList<String[]>();
    	
    	StringBuffer[] one = new StringBuffer[n];
    	for(int i=0;i<n;i++){
    		one[i] = new StringBuffer();
    		for(int j=0;j<n;j++){
    			one[i].append('.');
    		}
    	}

    	searchAll(res,one,0);
    	
    	return res;
    }
}

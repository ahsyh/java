package com.leetcode.q053;

import java.util.ArrayList;

public class Solution {
	private void onesideOrder(ArrayList<Integer> res, 
			int[][] matrix, 
			int left, int top, int right, int bottom, int dir ){
		
//         --> 0		
//  -------------------
//  |                 |
//3 |                 |
//  |                 | 1
//  |                 |
//  -------------------
//        2 <--

		int a1, b1;
		
		a1 = b1 = 0;
		
		switch(dir){
		case 0:
			a1 = top;
			b1 = left;
			break;
		case 1:
			a1 = top;
			b1 = right;
			break;
		case 2:
			a1 = bottom;
			b1 = right;
			break;
		case 3:
			a1 = bottom;
			b1 = left;
			break;
		default:
			break;
		}
		
		boolean stop = false;
		while(!stop){
			res.add(matrix[a1][b1]);
			switch(dir){
			case 0:
				b1++;
				if(b1>right)
					stop = true;
				break;
			case 1:
				a1++;
				if(a1>bottom)
					stop=true;
				break;
			case 2:
				b1--;
				if(b1<left)
					stop=true;
				break;
			case 3:
				a1--;
				if(a1<top)
					stop=true;
				break;
			}
		}
		
		switch(dir){
		case 0:
			if(top==bottom)
				return;
			onesideOrder(res,matrix, 
					left, top+1, right, bottom, 
					1);
			break;
		case 1:
			if(left==right)
				return;
			onesideOrder(res,matrix, 
					left, top, right-1, bottom, 
					2);
			break;
		case 2:
			if(top==bottom)
				return;
			onesideOrder(res,matrix, 
					left, top, right, bottom-1, 
					3);
			break;
		case 3:
			if(left==right)
				return;
			onesideOrder(res,matrix, 
					left+1, top, right, bottom, 
					0);
			break;
		default:
			break;
		}
	}

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	
    	int bottom = matrix.length;
    	if(bottom==0)
    		return res;
    	int right = matrix[0].length;
    	if(right==0)
    		return res;

    	onesideOrder(res, matrix, 0, 0, right-1, bottom-1, 0 );
    	return res;
    }
}

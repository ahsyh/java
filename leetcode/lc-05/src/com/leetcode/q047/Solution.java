package com.leetcode.q047;

public class Solution {
	private enum TypeEnum { Odd, Even } ;

	private void rotateFourPoint(int[][] matrix,int i,int j, TypeEnum type){
		int x2, y2, x3, y3, x4, y4;
		int mid;
		
		if(type==TypeEnum.Odd){
			mid = matrix.length/2;
			
			int a = i-mid;
			int b = j-mid;
			
			x2 = b + mid;
			y2 = -1*a +mid;
			x3 = -1*a + mid;
			y3 = -1*b + mid;
			x4 = -1*b + mid;
			y4 = a + mid;
		}
		else{
			mid = matrix.length-1;
			
			int a = 2*i-mid;
			int b = 2*j-mid;
			
			x2 = (b + mid)/2;
			y2 = (-1*a +mid)/2;
			x3 = (-1*a + mid)/2;
			y3 = (-1*b + mid)/2;
			x4 = (-1*b + mid)/2;
			y4 = (a + mid)/2;
		}
		
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[x4][y4];
		matrix[x4][y4] = matrix[x3][y3];
		matrix[x3][y3] = matrix[x2][y2];
		matrix[x2][y2] = tmp;
	}

    public void rotate(int[][] matrix) {
        TypeEnum type;
        
        if(matrix.length==0||matrix.length!=matrix[0].length)
        	return;

        if(matrix.length%2==1)
        	type = TypeEnum.Odd;
        else
        	type = TypeEnum.Even;
        
        int size;
        size = (type==TypeEnum.Odd)?matrix.length/2+1:matrix.length/2;
        if(type==TypeEnum.Odd){
            for(int i=0;i<size-1;i++){
            	for(int j=0;j<size;j++){
            		rotateFourPoint(matrix,i,j,type);
            	}
            }
        }
        else{
            for(int i=0;i<size;i++){
            	for(int j=0;j<size;j++){
            		rotateFourPoint(matrix,i,j,type);
            	}
            }
        }
        return;
    }
}


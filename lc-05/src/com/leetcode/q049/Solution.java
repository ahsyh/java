package com.leetcode.q049;

public class Solution {
    public double pow(double x, int n) {
    	if(n==0)
    		return 1;

    	boolean minus = false;
    	if(n<0){
    		n *= -1;
    		minus = true;
    	}
    	
    	double xn =  x;
    	double res =  1;
    	
    	while(n>0){
    		if( (n & 0x1) == 1)
    			res = res*xn;
    		xn *= xn;
    		n >>= 1;
    	}
        
    	if(minus) res=1/res;
    	return res;
    }
}

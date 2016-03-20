package com.leetcode.q028;

public class Solution {
    public int mdivide(long a, long b) {
    	long dividend=a; 
    	long divisor=b;

    	long factor=1;
        
        if(dividend<divisor)
        	return 0;
        
        
    	while(true){
    		if((divisor<<1)<dividend){
    			divisor = divisor<<1;
    			factor = factor <<1;
    		}
    		else
    			break;
    	}
    	
    	dividend -= divisor;
    	return (int)factor + mdivide((int)dividend,b);
    }

    public int divide(int a, int b) {
    	int sign1, sign2, sign;
    	long dividend=a;
    	long divisor =b;   	

    	if(dividend<0){
    		sign1=-1;
    		dividend = 0-dividend;
    	}
    	else
    		sign1=1;

    	if(divisor<0){
    		sign2=-1;
    		divisor = 0 -  divisor;
    	}
    	else
    		sign2=1;

    	if(sign1==sign2)
    		sign=1;
    	else
    		sign=-1;
    	
    	int result = mdivide(dividend, divisor);
    	if(sign==-1)
    		result = 0-result;

    	return result;
    }
}

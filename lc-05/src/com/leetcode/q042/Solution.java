package com.leetcode.q042;

public class Solution {
    public String multiply(String num1, String num2) {
    	String n1 = (new StringBuffer(num1)).reverse().toString();
    	String n2 = (new StringBuffer(num2)).reverse().toString();
    	
    	int length1 = num1.length();
    	int length2 = num2.length();
    	
    	int[] iResult = new int[length1+length2];
    	for(int i=0;i<length1+length2;i++){
    		iResult[i]=0;
    	}

    	for(int i=0;i<length1;i++){
    		for(int j=0;j<length2;j++){
    			iResult[i+j] += (n1.charAt(i)-'0')*(n2.charAt(j)-'0');
    		}
    	}
    	
    	int carryon=0;
    	for(int i=0;i<length1+length2;i++){
    		iResult[i]+=carryon;
    		carryon = iResult[i]/10;
    		iResult[i] = iResult[i] - carryon*10;
    	}
    	
    	StringBuffer res= new StringBuffer();
    	int i=length1+length2-1;
    	while(i>=0){
    		if(iResult[i]!=0)
    			break;
    		i--;
    	}
    	if(i<0)
    	    return new String("0");

    	for(;i>=0;i--)
    		res.append(Integer.toString(iResult[i]));   	
    		
    	return res.toString();
    }
}
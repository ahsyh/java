package com.leetcode.q020;

public class Solution {
	boolean match(char a, char b){
		if (a=='('&&b==')')
			return true;
		if (a=='{'&&b=='}')
			return true;
		if (a=='['&&b==']')
			return true;
		return false;
	}

	public boolean isValid(String s) {
    	int n=s.length();
    	if((n%2)==1)
    		return false;
    	
    	boolean result[][] = new boolean[n+1][n+1];
        for(int j=0;j<=n;j+=2){
        	for(int i=0;i<=n-j;i++){
        		if(j==0){
        			result[i][j]=true;
        			continue;
        		}
    			result[i][j]=false;
        		if(match(s.charAt(i),s.charAt(i+j-1))){
        			if(result[i+1][j-2]){
        				result[i][j]=true;
        				continue;
        			}
        		}
        		
        		{
        			for(int k=2;k<j;k+=2){
        				if(result[i][k]&&result[i+k][j-k]){
            				result[i][j]=true;
            				continue;
        				}
        			}
        		}
        	}
        }
    	
        return result[0][n];
    }
}

package com.leetcode.q043;

public class Solution {
	public static final int sampleLength=1000;
	public static final int patternLength=100;
	boolean[][] result= new boolean[sampleLength][patternLength]; 

	private String checkPattern(String p){
		StringBuffer t=new StringBuffer();
		char lastCh='#';
		for(int i=0;i<p.length();i++){
			if(p.charAt(i)==lastCh&&lastCh=='*'){
			}
			else{
				t.append(p.charAt(i));
				lastCh = p.charAt(i);
			}
				
		}
		
		return t.toString();
	}
	
	public boolean isMatch(String s, String p) {
		String p1 = checkPattern(p);
        int length1 = s.length();
        int length2 = p1.length();

        {
			int i = s.length();
			int j = p.length();

			if(j==0){
				if(i==0)
					return true;
				else
					return false;
			}
			if(i==0){
				if(j==1&&p1.charAt(0)=='*')
					return true;
				else
					return false;
			}
		}
        
        if(length1>sampleLength-2)
        	return false;
        if(length2>patternLength-2)
        	return false;
        
        for(int i=0;i<=length1;i++){
        	for(int j=0;j<=length2;j++){
        		if(i==0&&j==0){
        			result[i][j]=true;
        		}
        		else if(i==0){
        			if(j==1&&p1.charAt(0)=='*')
        				result[i][j]=true;
        			else
        				result[i][j]=false;
        		}
        		else if(j==0){
    				result[i][j]=false;
        		}
        		else{
        			if(p1.charAt(j-1)=='?'){
    					if(result[i-1][j-1])
    						result[i][j]=true;
    					else
    						result[i][j]=false;
        			}
        			else if(p1.charAt(j-1)=='*'){
    					if(result[i-1][j-1]||result[i-1][j]||result[i][j-1])
    						result[i][j]=true;
    					else
    						result[i][j]=false;
        			}
        			else{
        				if(s.charAt(i-1)==p1.charAt(j-1)){
        					if(result[i-1][j-1])
        						result[i][j]=true;
        					else
        						result[i][j]=false;
        				}
        				else{
    						result[i][j]=false;
        				}
        			}
        		}
        	}
        }
        
        
        return result[length1][length2];
    }
}
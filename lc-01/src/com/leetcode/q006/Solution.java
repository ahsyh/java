package com.leetcode.q006;

public class Solution {
    public String convert(String s, int nRows) {
    	if(nRows==1)
    		return s;
    	
        StringBuffer buf = new StringBuffer();
        int n = 2*nRows - 2;
        
        for(int i=0;i<nRows;i++){
        	int j=i;
        	int k=n-j;
        	while(true){
        		boolean q1,q2;
        		q1=q2=false;
        		if(j<s.length()){
        			buf.append(s.charAt(j));
        			j+=n;
        		}
        		else
        			q1=true;
        		
        		if(k!=n&&i!=k&&k<s.length()){
        			buf.append(s.charAt(k));
        			k+=n;
        		}
        		else
        			q2=true;
        		
        		if(q1&&q2)
        			break;
        	}
        }
        
        return buf.toString();
    }
}
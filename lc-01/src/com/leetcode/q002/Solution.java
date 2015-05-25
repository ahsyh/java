package com.leetcode.q002;

public class Solution {
	public void getNextInt(int A[], int B[], int[] res){
		int a,b;
		a=res[1];
		b=res[2];
		
		int select=0;//1: A, 2: B
		
		if(a>=A.length){
			select = 2;
		}
		else if(b>=B.length){
			select = 1;
		}
		else{
			if(A[a]>B[b]){
				select = 2;
			}
			else{
				select = 1;
			}
		}

		if(select==2){
			res[0]=B[b];
			res[1]=a;
			res[2]=b+1;
		}
		else if(select==1){
			res[0]=A[a];
			res[1]=a+1;
			res[2]=b;
		}
	}

	public double findMedianSortedArrays(int A[], int B[]) {
    	if(A.length==0&&B.length==0)
    		return 0F;
    	
    	if((A.length+B.length)==1){
    		if(A.length==1)
    			return A[0];
    		else
    			return B[0];
    	}
    	
    	int ext = (A.length + B.length) % 2;
        int t = (A.length + B.length)/2;
        if(ext==0)t--;
        int[] candidate=new int[]{0,0};
        int[] res=new int[]{0,0,0};

        while(t>=0){
        	getNextInt(A,B,res);
        	candidate[0]=res[0];
        	t--;
        }
        if(ext==0){
        	getNextInt(A,B,res);
        	candidate[1]=res[0];
        	return ((double)(candidate[0]+candidate[1]))/2;
        }
        return candidate[0];
    }
}

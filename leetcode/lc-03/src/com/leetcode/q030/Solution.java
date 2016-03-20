package com.leetcode.q030;

public class Solution {
	private void revertArray(int[] num, int left, int right){
		while(left<right){
			int tmp = num[left];
			num[left]=num[right];
			num[right]=tmp;
			left ++;
			right --;
		}
	}

	public void nextPermutation(int[] num) {
        //�ҵ���һ������Ҵ�
    	int pos = num.length-1;
    	boolean find = false;

    	for(;pos>0;pos--){
    		if(num[pos-1]<num[pos]){
    			find = true;
    			break;
    		}
    	}
    	if(!find){
    		//������������
    		revertArray(num,0,num.length-1);
    		return;
    	}
    	
    	revertArray(num,pos,num.length-1);
    	for(int i=num.length-1;i>=pos;i--){
    		if(num[i]>num[pos-1]&&num[i-1]<=num[pos-1]){
    			int tmp=num[pos-1];
    			num[pos-1] = num[i];
    			num[i] = tmp;
    			break;
    		}
    	}
    	
    	return;
    }
}

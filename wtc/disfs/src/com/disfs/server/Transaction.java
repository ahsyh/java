package com.disfs.server;

import java.util.BitSet;
import java.util.HashMap;
import java.io.Serializable;

public class Transaction  implements Serializable {
	private static final long serialVersionUID = -6470090944414208496L;

//Class definition	
	public BitSet seqList = null;
	public int transactionID = -1;
	public HashMap<Integer, String> tasks = null;
	public String fileName = null;
	public int maxSeq = -1;
	public int committed = 0;

	public Transaction(int id, String name) {
		seqList = new BitSet();
		fileName = name;
		transactionID = id;
		tasks = new HashMap<Integer, String>();
		maxSeq = 0;
		committed = 0;
	}
	
	public void setCommitted(int val){
		committed = val;
	}

	public int addTask(int seq, String body) {
		if (seqList.get(seq))
			return 209;
		seqList.set(seq);
		tasks.put(seq, body);
		if (seq > maxSeq)
			maxSeq = seq;
		return 0;
	}
	
	public int delTask(int seq){
		if (seqList.get(seq)){
			tasks.remove(seq);
			seqList.clear(seq);
			
			maxSeq = 0;
			for(int i = seq-1;i>0;i--){
				if(seqList.get(i)){
					maxSeq = i;
					break;
				}
			}
		
			return 0;
		}
		
		return -1;
	}

	public String getTask(int seq){
		if (seqList.get(seq)){
			return tasks.get(seq);
		}
		
		return null;
	}
	
}

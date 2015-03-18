package com.disfs.server;

import java.util.LinkedList;
import java.util.BitSet;
import java.util.Comparator;

public class TransBackup implements Comparable<TransBackup>  {
	public BitSet seqList = null;
	public int TransBackupID = -1;
	public LinkedList<Task> tasks = null;
	public String fileName = null;
	public int maxSeq = -1;

	public static LinkedList<TransBackup> allTransBackup = new LinkedList<TransBackup>();

	private static int genID = 123;

	private static class TransBackupComparator implements
			Comparator<TransBackup> {

		private static final Comparator<TransBackup> instance = new TransBackupComparator();  
		
		public static Comparator<TransBackup> getInstance() {  
	        return instance;  
	    }  
		
		public int compare(TransBackup arg0, TransBackup arg1) {
			if (arg0.TransBackupID < arg1.TransBackupID) {
				return -1;
			} else if (arg0.TransBackupID > arg1.TransBackupID) {
				return 1;
			} else {
				return 0;
			}
		}

	}

	public static synchronized int GenNewID() {
		genID++;
		return genID;
	}

	public static boolean IsIDExist(int id){
		
		allTransBackup.sort(TransBackupComparator.getInstance());

		boolean res = false;
		for(TransBackup t:allTransBackup){
			if(t.TransBackupID == id){
				res=true;
				break;
			}
		}
		return res;
	}
	
	public static int addTransBackup(TransBackup t){
		int res = -1;
		synchronized(allTransBackup){
			if(IsIDExist(t.TransBackupID)){
				res = -1;
			}
			else{
				allTransBackup.add(t);
				res = 0;
			}
		}
		return res;
	}

	public TransBackup(int id, String name) {
		seqList = new BitSet();
		fileName = name;
		TransBackupID = id;
		tasks = null;
		maxSeq = 0;
	}

	public int compareTo(TransBackup t) {
		if (this.TransBackupID < t.TransBackupID) {
			return -1;
		} else if (this.TransBackupID > t.TransBackupID) {
			return 1;
		} else {
			return 0;
		}
	}

	public int addTask(int seq, String body) {
		if (seqList.get(seq))
			return -1;
		seqList.set(seq);
		tasks.add(new Task(seq, body));
		if (seq > maxSeq)
			maxSeq = seq;
		for(Task t:tasks){
			System.out.printf("Seq:%d,Content:%s\n",t.seq,t.body);
		}
		return 0;
	}

	private class Task {
		public int seq;
		public String body;

		public Task(int seq, String body) {
			this.seq = seq;
			this.body = body;
		}
	}
}

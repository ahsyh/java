package com.disfs.server;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.*;

public class AllTransactions implements Serializable {
	private static final long serialVersionUID = -6480090944414208496L;

	public static AllTransactions instance = new AllTransactions();

	public static AllTransactions getInstance() {
		return instance;
	}

	private AllTransactions() {
	}

	// Static interface
	// 1. Transaction ID generation
	private int genID = 1;
	private Integer lock = new Integer(0);

	private synchronized int GenNewID() {
		synchronized (lock) {
			genID++;
		}
		return genID;
	}

	// 2. All transaction collection
	private HashMap<Integer, Transaction> map = new HashMap<Integer, Transaction>();

	private int add(Transaction t) {
		int res = -1;
		synchronized (map) {
			Integer i = new Integer(t.transactionID);

			if (!map.containsKey(i)) {
				map.put(i, t);
				res = 0;
			}
		}
		return res;
	}

	private Transaction get(int id) {
		Transaction res = null;
		synchronized (map) {
			Integer i = new Integer(id);

			if (map.containsKey(i)) {
				res = map.get(i);
			}
		}
		return res;
	}

	private int del(int id) {
		int res = -1;
		synchronized (map) {
			Integer i = new Integer(id);

			if (map.containsKey(i)) {
				map.remove(i);
				res = 0;
			}
			else{
				res = 216;
			}
		}
		return res;
	}

	private int check(int id, ArrayList<Integer> miss) {
		int res = 0;
		Integer i = new Integer(id);

		if (map.containsKey(i)) {
			Transaction t = map.get(i);

			for (int j = 1; j <= t.maxSeq; j++) {
				if (!t.seqList.get(j)) {
					miss.add(j);
					res = 218;
				}
			}
		}
		return res;
	}

	private int execute(int id) {
		int res = 0;
		synchronized (map) {
			Integer i = new Integer(id);
			do{
				if (!map.containsKey(i)) 
				{
					res = 216;
					break;
				}
				
				Transaction t = map.get(i);

				try {
					String filePath = Configuration.getInstance().baseDir + "/" + t.fileName;
					filePath = filePath.toString();
					File myFilePath = new File(filePath);
					if (!myFilePath.exists()) {
						myFilePath.createNewFile();
					}
					FileWriter resultFile = new FileWriter(myFilePath);
					PrintWriter myFile = new PrintWriter(resultFile);
					for (int j = 1; j <= t.maxSeq; j++) {
						myFile.println(t.tasks.get(j));
					}
					resultFile.close();
				} catch (IOException e) {
					res = 206;
				} finally{
					map.remove(i);
				}
			}while(false);

		}
		return res;
	}

	private int commit_op(int id, ArrayList<Integer> miss){
		int res = 0;

		do{
			Transaction t = get(id);
			if(t==null)
			{
				res = 216;
				break;
			}
			t.setCommitted(1);

			res = check(id,miss);
			if(res!=0)
				break;

			res = execute(id);
		}while(false);

		return res;
	}
	
	// Message handle
	public void new_txn_req(Socket socket, Message msg) {
		int res = 0;
		int id = GenNewID();

		synchronized (map) {
			add(new Transaction(id, msg.body));
		}

		switch(res){
		case 0:
			Message.reply_ack_msg(socket, id, 0);
			break;
		}
	}

	public void read_req(Socket socket, Message msg) {
		int res = 0;
		int id = msg.transaction_id;

		try {
			String filePath = Configuration.getInstance().baseDir + "/" + msg.body;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				System.out.printf("no such file: %s\n",filePath);
				res = 206;
			} else {
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		switch(res){
		case 0:
			Message.reply_ack_msg(socket, id, msg.seq_num);
			break;
		case 206:
			Message.reply_error_msg(socket, res, id, msg.seq_num);
			break;
		}
	}

	public void write_req(Socket socket, Message msg) {
		int id = msg.transaction_id;
		int res = 0;
		ArrayList<Integer> miss = new ArrayList<Integer>();

		synchronized (map) {
			Transaction t = get(id);
			if (t != null) {
				res = t.addTask(msg.seq_num, msg.body);
				if(t.committed==1){
					res = commit_op(id, miss);
				}
			} else {
				res = 216;
			}
		}

		switch(res){
		case 0:
			Message.reply_ack_msg(socket, id, msg.seq_num);
			break;
		case 218:
			if(miss!=null){
				for (Integer i : miss) {
					Message.reply_resend_msg(socket, id, i.intValue());
				}
			}
			break;
		case 205:
		case 209:
		case 216:
			Message.reply_error_msg(socket, res, id, msg.seq_num);
			break;
		}
	}

	public void abort_req(Socket socket, Message msg) {
		int id = msg.transaction_id;
		int res = del(id);
		
		switch(res){
		case 0:
			Message.reply_ack_msg(socket, id, msg.seq_num);
			break;
		case 216:
			Message.reply_error_msg(socket, res, id, msg.seq_num);
			break;
		}
	}

	public void commit_req(Socket socket, Message msg) {
		int id = msg.transaction_id;
		ArrayList<Integer> miss = new ArrayList<Integer>();
		int res = -1;

		synchronized (map) {
			res = commit_op(id,miss);
		}
		
		switch(res){
		case 0:
			Message.reply_ack_msg(socket, id, 0);
			break;
		case 218:
			if(miss!=null){
				for (Integer i : miss) {
					Message.reply_resend_msg(socket, id, i.intValue());
				}
			}
			break;
		case 205:
		case 216:
			Message.reply_error_msg(socket, res, id, msg.seq_num);
			break;
		}
	}
}

package com.disfs.server;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Handler implements Runnable { // 负责与单个客户的通信
	private Socket socket;

	public Handler(Socket socket) {
		this.socket = socket;
	}

	private BufferedReader getReader(Socket socket)throws IOException{
		return new BufferedReader(new InputStreamReader(
				socket.getInputStream(),"ISO8859_5"));
	}

	private int readMessage(BufferedReader br, char buf[], int len) throws IOException{
		int r_cnt=0;
		int off=0;
		
		Arrays.fill(buf, '\0');

		try{
			do{
				r_cnt = br.read(buf,off,len);
				if(r_cnt>0){
					off+=r_cnt;
					len-=r_cnt;
					buf[off]='\0';
				}
				else{
					break;
				}
				
				if(Message.isIntegratedMessage(buf,off)){
					System.out.printf("get one message\n");
					break;
				}

			}while(true);
			
		}catch(IOException e){
			
		}

		return off;
	}

	private void handleMessage(char buf[], int len){
		String msgbuf = String.valueOf(buf, 0, len);
		Message msg = Message.parseMessage(msgbuf);
		if(msg!=null){
			if(msg.type == Message.Type.NEW_TXN){
				AllTransactions.getInstance().new_txn_req(socket, msg);
			}
			if(msg.type == Message.Type.READ){
				AllTransactions.getInstance().read_req(socket, msg);
			}
			if(msg.type == Message.Type.WRITE){
				AllTransactions.getInstance().write_req(socket, msg);
			}
			if(msg.type == Message.Type.ABORT){
				AllTransactions.getInstance().abort_req(socket, msg);
			}
			if(msg.type == Message.Type.COMMIT){
				AllTransactions.getInstance().commit_req(socket, msg);
			}
		}
		else{
			Message.reply_error_msg(socket, 204, 0, 0);
		}
	}
	
	public void run() {
		try {
			System.out.println("New connection accepted "
					+ socket.getInetAddress() + ":" + socket.getPort());
			BufferedReader br = getReader(socket);
			int maxlen=1024;
			int len=0;
			char buf[] = new char[maxlen];
			

			while (true) { // 接收和发送数据，直到通信结束
				if((len=readMessage(br, buf, maxlen))<=0){
					break;
				}
				else{
					System.out.println(buf);
					handleMessage(buf,len);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null)
					socket.close(); // 断开连接
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}


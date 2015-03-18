package com.disfs.server;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class FSServer {
	private ServerSocket serverSocket;
	private ExecutorService executorService; // 线程池

	private boolean isShutdown = false; // 服务器是否已经关闭
	private AdminThread shutdownThread = null;
	
	public void shutdownExecutorService(){
		isShutdown = true;
		// 请求关闭线程池
		// 线程池不再接收新的任务，但是会继续执行完工作队列中现有的任务
		executorService.shutdown();

		try{
			// 等待关闭线程池，每次等待的超时时间为30秒
			while (!executorService.isTerminated())
				executorService.awaitTermination(30,
						TimeUnit.SECONDS);
			serverSocket.close(); // 关闭与EchoClient客户通信的ServerSocket
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public FSServer() throws IOException {
		serverSocket = new ServerSocket(Configuration.getInstance().serverPort);
		// 设定等待客户连接的超过时间为60秒
		//serverSocket.setSoTimeout(60000); 
		
		// 创建线程池
		executorService = Executors.newFixedThreadPool(Configuration.getInstance().poolSize);
		//Runtime.getRuntime().availableProcessors()

		shutdownThread = new AdminThread(Configuration.getInstance().adminPort, this);
		shutdownThread.start(); // 启动负责关闭服务器的线程
		System.out.println("服务器启动");
	}

	public void service() {
		while (!isShutdown) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				// 可能会抛出SocketTimeoutException和SocketException
				// 设定等待客户连接的超过时间为60秒
				socket.setSoTimeout(60000); 

				executorService.execute(new Handler(socket));
				// 可能会抛出RejectedExecutionException
			} catch (SocketTimeoutException e) {
				// 不必处理等待客户连接时出现的超时异常
			} catch (RejectedExecutionException e) {
				try {
					if (socket != null)
						socket.close();
				} catch (IOException x) {
				}
				return;
			} catch (SocketException e) {
				// 如果是由于在执行serverSocket.accept()方法时，
				// ServerSocket被ShutdownThread线程关闭而导致的异常，就退出service()方法
				if (e.getMessage().indexOf("socket closed") != -1)
					return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void loadTransactions(String fileName){
        try {
        	AllTransactions.instance = (AllTransactions) SerializationUtil.deserialize(fileName);
        	System.out.println("读取上次遗留事务记录成功");
        } catch (ClassNotFoundException | IOException e) {
            //e.printStackTrace();
        	System.out.println("未能读取上次遗留事务记录");
        }
	}

	private static void saveTransactions(String fileName){
        //serialize to file
        try {
            SerializationUtil.serialize(AllTransactions.instance, fileName);
        	System.out.println("存储遗留事务记录成功");
        } catch (IOException e) {
        	//e.printStackTrace();
        	System.out.println("存储遗留事务记录失败");
            return;
        }
	}

	public static void main(String args[]) throws IOException {
		Configuration.getInstance().readConf();
		FSServer mainServer = new FSServer();

		String fileName="Transactions.ser";
        loadTransactions(fileName);

        mainServer.service();
        
        saveTransactions(fileName);
	}
}



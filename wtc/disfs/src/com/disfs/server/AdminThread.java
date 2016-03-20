package com.disfs.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class AdminThread extends Thread{ // 负责关闭服务器的线程
	private ServerSocket serverSocketForShutdown = null;
	private FSServer myServer = null;
	private boolean isShutdown = false; // 服务器是否已经关闭
	
	public AdminThread(int port, FSServer server) throws IOException{
		serverSocketForShutdown = new ServerSocket(port);
		myServer = server;
	}

	public void start() {
		this.setDaemon(true); // 设置为守护线程（也称为后台线程）
		super.start();
	}

	public void run() {
		while (!isShutdown) {
			Socket socketForShutdown = null;
			try {
				socketForShutdown = serverSocketForShutdown.accept();
				BufferedReader br = new BufferedReader(
						new InputStreamReader(
								socketForShutdown.getInputStream()));
				String command = br.readLine();
				if (command.equals("shutdown")) {
					long beginTime = System.currentTimeMillis();
					socketForShutdown.getOutputStream().write(
							"服务器正在关闭\r\n".getBytes());
					isShutdown = true;
					// 请求关闭线程池

					myServer.shutdownExecutorService();

					long endTime = System.currentTimeMillis();
					socketForShutdown.getOutputStream()
							.write(("服务器已经关闭，" + "关闭服务器用了"
									+ (endTime - beginTime) + "毫秒\r\n")
									.getBytes());
					socketForShutdown.close();
					serverSocketForShutdown.close();

				} else {
					socketForShutdown.getOutputStream().write(
							"错误的命令\r\n".getBytes());
					socketForShutdown.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

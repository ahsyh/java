package com.disfs.client;

import java.net.Socket;
//import java.util.BitSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestClient {

	static Socket server;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
//		testBitset();
		
		
		server = new Socket(InetAddress.getLocalHost(), 8000);
		BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
		PrintWriter out=new PrintWriter(server.getOutputStream());
		BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String string = wt.readLine();
			out.println(string);
			out.flush();
			if (string.equals("bye")) {
				break;
			}
			System.out.println(in.readLine());
			System.out.println(in.readLine());
		}
		server.close();
	}
}

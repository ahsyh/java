package com.disfs.server;

import java.io.*;

public class Configuration {

	private static Configuration instance = new Configuration();

	public static Configuration getInstance() {
		return instance;
	}

	public String baseDir = null;
	public int serverPort = 7896;
	public int adminPort = 8001;
	public int poolSize = 5;

	private Configuration() {
		baseDir = new String("/home/yihuishi/share");
		serverPort = 7896;
		adminPort = 8001;
		poolSize = 5;
	}

	public void readConf() {
		readFileByLines("conf.dat");
	}

	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	private void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			// System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
//			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
//				System.out.println("line " + line + ": " + tempString);
//				line++;
				String[] content = tempString.split("=");
				if(content[0].trim().equalsIgnoreCase("serverPort")){
					serverPort = Integer.parseInt(content[1].trim());
				}
				else if(content[0].trim().equalsIgnoreCase("adminPort")){
					adminPort = Integer.parseInt(content[1].trim());
				}
				else if(content[0].trim().equalsIgnoreCase("poolSize")){
					poolSize = Integer.parseInt(content[1].trim());
				}
				else if(content[0].trim().equalsIgnoreCase("baseDir")){
					baseDir = content[1].trim();
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
}

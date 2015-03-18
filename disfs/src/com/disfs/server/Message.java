package com.disfs.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class Message {
	public static enum Type {
		READ, NEW_TXN, WRITE, COMMIT, ABORT, ACK, ASK_RESEND, ERROR
	};

	private static String separator1 = new String("\r\n\r\n\r\n");
	private static String separator2 = new String("\r\n\r\n");

	private static PrintWriter getWriter(Socket socket) throws IOException {
		return new PrintWriter(socket.getOutputStream());
	}

	private static class ErrorInfor {
		private static final ErrorInfor instance = new ErrorInfor();

		public static ErrorInfor getInstance() {
			return instance;
		}

		private HashMap<Integer, String> map = null;

		private ErrorInfor() {
			map = new HashMap<Integer, String>();

			// map.put(204, "Cannot find valid head split.\n" );
			map.put(204, "Wrong message format.\n");
			map.put(205, "File i o error.\n");
			map.put(206, "File not found.\n");
			map.put(207, "Server too busy.\n");
			map.put(208, "Conflict with other client.\n");
			map.put(209, "Sequence number conflict with previous request.\n");
			map.put(210, "Client has no message for too long time.\n");
			map.put(211, "Invalid sequence number in write operation.\n");
			map.put(212, "Method invalid.\n");
			map.put(213, "Number in head format incorrect.\n");
			map.put(214, "Message too long.\n");
			map.put(215, "Message length mismatch between body and head.\n");
			map.put(216, "Invalid or unexist transaction id.\n");
			map.put(217, "Invalid operation.\n");
			map.put(218, "Find uncoming write operation.\n");
		}
	}

	public static void reply_ack_msg(Socket socket, int transaction_id, int seq) {
		try {
			PrintWriter pw = getWriter(socket);
			pw.printf("%s %d %d %d %d \r\n\r\n\r\n", "ACK", transaction_id,
					seq, 0, 0);
			pw.flush();
		} catch (IOException e) {

		}
	}

	public static void reply_error_msg(Socket socket, int error,
			int transaction_id, int seq) {
		try {
			PrintWriter pw = getWriter(socket);
			String err = ErrorInfor.getInstance().map.get(error);
			pw.printf("%s %d %d %d %d \r\n\r\n%s", "ERROR", transaction_id,
					seq, error, err.length(), err);
			pw.flush();
		} catch (IOException e) {

		}
	}

	public static void reply_resend_msg(Socket socket, int transaction_id,
			int seq) {
		try {
			PrintWriter pw = getWriter(socket);
			pw.printf("%s %d %d %d %d \r\n\r\n\r\n", "ASK_RESEND",
					transaction_id, seq, 0, 0);
			pw.flush();
		} catch (IOException e) {

		}
	}

	public static boolean isIntegratedMessage(char buf[], int len) {
		String msg = String.valueOf(buf, 0, len);

		if (msg.contains(separator1)) {
			return true;
		} else if (msg.contains(separator2)) {
			String[] msgParts = msg.split(separator2);

			if (msgParts.length == 2) {
				int pos = msgParts[0].lastIndexOf(" ");
				try {
					int mlen = 0;
					mlen = Integer.parseInt(msgParts[0].substring(pos + 1));

					if (mlen <= msgParts[1].length()) {
						// System.out.printf("head len: %d, bod len: %d\n",
						// mlen, msgParts[1].length());
						return true;
					}
				} catch (Exception e) {

				}

			}
		}
		return false;
	}

	public static Message parseMessage(String msg) {
		Message message = null;

		try {
			if (msg.contains(separator1)) {
				String[] msgParts = msg.split(separator1);

				if (msgParts[0].toUpperCase().startsWith("ABORT ")) {
					String[] headParts = msgParts[0].split(" ");
					if (headParts.length == 4) {
						message = new Message(Message.Type.ABORT,
								Integer.parseInt(headParts[1]));
						message.seq_num = Integer.parseInt(headParts[2]);
						System.out.printf("%s receive abort req\n", Thread
								.currentThread().getName());
					}
				} else if (msgParts[0].toUpperCase().startsWith("COMMIT ")) {
					String[] headParts = msgParts[0].split(" ");
					if (headParts.length == 4) {
						message = new Message(Message.Type.COMMIT,
								Integer.parseInt(headParts[1]));
						message.seq_num = Integer.parseInt(headParts[2]);
						System.out.printf("%s receive commit req\n", Thread
								.currentThread().getName());
					}
				}

			} else if (msg.contains(separator2)) {
				String[] msgParts = msg.split(separator2);

				if (msgParts[0].toUpperCase().startsWith("NEW_TXN ")) {
					message = new Message(Message.Type.NEW_TXN, -1);
					message.body = msgParts[1].replace('\n', ' ').trim();
					System.out.printf("%s receive new_txn req\n", Thread
							.currentThread().getName());
				}else if (msgParts[0].toUpperCase().startsWith("READ ")) {
					String[] headParts = msgParts[0].split(" ");
					if (headParts.length == 4) {
						message = new Message(Message.Type.READ,
								Integer.parseInt(headParts[1]));
						message.seq_num = Integer.parseInt(headParts[2]);
						message.body = msgParts[1];
						System.out.printf("%s receive read req\n", Thread
								.currentThread().getName());
					}
				}else if (msgParts[0].toUpperCase().startsWith("WRITE ")) {
					String[] headParts = msgParts[0].split(" ");
					if (headParts.length == 4) {
						message = new Message(Message.Type.WRITE,
								Integer.parseInt(headParts[1]));
						message.seq_num = Integer.parseInt(headParts[2]);
						message.body = msgParts[1];
						System.out.printf("%s receive write req\n", Thread
								.currentThread().getName());
					}
				} else if (msgParts[0].toUpperCase().startsWith("COMMIT ")) {
					String[] headParts = msgParts[0].split(" ");
					if (headParts.length == 4) {
						message = new Message(Message.Type.COMMIT,
								Integer.parseInt(headParts[1]));
						message.seq_num = Integer.parseInt(headParts[2]);
						System.out.printf("%s receive commit req\n", Thread
								.currentThread().getName());
					}
				}
			}
		} catch (Exception e) {
			message = null;
		}

		return message;
	}

	public Type type;
	public int transaction_id;
	public int seq_num;
	public int error;
	public String body = null;

	public Message(Type t, int id) {
		type = t;
		transaction_id = id;
		body = null;
	}
}

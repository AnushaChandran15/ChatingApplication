package com.anushachandran1502.chatapplication;

import java.util.Scanner;
import java.io.IOException;
import java.net.*;
import java.io.*;

public class Client {
	private static final String HOST="localhost";
	private static final int PORT=5000;
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("From");
		String from=scanner.nextLine();
		System.out.println("To");
		String to=scanner.nextLine();
		getPermission(from,to,scanner);
	}
	private static void getPermission(String from, String to, Scanner scanner) {
		try {
			Socket socket=new Socket(HOST,PORT);
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(from);
			Thread thread=new Thread()
					{
						@Override
						public void run() {
							while(true)
							{
								try {
									String msg=dis.readUTF();
									msgPrint("received",msg);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					};
					thread.start();
					while(true){
						String msg = scanner.nextLine();
						//msgPrint("sent", msg);
						dos.writeUTF(from+","+to+","+msg);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	protected static void msgPrint(String status, String msg) {
		if(status.equals(status))
		{
			System.out.println("\t\s"+msg+"\s");

		}
		else
		{
			System.out.println("\t\t\t\t\s"+msg+"\s");

		}
	}

}

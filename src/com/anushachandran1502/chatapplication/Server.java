package com.anushachandran1502.chatapplication;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	private static ServerSocket serverSocket;
	private static HashMap<String,Socket> clients=new HashMap<>();
	
	public static void main(String[] args) {
		sever();
	}

	private static void sever() {
		try {
			serverSocket=new ServerSocket(3000);
				while(true)
				{
					Socket socket=serverSocket.accept();
					DataInputStream dis=new DataInputStream(socket.getInputStream());
					String name=dis.readUTF();
					clients.put(name,socket);
					Thread thread=new Thread() {
						@Override
						public void run() {
							communicateTheClient(socket);
						}
					};
					thread.start();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected static void communicateTheClient(Socket socket) {
		try {
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			String msg;
				while(true)
				{
					msg=dis.readUTF();
					sendMessage(socket,msg);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void sendMessage(Socket messeger, String msg) {
			String[] data=msg.split(",");
			for(Map.Entry<String, Socket> map:clients.entrySet())
			{
				if(!map.getValue().equals( messeger) && map.getKey().equals(data[1]))
				{
					DataOutputStream dos;
					try {
						dos = new DataOutputStream(map.getValue().getOutputStream());
						dos.writeUTF(data[0]+":"+data[2]);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	

}

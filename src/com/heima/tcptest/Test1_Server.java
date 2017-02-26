package com.heima.tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1_Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(54321);
		System.out.println("服务器启动，绑定54321端口");
		
		while(true){
			Socket socket = serverSocket.accept();
			
			new Thread(){
				public void run() {
					
					try {
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintStream printStream = new PrintStream(socket.getOutputStream());
						
						String line;
						line = bufferedReader.readLine();						
						line = new StringBuilder(line).reverse().toString();
						printStream.println(line);
												socket.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				};
			}.start();
		}

	}

}

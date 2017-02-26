package com.heima.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1_Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		
		while (true) {
			final Socket socket = serverSocket.accept();
			new Thread(){
				public void run() {
					try {
						BufferedReader bReader = 
								new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
						PrintStream printStream = new PrintStream(socket.getOutputStream());
						
						printStream.println("»¶Ó­×ÉÑ¯");
						System.out.println(bReader.readLine());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				};
			}.start();
			socket.close();			
		}
		
		

	}

}

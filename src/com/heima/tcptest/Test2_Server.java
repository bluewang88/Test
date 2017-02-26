package com.heima.tcptest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import sun.print.resources.serviceui;

public class Test2_Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		System.out.println("服务器启动，绑定12345端口");
		while(true){
			final Socket socket = serverSocket.accept();
			new Thread(){
				public void run() {
				
					try {	
						InputStream inputStream = socket.getInputStream();
						BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
						PrintStream printStream = new PrintStream(socket.getOutputStream());
						String fileName = bufferedReader.readLine();
						
						File dir = new File("update");
						dir.mkdir();
						File file = new File(dir,fileName);
						if (file.exists()) {
							printStream.println("存在");
							socket.close();
							return;
						}else {
							printStream.println("不存在");
						}
						
						FileOutputStream fileOutputStream = new FileOutputStream(file);
						byte[] arr = new byte[8192];
						int len;
						while((len = inputStream.read(arr)) != -1){
							fileOutputStream.write(arr,0,len);
						}
						fileOutputStream.close();
						socket.close();
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				};
			}.start();
		}

	}

}

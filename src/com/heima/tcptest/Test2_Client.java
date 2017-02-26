package com.heima.tcptest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.coreJava.inputTest;



public class Test2_Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		File file = getFile();
		
		Socket socket = new Socket("127.0.0.1", 12345);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		
		printStream.println(file.getName());
		
		String result = bufferedReader.readLine();
		if("����".equals(result)){
			System.out.println("�ϴ��ļ��Ѿ�����");
			socket.close();
			return;
		}
		
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] arr = new byte[8192];
		int len;
		
		while((len = fileInputStream.read(arr)) != -1){
			printStream.write(arr);
		}
		
		fileInputStream.close();
		socket.close();

	}

	private static File getFile() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ���ļ�·��");
		
		while(true){
			String line = scanner.nextLine();
			File file = new File(line);
			if(!file.exists()){
				System.out.println("�ļ������ڣ�������¼��:\r\n");
			}else if (file.isDirectory()) {
				System.out.println("¼������ļ��У��������ļ�·��");
			}else {
				return file;
			}
		}
		

	}

}

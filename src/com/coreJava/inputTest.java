package com.coreJava;

import java.io.Console;
import java.util.Scanner;

/**
 * This program demonstrate console input
 * @version 1.10 2017-1-21
 * @author bluewang
 *
 */

public class inputTest {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		
//		//Get frist input
//		System.out.println("What's you name?");
//		String name = in.nextLine();
//		
//		//Get second input
//		System.out.println("How old are you?");
//		int age = in.nextInt();
//		
//		//display output on console
//		System.out.println("Hello," + name +" .Next year, you'll be " + (age + 1));
//		
		// Get passport from console
		Console console = System.console();
		if(console != null){
		String username = console.readLine("User name :");
		console.format("%s\n", username);
		char[] passwd = console.readPassword("Password:");
		console.format("%s\n",new String(passwd));
		
		}
		
		/*
		 * Java.io.Console ֻ�����ڱ�׼���롢�����δ���ض����ԭʼ����̨��ʹ�ã�
		 * �� Eclipse �������� IDE �Ŀ���̨���ò��˵ġ�
		 * ��ԭʼ����̨���������Linux����Щ�ط���������һ�����������ˣ����ǿ�����������ֻҪ���˼��̾͹��ã���Ҫ��
		 * Ϊ����û����һ����Ϊ���ˡ�
		 */
	}

}

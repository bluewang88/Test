package com.heima.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * ե֭��(Juicer)ե֭�İ���
 * �ֱ���ˮ��(Fruit)ƻ��(Apple)�㽶(Banana)����(Orange)ե֭(squeeze)
 */

public class Demo2_Reflect {

	public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
		Juicer juicer = new Juicer();
//		juicer.run(new Apple());
		BufferedReader bReader = new BufferedReader(new FileReader("config.properties"));
		Class clazz = Class.forName(bReader.readLine());
		
		Fruit fruit = (Fruit) clazz.newInstance(); //
		juicer.run(fruit);
		
	}

}

interface Fruit{
	void squeeze();
}

class Apple implements Fruit{
	public void squeeze() {
		System.out.println("ե��һ��ƻ��֭");
	}
}

class Orange implements Fruit{
	public void squeeze() {
		System.out.println("ե��һ������֭");
	}
}

class Juicer{
//	public void run(Apple apple) {
//		apple.squeeze();
//		
//	}
	
	public  void run(Fruit fruit) {
		fruit.squeeze();
	}
	
	
}
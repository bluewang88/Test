package com.heima.reflect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * 榨汁机(Juicer)榨汁的案例
 * 分别有水果(Fruit)苹果(Apple)香蕉(Banana)桔子(Orange)榨汁(squeeze)
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
		System.out.println("榨出一杯苹果汁");
	}
}

class Orange implements Fruit{
	public void squeeze() {
		System.out.println("榨出一杯橘子汁");
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
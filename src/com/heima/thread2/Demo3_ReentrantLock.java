package com.heima.thread2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3_ReentrantLock {

	public static void main(String[] args) {
		Printer3 printer3 = new Printer3();
		new Thread(){
			public void run() {
				while(true){
					try {
						printer3.print1();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		new Thread(){
			public void run() {
				while(true){
					try {
						printer3.print2();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			};
		}.start();
		
		new Thread(){
			public void run() {
				while(true){
					try {
						printer3.print3();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			};
		}.start();
		
	}

}

class Printer3{
	private ReentrantLock rLock = new ReentrantLock();
	private Condition c1 = rLock.newCondition();
	private Condition c2 = rLock.newCondition();
	private Condition c3 = rLock.newCondition();
	
	private int  flag = 1;
	public void print1() throws InterruptedException {
			rLock.lock();
			if (flag != 1 ) {
				c1.await();
			}
			System.out.print("黑");
			System.out.print("马");
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
			flag = 2;
			c2.signal();
			rLock.unlock();
	}
	
	public void print2() throws InterruptedException {
			rLock.lock();
			if (flag != 2) {
				c2.await();
			}
			System.out.print("传");
			System.out.print("智");
			System.out.print("播");
			System.out.print("客");
			System.out.print("\r\n");
			flag = 3;
			c3.signal();
			rLock.unlock();
	}
	
	public void print3() throws InterruptedException {
			rLock.lock();
			if (flag != 3) {
				c3.await();
			}
			System.out.print("1");
			System.out.print("2");
			System.out.print("3");
			System.out.print("4");
			System.out.print("\r\n");
			flag = 1;
			c1.signal();
			rLock.unlock();
	}
}
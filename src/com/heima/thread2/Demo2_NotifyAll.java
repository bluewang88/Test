package com.heima.thread2;

public class Demo2_NotifyAll {

	public static void main(String[] args) {
		Printer2 printer2 = new Printer2();
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer2.print1();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer2.print2();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		
		new Thread(){
			@Override
			public void run() {
				while(true){
					try {
						printer2.print3();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
				
			}
		}.start();
		
	}

}

class Printer2{
	private int  flag = 1;
	public void print1() throws InterruptedException {
		synchronized(this){
			if (flag != 1 ) {
				this.wait();
			}
			System.out.print("黑");
			System.out.print("马");
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
			flag = 2;
			this.notifyAll();
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this){
			if (flag != 2) {
				this.wait();
			}
			System.out.print("传");
			System.out.print("智");
			System.out.print("播");
			System.out.print("客");
			System.out.print("\r\n");
			flag = 3;
			this.notifyAll();
		}
	}
	
	public void print3() throws InterruptedException {
		synchronized(this){
			if (flag != 3) {
				this.wait();
			}
			System.out.print("1");
			System.out.print("2");
			System.out.print("3");
			System.out.print("4");
			System.out.print("\r\n");
			flag = 1;
			this.notifyAll();
		}
	}
}
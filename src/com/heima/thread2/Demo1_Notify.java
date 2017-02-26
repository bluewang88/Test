package com.heima.thread2;

import jdk.nashorn.internal.ir.Flags;

public class Demo1_Notify {
	public static void main(String[] args) {
		Printer printer = new Printer();
		
		new Thread(){
			public void run() {
				while(true){
					try {
						printer.print1();
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
						printer.print2();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
}


//�ȴ����ѻ���
class Printer{
	private int  flag = 1;
	public void print1() throws InterruptedException {
		synchronized(this){
			if (flag != 1 ) {
				this.wait();
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("Ա");
			System.out.print("\r\n");
			flag = 2;
			this.notify();
		}
	}
	
	public void print2() throws InterruptedException {
		synchronized(this){
			if (flag != 2) {
				this.wait();
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");
			flag = 1;
			this.notify();
		}
	}
}
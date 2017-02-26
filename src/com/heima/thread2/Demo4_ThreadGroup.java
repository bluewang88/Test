package com.heima.thread2;

public class Demo4_ThreadGroup {
	public static void main(String[] args) {
//		demo1();
		ThreadGroup tGroup = new ThreadGroup("����һ���µ��߳���");
		MyRunnerable myRunnerable = new MyRunnerable();
		
		Thread t1 = new Thread(tGroup, myRunnerable, "����");
		Thread t2 = new Thread(tGroup, myRunnerable, "����");
		
		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getName());
		
//		t1.run();
		
		tGroup.setDaemon(true);
	}

	private static void demo1() {
		MyRunnerable mRunnerable = new MyRunnerable();
		Thread t1 = new Thread(mRunnerable, "����");
		Thread t2 = new Thread(mRunnerable, "����");
		
		ThreadGroup tGroup1 = t1.getThreadGroup();
		ThreadGroup tGroup2 = t2.getThreadGroup();
		
		System.out.println(tGroup1.getName()); // Ĭ�������߳�
		System.out.println(tGroup2.getName());
	}
}
class MyRunnerable implements  Runnable {
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + "...");
		}
	}
}
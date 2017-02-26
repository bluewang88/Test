package com.heima.thread2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5_Executors {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		pool.submit(new MyRunnerable());//���߳�װ��������ִ��
		pool.submit(new MyRunnerable());
		
		pool.shutdown();//�ر��߳�
	}

}

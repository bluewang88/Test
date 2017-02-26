package com.coreJava;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestGregorianCalendarClass {

	public static void main(String[] args) {
		GregorianCalendar today = new GregorianCalendar(1999,Calendar.JANUARY,31,12,59,59);
		
		/*
		 * getTime()返回当前时间，和Date类的中创建Date对象使用toString方法一样
		 * 即date.toString()
		 */
		System.out.println(today.getTime());//result:Sun Jan 29 23:42:34 CST 2017
		
		//System.out.println(today.get(1));//result：2017
		
		GregorianCalendar now = new GregorianCalendar();
		int month = now.get(Calendar.MONTH);
		int weekday = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(month);
		System.out.println(weekday);
		now.set(Calendar.MONTH, 2);
		int monthday = now.get(Calendar.MONTH);
		System.out.println(monthday);
		
		GregorianCalendar deadline = new GregorianCalendar();
		deadline.set(2001, Calendar.APRIL,15);
		System.out.println(deadline.getTime());

	}

}

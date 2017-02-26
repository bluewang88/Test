package com.coreJava;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ObjectAndObjectVariable {

	public static void main(String[] args) {
//		Date deadline = new Date();
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(Calendar.MONTH,1);
		int month = calendar.get(Calendar.MONTH);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(month + "month  " + weekday + "weekday" + Calendar.DAY_OF_WEEK);

	}


}

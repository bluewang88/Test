package com.coreJava;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;



/**
 * @version 2017-1-30 
 * @author bluewang
 *
 */

public class MyCalendarTest {

	public static void main(String[] args) {
		
		GregorianCalendar dCalendar = new GregorianCalendar();
		
		int today = dCalendar.get(Calendar.DAY_OF_MONTH);
		int month = dCalendar.get(Calendar.MONTH);
		
		dCalendar.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = dCalendar.get(Calendar.DAY_OF_WEEK);
		
		int fristDayOfWeek = dCalendar.getFirstDayOfWeek();
		int index = 0;
		
		while( weekday != fristDayOfWeek){
			index++;
			dCalendar.add(Calendar.DAY_OF_MONTH, -1);
			weekday = dCalendar.get(Calendar.DAY_OF_WEEK);
			
		}
		
		//现在weekday的值 = fristDayOfweek
		
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		
		do{
			System.out.printf("%4s", weekdayNames[weekday]);
			dCalendar.add(Calendar.DAY_OF_MONTH, 1);
			weekday = dCalendar.get(Calendar.DAY_OF_WEEK);
		}while(weekday != fristDayOfWeek);
		
		System.out.println();
		
		for (int i = 0; i < index; i++) {
			System.out.println("   ");
		}
		
		dCalendar.set(Calendar.DAY_OF_MONTH, 1);
		do {
			int day = dCalendar.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3d", day);
			
			if (day == today) {
				System.out.print("* ");
			} else {
				System.out.print("  ");
			}
			
			dCalendar.add(Calendar.DAY_OF_MONTH, 1);
			weekday = dCalendar.get(Calendar.DAY_OF_WEEK);
			
			if (weekday == fristDayOfWeek) {
				System.out.println();
			}
			
		} while (dCalendar.get(Calendar.MONTH) == month);
		
		if (weekday != fristDayOfWeek) {
			System.out.println();
		}

	}

}

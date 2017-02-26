package com.coreJava;

import java.text.NumberFormat;

/**
 * @version 2017-1-31
 * @author bluewang
 *
 */

public class TestFactoryMethod {

	public static void main(String[] args) {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		
		double x = 0.1;
		System.out.println(currencyFormat.format(x));
		System.out.println(percentFormat.format(x));
		
		

	}

}

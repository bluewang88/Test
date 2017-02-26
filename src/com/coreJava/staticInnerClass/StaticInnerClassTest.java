package com.coreJava.staticInnerClass;



/**
 * @version 2017-2-11
 * @author bluewang
 *
 */

public class StaticInnerClassTest {

	public static void main(String[] args) {
		double[] ds = new double[20];
		for (int i = 0; i < ds.length; i++) {
			ds[i] = 100 * Math.random();
		}
		ArrayAlg.Pair pair = ArrayAlg.minmax(ds);
		System.out.println("min = " + pair.getFrist());
		System.out.println("max = " + pair.getSecond());

	}

}

class ArrayAlg{
	public static class Pair {
		private double frist;
		private double second;
		
		public Pair(double f, double s) {
			frist = f;
			second = s;
		}
		
		public double getFrist() {
			return frist;
		}
		
		public double getSecond() {
			return second;
		}
	}
	
	public static Pair minmax(double[] values) {
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (double d : values) {
			if (min > d) {
				min = d;
			}
			if (max < d) {
				max = d;
			}
		}
		return new Pair(min, max);
	}
}

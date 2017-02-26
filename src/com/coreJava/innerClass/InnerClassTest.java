package com.coreJava.innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * This program demostrates the use of inner class
 * @version 2017-2-11
 * @author bluewang
 *
 */


public class InnerClassTest {

	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		
		JOptionPane.showMessageDialog(null, "Quit program£¿");
		System.exit(0);

	}

}

class TalkingClock{
	private int interval;
	private boolean beep;
	
	/**
	 * Constructs a talking clock
	 * @param interval the interval between message(int milliseconds)
	 * @param beep true if the clock should beep
	 */
	
	public TalkingClock(int interval,boolean beep) {
		this.beep = beep;
		this.interval = interval;
	}
	
	public void start() {
		ActionListener listener = new TimerPrinter();
		Timer timer = new Timer(interval, listener);
		timer.start();
	}
	
	public class TimerPrinter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Date now = new Date();
			System.out.println("At the tone, the time is" + now );
			if (beep) {
				Toolkit.getDefaultToolkit().beep();
			}
			
		}
	}
}

package com.heima.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Demo1_Frame {

	public static void main(String[] args) {
		Frame frame = new Frame("my frist window");
		frame.setSize(400,600);
		frame.setLocation(300, 50);
//		frame.setIconImage(image);
		Button b1 = new Button("按钮");
		
		Button b2 = new Button("按钮二");
		frame.add(b1);
		frame.add(b2);
		frame.setLayout(new FlowLayout());
//		frame.addWindowListener(new MyWindowAdapter());
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}
		});
		
		b1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
//			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				System.exit(0);
			}
		});
		
		b1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println(e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.exit(0);
				}else{
					System.out.println(e.getKeyCode());
				}
				
//				System.exit(0);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		frame.setVisible(true);//设置窗体可见
		
	}

}

//class MyWindowListenner implements WindowListener{
//
//	@Override
//	public void windowOpened(WindowEvent e) {
//	}
//
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.out.println("closing");
//		System.exit(0);
//	}
//
//	@Override
//	public void windowClosed(WindowEvent e) {
//		System.out.println("closed");
//	}
//
//	@Override
//	public void windowIconified(WindowEvent e) {
//	}
//
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//	}
//
//	@Override
//	public void windowActivated(WindowEvent e) {
//	}
//
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//	}
//	
//}

//class MyWindowAdapter extends WindowAdapter{
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.exit(0);
//	}
//}
package library.gui;

import javax.swing.JFrame;

public class Frame extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4355269320719113054L;
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 1200;

	public Frame() {
		setTitle("Project");
		setLocation(0, 0);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

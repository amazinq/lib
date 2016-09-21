package library.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

public class Frame extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4355269320719113054L;

	public Frame() {
		setTitle("Project");
		setLocation(0, 0);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

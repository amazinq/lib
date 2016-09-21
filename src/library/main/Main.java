package library.main;

import java.awt.EventQueue;

import library.controller.Controller;
import library.gui.Frame;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				Controller.getController();
			}
		});
	}

}

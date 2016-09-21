package library.controller;


import library.gui.Frame;
import library.gui.MenuBar;
import library.gui.Panel;

public class Controller {
	
	private static Controller controller;
	
	private Frame frame;
	private MenuBar menuBar;
	private Panel panel;
	
	public static Controller getController() {
		if(controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	

	private Controller() {
		frame = new Frame();
		menuBar = new MenuBar();
		panel = new Panel();
		
		
		frame.setJMenuBar(menuBar);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}

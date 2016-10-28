package library.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import library.dao.LibraryDAO;
import library.gui.Frame;
import library.gui.MenuBar;
import library.gui.Panel;
import library.util.Util;

public class Controller {

	private static Controller controller;

	private Frame frame;
	private MenuBar menuBar;
	private Panel panel;

	private LibraryDAO dao;

	public static Controller getController() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}

	private Controller() {
		frame = new Frame();
		menuBar = new MenuBar();
		panel = new Panel();
		try {
			dao = new LibraryDAO();
		} catch (ClassNotFoundException e) {
			//@TODO: Do exceptionhandling
		}

		frame.setJMenuBar(menuBar);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	/**
	 * 
	 * @param searchConditions
	 * @return map of database data. If an error occurs, null will be returned
	 */
	public HashMap<String,String> getDataFromLibrary(HashMap<String,String> searchConditions) {
		ResultSet set = null;
		try {
			set = dao.getLibraryFromDatabase(searchConditions);
		} catch(SQLException e) {
			//@TODO: Do exceptionhandling
		}
		return Util.convertResultSetToHashMap(set);
	}

}

package library.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7097648953139719159L;

	public MenuBar() {
		
		
		JMenu data = new JMenu("Datei");
		JMenuItem pushDataBaseToUpstream = new JMenuItem("Datenbank auf Server speichern");
		JMenuItem loadDataBaseFromServer = new JMenuItem("Datenbank von Server laden");
		
		data.add(pushDataBaseToUpstream);
		data.add(loadDataBaseFromServer);
		
		add(data);
		
	}

}

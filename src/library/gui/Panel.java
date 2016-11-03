package library.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Panel extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8846632724231527592L;

	public Panel() {
		setDividerLocation(Frame.WIDTH/2);
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		leftPanel.setLayout(new GridLayout(4, 2));
		
		JLabel titleLabel = new JLabel("Titel");
		JLabel regisseurLabel = new JLabel("Regisseur");
		JLabel genreLabel = new JLabel("Genre");
		JLabel locationLabel = new JLabel("Location");
		
		JTextField titleTextField = new JTextField();
		JTextField regisseurTextField = new JTextField();
		JTextField genreTextField = new JTextField();
		JTextField locationTextField = new JTextField();
		
		leftPanel.add(titleLabel);
		leftPanel.add(titleTextField);
		leftPanel.add(regisseurLabel);
		leftPanel.add(regisseurTextField);
		leftPanel.add(genreLabel);
		leftPanel.add(genreTextField);
		leftPanel.add(locationLabel);
		leftPanel.add(locationTextField);
		
		
		
		setLeftComponent(leftPanel);
		setRightComponent(rightPanel);
	}
}

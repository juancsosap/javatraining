package Components;

import java.awt.Color;

import javax.swing.JLabel;

import Template.ProjectFont;

@SuppressWarnings("serial")
public class JCustomLabel extends JLabel {
	
	public JCustomLabel(String text) {
		super(text);
		setFont(new ProjectFont());
		setForeground(Color.BLUE);
	}

}

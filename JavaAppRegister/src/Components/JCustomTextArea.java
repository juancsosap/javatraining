package Components;

import javax.swing.JTextArea;

import Template.ProjectFont;

@SuppressWarnings("serial")
public class JCustomTextArea extends JTextArea {

	public JCustomTextArea() {
		setLineWrap(true);
		setFont(new ProjectFont());
	}
	
}

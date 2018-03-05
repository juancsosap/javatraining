package Components;

import javax.swing.JButton;

import Template.ProjectFont;

@SuppressWarnings("serial")
public class JCustomButton extends JButton {

	public JCustomButton(String text) {
		super(text);
		setFont(new ProjectFont());
	}
}

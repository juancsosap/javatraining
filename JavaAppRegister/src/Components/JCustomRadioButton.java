package Components;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import Template.ProjectFont;

@SuppressWarnings("serial")
public class JCustomRadioButton extends JRadioButton {
	
	public JCustomRadioButton(String text, ButtonGroup group, boolean selected) {
		super(text);
		setFont(new ProjectFont());
		setSelected(selected);
		group.add(this);
	}
	public JCustomRadioButton(String text, ButtonGroup group) {
		this(text, group, false);
	}

}

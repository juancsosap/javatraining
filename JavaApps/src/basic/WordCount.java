package basic;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class WordCount {

	public static void main(String[] args) {
		new WordCountWindow();
	}

}

@SuppressWarnings("serial")
class WordCountWindow extends JFrame {
	
	private JTextArea text = new JTextArea();
	
	private JLabel wordCount = new JLabel();
	private JLabel charCount = new JLabel();
	
	private JCheckBox bold = new JCheckBox("Bold");
	private JCheckBox italic = new JCheckBox("Italic");
	
	public WordCountWindow() {
		this.setTitle("Word Count");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		JPanel header = new JPanel();
		header.setLayout(new GridLayout(1,4));
		
		this.bold.setHorizontalAlignment(JCheckBox.CENTER);
		this.bold.addActionListener(new Styling());
		header.add(this.bold);
		this.italic.setHorizontalAlignment(JCheckBox.CENTER);
		this.italic.addActionListener(new Styling());
		header.add(this.italic);
		this.add(header, BorderLayout.NORTH);
		 
		this.text.setLineWrap(true);
		text.setFont(new Font("Arial", Font.PLAIN, 12));
		text.getDocument().addDocumentListener(new Counting());
		this.add(new JScrollPane(text), BorderLayout.CENTER);
		
		JPanel footer = new JPanel();
		footer.setLayout(new GridLayout(1,2));
		footer.add(this.wordCount);
		footer.add(this.charCount);
		this.add(footer, BorderLayout.SOUTH);
		
		this.wordCount.setText("Word Count: 0");
		this.wordCount.setHorizontalAlignment(JLabel.CENTER);
		this.charCount.setText("Character Count: 0");
		this.charCount.setHorizontalAlignment(JLabel.CENTER);
		
		this.setSize(300,300);
		this.center();
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
	private class Counting implements DocumentListener {
		
		@Override
		public void changedUpdate(DocumentEvent de) {}

		@Override
		public void insertUpdate(DocumentEvent de) {
			this.count();
		}

		@Override
		public void removeUpdate(DocumentEvent de) {
			this.count();
		}
		
		private void count() {
			int words = text.getText().split(" ").length;
			wordCount.setText("Word Count: " + words);
			int chars = text.getText().length();
			charCount.setText("Character Count: " + chars);
		}
		
	}
	
	private class Styling implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int style = Font.PLAIN;
			style += bold.isSelected() ? Font.BOLD : 0;
			style += italic.isSelected() ? Font.ITALIC : 0;
			
			text.setFont(new Font("Arial", style, 12));
		}
		
	}
	
}
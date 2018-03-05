package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorWindow extends JFrame {

	private WindowEventListener window = new WindowEventListener();
	
	private ColorPanel panel = new ColorPanel();
	
	public static void main(String[] args) {
		
		new ColorWindow(400, 400);
		
	}
	
	public ColorWindow(int width, int height) {
		
		this.setTitle("Color Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel.setSize(width, height);
		panel.setBackground(SystemColor.window);
		this.add(this.panel);
		
		this.setSize(width, height);
		this.center();
		this.setVisible(true);
		
		this.addWindowListener(window);
		
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
	private class ColorPanel extends JPanel {
		
		private JButton[] colorButton = new JButton[3];
		private Background[] color = new Background[3];
		
		private KeyEventListener keyboard = new KeyEventListener();
		
		public ColorPanel() {
			
			this.setLayout(null);
			
			color[0] = new Background(Color.RED);
			color[1] = new Background(Color.GREEN);
			color[2] = new Background(Color.BLUE);
			
			colorButton[0] = new JButton("Red");
			colorButton[1] = new JButton("Green");
			colorButton[2] = new JButton("Blue");
			
			for(int i=0; i < 3; i++) {
				this.add(this.colorButton[i]);
				this.colorButton[i].addActionListener(this.color[i]);
				this.colorButton[i].addFocusListener(this.color[i]);
				this.colorButton[i].addKeyListener(keyboard);
				this.colorButton[i].setBounds(125, 50 * i + 50, 150, 40);
			}
			
		}
		
		private class Background extends FocusAdapter implements ActionListener {
			
			private Color backgroundColor;
			
			public Background(Color color){
				this.backgroundColor = color;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(this.backgroundColor);
			}

			@Override
			public void focusGained(FocusEvent e) {
				setBackground(this.backgroundColor);
			}

		}
	}
	
	private class WindowEventListener extends WindowAdapter {

		@Override
		public void windowDeactivated(WindowEvent e) {
			panel.setBackground(SystemColor.window);
		}
		
	}
	
	private class KeyEventListener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == 'R' || e.getKeyChar() == 'r') {
				panel.setBackground(Color.RED);
			} else if (e.getKeyChar() == 'G' || e.getKeyChar() == 'g') {
				panel.setBackground(Color.GREEN);
			} else if (e.getKeyChar() == 'B' || e.getKeyChar() == 'b') {
				panel.setBackground(Color.BLUE);
			}
		}
		
	}
	
}

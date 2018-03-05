package basic;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class MultiWindows extends JFrame {

	private WindowPanel panel = new WindowPanel();
	
	public static void main(String[] args) {
		
		new MultiWindows(400, 400);
		
	}
	
	public MultiWindows(int width, int height) {
		
		this.setTitle("Multi Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel.setSize(width, height);
		panel.setBackground(SystemColor.window);
		this.add(this.panel);
		
		this.setSize(width, height);
		this.center();
		this.setVisible(true);
		
		this.addWindowListener(new CustomWindow());
		this.addWindowStateListener(new StateChanged());
		
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
	private class WindowPanel extends JPanel {
		
		private JButton openButton, closeButton;
		
		private InputMap inMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		private ActionMap actMap = this.getActionMap();
		
		public WindowPanel() {
			
			this.setLayout(null);
			
			// ######### OPEN #########
			// Create Buttons
			this.openButton = new JButton("Open");
			this.add(this.openButton);
			this.openButton.setBounds(125, 50, 150, 40);
			// Event Listener
			ActionEventListener openAction = new ActionEventListener();
			// Click Event
			this.openButton.addActionListener(openAction);
			// Key Event
			this.inMap.put(KeyStroke.getKeyStroke("ctrl O"), "OpenAction");
			this.actMap.put("OpenAction", openAction);
			
			// ######### CLOSE #########
			// Create Buttons			
			this.closeButton = new JButton("Close");
			this.add(this.closeButton);
			this.closeButton.setBounds(125, 100, 150, 40);
			
		}
		
		private class ActionEventListener extends AbstractAction {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// Creating Window
				ExtraWindows window = new ExtraWindows(300, 200);
				// Event Listener
				Action closeAction = window.getListener();
				// Click Event
				closeButton.addActionListener(closeAction);
				// Key Event
				inMap.put(KeyStroke.getKeyStroke("ctrl C"), "CloseAction");
				actMap.put("CloseAction", closeAction);
				
			}
			
		}		
		
	}
	
}

@SuppressWarnings("serial")
class ExtraWindows extends JFrame {

	private static int quantity = 0;
	
	private ActionEventListener listener = new ActionEventListener();
	
	public ExtraWindows(int width, int height) {
		
		this.setTitle("Extra Window " + (ExtraWindows.quantity + 1));
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setSize(width, height);
		this.setLocation(ExtraWindows.quantity * 30, ExtraWindows.quantity * 30);
		this.setVisible(true);
		
		ExtraWindows.quantity++;
		
	}
	
	public Action getListener() {
		return this.listener;
	}
	
	private class ActionEventListener extends AbstractAction {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ExtraWindows.quantity--;
			dispose();
		}
		
	}

}

class CustomWindow extends WindowAdapter implements WindowListener, WindowFocusListener {

	@Override
	public void windowActivated(WindowEvent e) {
		JFrame o = (JFrame) e.getSource();
		System.out.println("Window " + o.getTitle() + ": Activated");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		JFrame o = (JFrame) e.getSource();
		System.out.println("Window " + o.getTitle() + ": Closed");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFrame o = (JFrame) e.getSource();
		System.out.println("Window " + o.getTitle() + ": Closing");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		JFrame o = (JFrame) e.getSource();
		System.out.println("Window " + o.getTitle() + ": Desactivated");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		JFrame o = (JFrame) e.getSource();
		System.out.println("Window " + o.getTitle() + ": Restored");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		JFrame o = (JFrame) e.getSource();
		System.out.println("Window " + o.getTitle() + ": Minimized");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		JFrame o = (JFrame) e.getSource();
		System.out.println("Window " + o.getTitle() + ": Opened");
	}
	
}


class StateChanged implements WindowStateListener {

	@Override
	public void windowStateChanged(WindowEvent e) {
		String oe, ne, tf;
		switch(e.getOldState()) {
			case Frame.NORMAL: oe = "NORMAL"; break;
			case Frame.MAXIMIZED_BOTH: oe = "MAXIMIZED_BOTH"; break;
			case Frame.MAXIMIZED_VERT: oe = "MAXIMIZED_VERT"; break;
			case Frame.MAXIMIZED_HORIZ: oe = "MAXIMIZED_HORIZ"; break;
			default: oe = "ICONIFIED"; break;
		}
		switch(e.getNewState()) {
			case Frame.NORMAL: ne = "NORMAL"; break;
			case Frame.MAXIMIZED_BOTH: ne = "MAXIMIZED_BOTH"; break;
			case Frame.MAXIMIZED_VERT: ne = "MAXIMIZED_VERT"; break;
			case Frame.MAXIMIZED_HORIZ: ne = "MAXIMIZED_HORIZ"; break;
			default: ne = "ICONIFIED"; break;
		}
		tf = ((JFrame) e.getSource()).getTitle();
		
		System.out.println("The window " + tf + " change from " + oe + " to " + ne);	
	}
	
}
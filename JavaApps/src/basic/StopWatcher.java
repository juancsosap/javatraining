package basic;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class StopWatcher {
	
	private final int interval;
	private final boolean sound;
	
	private Timer timer;
	
	public StopWatcher(int interval, boolean sound) {
		this.interval = interval;
		this.sound = sound;
	}
	
	public static void main(String[] args) {
		
		StopWatcher clock = new StopWatcher(3000, true);
		clock.start();
		
		JOptionPane.showMessageDialog(null,	"Accept to Stop");
		
		clock.stop();
		
	}
		
	public void start() {
		
		class Actioner implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Date now = new Date();
				System.out.println("Time: " + now);
				if(sound) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener actioner = new Actioner();
		timer = new Timer(interval, actioner);
		timer.start();
		
	}
	
	public void stop() {
		timer.stop();
	}
		
}

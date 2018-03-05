package ballsTable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Table extends JFrame {
	
	private static int quantity = 0;
	private int id;
	
	private Glass glass;
	private final int INTERVAL = 100;
	private final int STEPS = 10;
	
	private WindowEventListener window = new WindowEventListener();
	private KeyEventListener keyboard = new KeyEventListener();
	private TimeEventListener time = new TimeEventListener();
	
	public Table(int width, int height) {
		this.setTitle("Ball Table");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.glass = new Glass();
		this.glass.setSize(width, height);
		this.add(this.glass);
		
		this.setSize(width, height);
		this.center();
		this.setVisible(true);
		
		this.startTimer(this.INTERVAL);
		
		this.addWindowListener(window);
		this.addKeyListener(keyboard);
		this.glass.addMouseListener();
		
		Table.quantity++;
		this.id = Table.quantity;
	}
	
	public String toString() {
		return "Table " + this.id;
	}
	
	private void startTimer(int interval) {
		Timer timer = new Timer(interval, (ActionListener) this.time);
		timer.start();
	}
	
	private void center() {
		Dimension winSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (winSize.getWidth() - this.getWidth())/2;
		int y = (int) (winSize.getHeight() - this.getHeight())/2;
		
		this.setLocation(x, y);
	}
	
	public void addBall() {
		Ball ball = new Ball(this.glass);
		this.glass.addShape(ball);
		ball.start(this.STEPS);
	}
	
	class Glass extends JPanel {
		
		private ArrayList<Shape> shape = new ArrayList<Shape>();
		private ArrayList<Color> color = new ArrayList<Color>();
		
		private MouseEventListener mouse = new MouseEventListener();
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2d = (Graphics2D) g;
			
			for(int i=0; i<this.color.size(); i++) {
				g2d.setPaint(this.color.get(i));
				g2d.fill(this.shape.get(i));
			}
			
		}
		
		public String toString() {
			return "Glass " + id;
		}
		
		public void addMouseListener() {
			super.addMouseListener(this.mouse);
		}
		
		public int getShapeQuantity() {
			return this.shape.size();
		}
		
		public Shape getShape(int index) {
			return this.shape.get(index);
		}
		
		public Color getShapeColor(int index) {
			return this.color.get(index);
		}
		
		public void addShape(Shape shape) {
			this.color.add(getRandomColor());
			this.shape.add(shape);
		}
		
		private Color getRandomColor() {
			int R = getIntRandom(0, 255);
			int G = getIntRandom(0, 255);
			int B = getIntRandom(0, 255);
			return new Color(R, G, B);
		}
		
		// Return random numbers between the MIN and MAX values specified
		private int getIntRandom(int max, int min) {
			return (int) Math.floor((Math.random() * (max - min + 1) + min));
		}
		
	}
	
	class TimeEventListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for(Shape ball: glass.shape) {
				((Ball) ball).move();
			}
			glass.repaint();
		}

	}
	
	private class WindowEventListener extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			for(int i=0; i<glass.getShapeQuantity(); i++) {
				((Ball) glass.getShape(i)).restart();
			}
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			for(int i=0; i<glass.getShapeQuantity(); i++) {
				((Ball) glass.getShape(i)).stop();
			}
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			for(int i=0; i<glass.getShapeQuantity(); i++) {
				((Ball) glass.getShape(i)).restart();
			}
		}

		@Override
		public void windowIconified(WindowEvent e) {
			for(int i=0; i<glass.getShapeQuantity(); i++) {
				((Ball) glass.getShape(i)).stop();
			}
		}
		
	}
	
	class KeyEventListener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == '+') {
				for(int i=0; i<glass.getShapeQuantity(); i++) {
					((Ball) glass.getShape(i)).grow();
				}
			}else if (e.getKeyChar() == '-') {
				for(int i=0; i<glass.getShapeQuantity(); i++) {
					((Ball) glass.getShape(i)).reduce();
				}
			}
		}
		
	}
	
	class MouseEventListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			for(int i=glass.getShapeQuantity()-1; i>=0; i--) {
				Ball ball = (Ball) glass.getShape(i);
				Color color = (Color) glass.getShapeColor(i);
				if(ball.isIn(e.getX(), e.getY())) {
					ball.destroy();
					glass.shape.remove(ball);
					glass.color.remove(color);
					break;
				}
			}
		}

	}
	
}



package ballsTable;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ball extends Ellipse2D.Double {
	
	private static int quantity = 0;
	
	private final double MAX_RADIO = 100;
	private final double MIN_RADIO = 1;
	
	private boolean activated; 
	private double radio;
	private Point2D.Double delta = new Point2D.Double(0, 0);
	
	JPanel glass;
	
	private int id;
	
	public Ball(JPanel glass) {
		super();
		
		this.glass = glass;
		
		this.radio = getDoubleRandom(this.MAX_RADIO, this.MIN_RADIO);
		
		double width = this.glass.getWidth();
		double height = this.glass.getHeight();
		
		double x = getDoubleRandom(width - 2 * this.radio, 0);
		double y = getDoubleRandom(height - 2 * this.radio, 0);
		
		this.setFrame(x, y, 2 * this.radio, 2 * this.radio);
		
		Ball.quantity++;
		this.id = Ball.quantity;
	}
	
	public String toString() {
		return "Ball " + this.id;
	}
	
	// Return random numbers between the MIN and MAX (not included) values specified
	private double getDoubleRandom(double max, double min) {
		return Math.random() * (max - min) + min;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public double getCornerX() {
		return this.getX() + 2 * this.radio;
	}
	
	public double getCornerY() {
		return this.getY() + 2 * this.radio;
	}
	
	public void start(double maxSteps) {
		
		double dx = this.getDoubleRandom(maxSteps, -maxSteps);
		double dy = this.getDoubleRandom(maxSteps, -maxSteps);
		this.delta.setLocation(dx, dy);
		
		this.activated = true;
	}
	
	public void restart() {
		this.activated = true;
	}
	
	public void stop() {
		this.activated = false;
	}
	
	public void grow() {
		if(this.radio < this.MAX_RADIO) {
			this.radio++;
		}
	}
	
	public void reduce() {
		if(this.radio > this.MIN_RADIO) {
			this.radio--;
		}
	}
	
	public void destroy() {
		Ball.quantity--;
	}
	
	public void move() {
		double width = this.glass.getWidth();
		double height = this.glass.getHeight();
		
		if(this.activated) {
			// Ball in the Left side of the table
			if(this.getX() <= 0) {
				this.setFrame(0, this.getY(), 2 * this.radio, 2 * this.radio);
				if(this.delta.getX() < 0) {
					this.delta.setLocation(Math.abs(this.delta.getX()), this.delta.getY());
				}
			}
			// Ball in the right side of the table
			if(this.getCornerX() >= width) {
				double right = width - 2 * this.radio;
				this.setFrame(right, this.getY(), 2 * this.radio, 2 * this.radio);
				if(this.delta.getX() > 0) {
					this.delta.setLocation(-Math.abs(this.delta.getX()), this.delta.getY());
				}
			}
			// Ball in the Top of the table
			if(this.getY() <= 0) {
				this.setFrame(this.getX(), 0, 2 * this.radio, 2 * this.radio);
				if(this.delta.getY() < 0) {
					this.delta.setLocation(this.delta.getX(), Math.abs(this.delta.getY()));
				}
			}
			// Ball in the bottom of the table
			if(this.getCornerY() >= height) {
				double bottom = height - 2 * this.radio;
				this.setFrame(this.getX(), bottom, 2 * this.radio, 2 * this.radio);
				if(this.delta.getY() > 0) {
					this.delta.setLocation(this.delta.getX(), -Math.abs(this.delta.getY()));
				}
			}
			
			this.setFrame(this.getX() + this.delta.getX(), this.getY() + this.delta.getY(), 2 * this.radio, 2 * this.radio);
		}
		
	}
	
	public boolean isTouching(Ball ball) {
		double distance = this.distance(ball.getCenterX(), ball.getCenterY());
		double radios = this.getRadio() + ball.getRadio();
		return radios <= distance;
	}
	
	
	
	public boolean isIn(double x, double y) {
		return this.distance(x, y) < this.radio;
	}
	
	private double distance(double x, double y) {
		double dx = this.getCenterX() - x;
		double dy = this.getCenterY() - y;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

}
package model;

public class Person {
	
	private int x;
	public int getX() { return x; }

	private int y;
	public int getY() { return y; }

	private boolean isAlive;
	public boolean isAlive() { return isAlive; }
	public void Born() { this.isAlive = true; }
	public void Dead() { this.isAlive = false; }
	
	public Person(int x, int y, boolean isAlive) {
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}
	
}
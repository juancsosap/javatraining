package pooBasicDrawingShapes;

public class Oval extends Shape {

	private int radio;
	
	public Oval(int radio) {
		setRadio(radio);
	}
	
	public void setRadio(int radio) throws IllegalArgumentException {
		if(radio > 0) {
			this.radio = radio;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public int getRadio() {
		return this.radio;
	}
	
	public void printShape() {
		System.out.println("O");
	}

}

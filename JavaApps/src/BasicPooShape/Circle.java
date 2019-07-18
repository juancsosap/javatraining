package BasicPooShape;

public class Circle extends Shape implements Comparable<Circle> {

	private double radio = 0;
	
	public double getRadio() {
		return this.radio;
	}
	
	public Circle(double radio) {
		this.radio = radio;
	}
	
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radio, 2);
	}
	
	@Override
	public String getType() {
		return "Shape.Circle";
	}
	
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Circle){
			if(this.radio == ((Circle) other).getRadio()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Circle other) {
		double otherRadio = other.getRadio();
		
		if(this.radio > otherRadio) {
			return 1;
		} else if(this.radio < otherRadio) {
			return -1;
		} else {
			return 0;
		}
	}

}

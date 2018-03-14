package Visitor;

public class MedicalProduct implements IProduct {

	private String name;
	private double price;
	
	public MedicalProduct(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() { return this.name; }
	public double getPrice() { return this.price; }

	@Override
	public double accept(IVisitor visitor) {
		return visitor.visit(this);
	}

}

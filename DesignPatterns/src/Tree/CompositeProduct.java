package Tree;

public class CompositeProduct extends Product {

	public CompositeProduct(String name, double cost, Product next) {
		super(name, cost);
		this.next = next;
	}

	private Product next;
	
	public String getProductList() { return next.getProductList() + " * " + getName() + "\n"; }
	
	@Override
	public double getCost() {
		return next.getCost() + super.getCost();
	}

}

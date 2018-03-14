package Tree;

public class Product {

	private String name;
	private double cost;
	
	protected Product(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() { return name; }
	
	public String getProductList() { return " * " + name + "\n"; } 

	public double getCost() { return cost; }
	
	private static Product currentProduct = null;
	
	public static Product newProduct(String name, double cost) {
		if(currentProduct == null)
			currentProduct = new Product(name, cost);
		else
			currentProduct = new CompositeProduct(name, cost, currentProduct);
		return currentProduct;
	}
	
}

package Tree;

public class _Program {

	public static void main(String[] args) {
		Product products;
		products = Product.newProduct("papa", 10);
		products = Product.newProduct("pimenton", 20);
		products = Product.newProduct("cebolla", 15);
		products = Product.newProduct("tomate", 12);
		products = Product.newProduct("ajo", 5);
		
		System.out.println(products.getCost());
		
		System.out.println(products.getProductList());
	}

}

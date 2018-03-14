package Visitor;

public class CustomVisitor implements IVisitor {

	@Override
	public double visit(IProduct item) {
		return item.getPrice() * 0.10;
	}

}

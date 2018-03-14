package Visitor;

public class TaxVisitor implements IVisitor {

	@Override
	public double visit(IProduct item) {
		return item.getPrice() * 0.19;
	}

}

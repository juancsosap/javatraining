package Visitor;

public class _Program {

	public static void main(String[] args) {
		
		IVisitor taxVisitor = new TaxVisitor();
		IVisitor customVisitor = new CustomVisitor();
		
		IProduct tv = new ElectronicProduct("TV", 350_000);
		IProduct viagra = new MedicalProduct("Viagra", 120_000);
		
		System.out.printf("%s cost %,.2f CLP plus %,.2f CLP in taxes and %,.2f CLP of Custom cost, for a total of %,.2f CLP.%n", 
				tv.getName(), tv.getPrice(), tv.accept(taxVisitor), tv.accept(customVisitor), 
				tv.getPrice() + tv.accept(taxVisitor) + tv.accept(customVisitor));
		
		System.out.printf("%s cost %,.2f CLP plus %,.2f CLP in taxes and %,.2f CLP of Custom cost, for a total of %,.2f CLP.%n", 
				viagra.getName(), viagra.getPrice(), viagra.accept(taxVisitor), viagra.accept(customVisitor), 
				viagra.getPrice() + viagra.accept(taxVisitor) + viagra.accept(customVisitor));
		
	}
	
}

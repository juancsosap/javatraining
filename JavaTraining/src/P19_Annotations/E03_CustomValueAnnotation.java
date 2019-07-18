package P19_Annotations;

public class E03_CustomValueAnnotation {

	@Author(name="Juan Sosa", team="Testing")
	class Person {
		
	}
	
	@interface Author {
		String name();
		String team();
	}

}

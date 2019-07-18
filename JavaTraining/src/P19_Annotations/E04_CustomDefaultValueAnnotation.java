package P19_Annotations;

public class E04_CustomDefaultValueAnnotation {

	@Information(priority=Priority.HIGH, version=2)
	class Person {
		public String name;
	}
	
	@Information
	class Employee extends Person {
		public String company;
	}
	
	@interface Information {
		Priority priority() default Priority.NORMAL;
		int version() default 1;
	}
	
	enum Priority { HIGH, NORMAL, LOW }

}

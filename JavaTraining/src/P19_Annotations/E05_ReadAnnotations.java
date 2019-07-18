package P19_Annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public class E05_ReadAnnotations {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		Person juan = new Person();
		Class juanClass = juan.getClass();
		Information infoJuan = (Information) juanClass.getAnnotation(Information.class);
		System.out.println("Class: " + juanClass.getName());
		System.out.println("Priority: " + infoJuan.priority());
		System.out.println("Version: " + infoJuan.version());
		Annotation[] annoJuan = juanClass.getAnnotations();
		Arrays.asList(annoJuan).forEach(System.out::println);
		
		System.out.println();
		
		Person jose = new Employee();
		Class joseClass = jose.getClass();
		Information infoJose = (Information) joseClass.getAnnotation(Information.class);
		System.out.println("Class: " + joseClass.getName());
		System.out.println("Priority: " + infoJose.priority());
		System.out.println("Version: " + infoJose.version());
		Annotation[] annoJose = juanClass.getAnnotations();
		Arrays.asList(annoJose).forEach(System.out::println);
		
		System.out.println();
		
		Person luis = new Client();
		Class luisClass = luis.getClass();
		Information infoLuis = (Information) luisClass.getAnnotation(Information.class);
		System.out.println("Class: " + luisClass.getName());
		System.out.println("Priority: " + infoLuis.priority());
		System.out.println("Version: " + infoLuis.version());
		Annotation[] annoLuis = juanClass.getAnnotations();
		Arrays.asList(annoLuis).forEach(System.out::println);
		
	}
	
	@InTesting
	@Information(priority=Priority.HIGH, version=2)
	private static class Person {
		@SuppressWarnings("unused")
		public String name;
	}
	
	@Information
	private static class Employee extends Person {
		@SuppressWarnings("unused")
		public String role;
	}
	
	private static class Client extends Person {
		@SuppressWarnings("unused")
		public String company;
	}
	
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.SOURCE)
	@interface InTesting {}
	
	@Documented
	@Inherited
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@interface Information {
		Priority priority() default Priority.NORMAL;
		int version() default 1; 
	}
	
	enum Priority { HIGH, NORMAL, LOW }

}

package P26_Reflexion;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class E09_ClassConstructor {

	public static void main(String[] args) {
		
		try {
			
			Class<?> objClass = Class.forName("P26_Reflexion.Employee");
			
			Person emp = (Person) objClass.getDeclaredConstructor().newInstance();
			emp.describe();
			System.out.println(objClass.getName());		
			
			System.out.println();
			
			Constructor<?>[] ctors = objClass.getConstructors();
			Arrays.asList(ctors).forEach(c -> describe(c));
			
			System.out.println("######################################");
			
			ctors = Class.forName("java.util.ArrayList").getConstructors();
			Arrays.asList(ctors).forEach(c -> describe(c));
			
		} catch (ClassNotFoundException    | InstantiationException   | 
				 IllegalAccessException    | IllegalArgumentException | 
				 InvocationTargetException | NoSuchMethodException    | 
				 SecurityException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void describe(Constructor<?> c) {
		System.out.println("-------------------");
		System.out.println("Name: " + c.getName());
		System.out.println("Modifier: " + Modifier.toString(c.getModifiers()));
		System.out.println("Parameters: " + c.getParameterCount());
		Arrays.asList(c.getParameters()).forEach(p -> describe(p));
		System.out.println("Annotations: " + c.getAnnotations().length);
		Arrays.asList(c.getAnnotations()).forEach(a -> System.out.println("> " + a));
		System.out.println("-------------------");
	}
	
	private static void describe(Parameter p) {
		System.out.println("> " + p.getName() + " [" + p.getType().getName() + "]");
	}

}

abstract class Person {
	
	public String name;
	public int age;
	
	public Person(String name, Integer age) {
		this.age = age;
		this.name = name;
	}
	
	public Person() {
		this("", 0);
	}
	
	public abstract String describe();
	
}

class Employee extends Person {

	public String role;
	
	public Employee(String name, Integer age, String role) {
		super(name, age);
		this.role = role;
	}
	
	public Employee() {
		this.role = "";
	}
	
	
	@Override
	public String describe() {
		return this.name + " - " + this.age + " : " + this.role;
	}
	
}

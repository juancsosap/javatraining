package P26_Reflexion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class E07_ClassMethods {

	public static void main(String[] args) {
		
		try {
			
			Class<?> objClass = Class.forName("P26_Reflexion.TalkLoud");
			
			TalkLoud talker = (TalkLoud) objClass.getDeclaredConstructor().newInstance();
			talker.set("Hello");
			talker.print();
			System.out.println(objClass.getName());		
			
			System.out.println();
			
			Method[] meths = objClass.getMethods();
			Arrays.asList(meths).forEach(m -> describe(m));
			
			System.out.println("######################################");
			
			meths = Class.forName("java.util.ArrayList").getMethods();
			Arrays.asList(meths).forEach(m -> describe(m));
			
		} catch (ClassNotFoundException    | InstantiationException   | 
				 IllegalAccessException    | IllegalArgumentException | 
				 InvocationTargetException | NoSuchMethodException    | 
				 SecurityException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void describe(Method m) {
		System.out.println("-------------------");
		System.out.println("Name: " + m.getName());
		System.out.println("Modifier: " + Modifier.toString(m.getModifiers()));
		System.out.println("Return: " + m.getReturnType());
		System.out.println("Parameters: " + m.getParameterCount());
		Arrays.asList(m.getParameters()).forEach(p -> describe(p));
		System.out.println("Annotations: " + m.getAnnotations().length);
		Arrays.asList(m.getAnnotations()).forEach(a -> System.out.println("> " + a));
		System.out.println("-------------------");
	}
	
	private static void describe(Parameter p) {
		System.out.println("> " + p.getName() + " [" + p.getType().getName() + "]");
	}

}

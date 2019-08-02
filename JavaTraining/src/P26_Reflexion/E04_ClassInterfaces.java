package P26_Reflexion;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class E04_ClassInterfaces {

	public static void main(String[] args) {
		
		try {
			
			Class<?> objClass = Class.forName("P26_Reflexion.Talk");
			
			Object obj = objClass.getDeclaredConstructor().newInstance();
			if(obj instanceof Settable) {
				Settable setter = (Settable) obj;
				setter.set("Hello");
			}
			if(obj instanceof Printable) {
				Printable printer = (Printable) obj;
				printer.print();
			}
			System.out.println(objClass.getName());		
			
			System.out.println();
			
			Class<?>[] inter = objClass.getInterfaces();
			Arrays.asList(inter).forEach(i -> System.out.println(i.getName()));
			
			System.out.println();
			
			inter = Class.forName("java.util.ArrayList").getInterfaces();
			Arrays.asList(inter).forEach(i -> System.out.println(i.getName()));
			
		} catch (ClassNotFoundException    | InstantiationException   | 
				 IllegalAccessException    | IllegalArgumentException | 
				 InvocationTargetException | NoSuchMethodException    | 
				 SecurityException e) {
			e.printStackTrace();
		}
		
	}

}

interface Settable {
	
	public void set(Object obj);
	
}

class Talk implements Printable, Settable {

	public String target = "";
	
	@Override
	public void print() {
		System.out.println(target);
	}

	@Override
	public void set(Object obj) {
		this.target = obj.toString();
	}
	
}

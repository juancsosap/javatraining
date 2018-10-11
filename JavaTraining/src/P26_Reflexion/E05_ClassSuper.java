package P26_Reflexion;

import java.lang.reflect.InvocationTargetException;

public class E05_ClassSuper {

	public static void main(String[] args) {
		
		try {
			
			Class<?> objClass = Class.forName("P26_Reflexion.TalkLoud");
			
			Object obj = objClass.getDeclaredConstructor().newInstance();
			Settable setter = (Settable) obj;
			setter.set("Hello");
			Printable printer = (Printable) obj;
			printer.print();
			System.out.println(objClass.getName());		
			
			System.out.println();
			
			Class<?> superClass = objClass.getSuperclass();
			System.out.println(superClass.getName());
			
			System.out.println();
			
			objClass = Class.forName("java.util.ArrayList");
			do {
				System.out.println(objClass.getName());
				objClass = objClass.getSuperclass();
			} while(objClass != null);
			
		} catch (ClassNotFoundException    | InstantiationException   | 
				 IllegalAccessException    | IllegalArgumentException | 
				 InvocationTargetException | NoSuchMethodException    | 
				 SecurityException e) {
			e.printStackTrace();
		}
		
	}

}

class TalkLoud extends Talk {

	@Override
	public void print() {
		System.out.println(target.toUpperCase());
	}
	
}

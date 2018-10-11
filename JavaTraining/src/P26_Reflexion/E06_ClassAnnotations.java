package P26_Reflexion;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class E06_ClassAnnotations {

	public static void main(String[] args) {
		
		try {
			
			Class<?> objClass = Class.forName("P26_Reflexion.TalkTooLoud");
			
			TalkLoud talker = (TalkTooLoud) objClass.getDeclaredConstructor().newInstance();
			talker.set("Hello");
			talker.print();
			System.out.println(objClass.getName());		
			
			System.out.println();
			
			Annotation[] annos = objClass.getAnnotations();
			Arrays.asList(annos).forEach(a -> System.out.println("> " + a));
			
			System.out.println();
			
			annos = Class.forName("java.util.function.Predicate").getAnnotations();
			Arrays.asList(annos).forEach(a -> System.out.println("> " + a));
			
		} catch (ClassNotFoundException   | InstantiationException   | 
				IllegalAccessException    | IllegalArgumentException | 
				InvocationTargetException | NoSuchMethodException    | 
				SecurityException e) {
			e.printStackTrace();
		}
		
	}

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface InTesting {}

@InTesting
class TalkTooLoud extends TalkLoud {}

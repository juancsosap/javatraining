package P26_Reflexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class E10_ReflexionWork {

	public static void main(String[] args) {
		
		// Open Properties Files
		String path = "files/data.properties";
		try(InputStream in = new FileInputStream(path)) {
			
			// Load Properties
			Properties p = new Properties();
			p.load(in);
			
			// Get Data from Properties
			String[] classNames = p.getProperty("classes").split(",");
			String[] types = p.getProperty("ctor_params").split(",");
			String[] datas = p.getProperty("data").split(";");
			String[][] fields = new String[datas.length][types.length];
			
			for(int i=0; i<datas.length; i++) {
				fields[i] = datas[i].split(",");
			}
					
			String methodName = p.getProperty("method");

			// Map Constructor Parameter Types Class Names to Class Objects
			int count = types.length;
			Class<?>[] typesClass = new Class<?>[count];
			for(int i=0; i<count; i++) {
				typesClass[i] = Class.forName(types[i]);
			}
			
			for(int i=0; i<classNames.length; i++) {
				// Create Required Class Object
				Class<?> objClass = Class.forName(classNames[i]);
				System.out.println(objClass.getName());
				
				// Create and prepare Constructor
				Constructor<?> objCtor = objClass.getConstructor(typesClass);
				Object[] fieldValues = new Object[count];
				for(int j=0; j<count; j++) {
					Constructor<?> ctor = typesClass[j].getConstructor(String.class);
					fieldValues[j] = ctor.newInstance(fields[i][j]);
				}
				
				// Create Required Object from Constructor
				Object obj = objCtor.newInstance(fieldValues);
				
				// Create Method Object
				Method method = objClass.getMethod(methodName);
				
				// Invoke Method for the Object
				System.out.println(method.invoke(obj));
				System.out.println();
			}
			
		} catch (ClassNotFoundException    | InstantiationException   | 
				 IllegalAccessException    | NoSuchMethodException    | 
				 SecurityException         | IllegalArgumentException | 
				 InvocationTargetException | IOException e) {
			e.printStackTrace();
		}
		
	}

}

class Client extends Person {

	public String company;
	
	public Client(String name, Integer age, String company) {
		super(name, age);
		this.company = company;
	}
	
	public Client() {
		this.company = "";
	}
	
	@Override
	public String describe() {
		return this.name + " - " + this.age + " : " + this.company;
	}
	
}

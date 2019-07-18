package P18_StreamFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class E06_Serialization {

	public static void main(String[] args) {
		
		String DIR = "files";
		
		String path = String.join(File.separator, DIR, "person.dat");
		
		ObjectFileUtils<Person> ofu = new ObjectFileUtils<>();
		
		Address addr = new Address("Chile", "Santiago", "Providencia", "101");
		Person per = new Person("Juan", 30, "10-10-2010", addr);
		
		System.out.println(per);
		System.out.println();
		
		ofu.write(per, path);
		
		System.out.println(ofu.read(path));
		
	}
	
	private static class ObjectFileUtils<T> {
		
		public void write(T obj, String path) {
			try(OutputStream out = new FileOutputStream(path);
				ObjectOutputStream outObject = new ObjectOutputStream(out)) {
				
				outObject.writeObject(obj);
				
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		@SuppressWarnings("unchecked")
		public T read(String path) {
			try(InputStream in = new FileInputStream(path);
				ObjectInputStream inObject = new ObjectInputStream(in)) {
				
				return (T) inObject.readObject();
				
			} catch(FileNotFoundException ex) {
				System.out.println("File not found");
			} catch(IOException | ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
			return null;
		}
		
	}
	
	private static class Person implements Serializable {
		
		private static final long serialVersionUID = 1234567890123456789L;
		
		public String name;
		public Integer age;
		public String birthday;
		public transient Address address;
		
		public Person(String name, Integer age, String birthday, Address address) {
			this.name = name; this.age = age; 
			this.birthday = birthday; this.address = address;
		}
		
		@Override
		public String toString() {
			return this.name + " (" + this.age + ") - " + this.birthday + "\n" + this.address;
		}
		
	}
	
	private static class Address {
		
		public String country;
		public String city;
		public String street;
		public String number;
		
		public Address(String country, String city, String street, String number) {
			this.country = country; this.city = city;
			this.street = street; this.number = number;
		}
		
		public String toString() {
			return this.street + " " + this.number + ". " + this.city + ". " + this.country;
		}
		
	}

}

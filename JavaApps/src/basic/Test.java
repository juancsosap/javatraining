package basic;

import java.util.ArrayList;
import java.util.Optional;

class Customer {
	private int id;
	private String name;
	
	public Customer(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Optional.ofNullable(name).orElse("??");
	}
	
	public String toString() {
		return id + ": " + name;
	}
	
	public static void print(Customer cust) {
		System.out.println(cust);
	}
	
}

public class Test {
	
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		
		customers.add(new Customer(1, "Juan"));
		customers.add(new Customer(2, "Luis"));
		customers.add(new Customer(3, "Pepe"));
		customers.add(new Customer(4, "Jose"));
		customers.add(new Customer(0, null));
		
		customers.sort((c, o) -> c.getName().compareTo(o.getName()));
		
		customers.forEach(c -> c.setName(c.getName() + " Sosa"));
		customers.forEach(c -> System.out.println(c));
		
		System.out.println();
		
		customers.stream()
		      //.filter(c -> c.getName().startsWith("J"))
		      //.filter(c -> c.getId() > 2)
		      .sorted((c,o) -> c.getId() > o.getId() ? -1 : c.getId() < o.getId() ? 1 : 0)
		      .forEach(Customer::print);
	}

}

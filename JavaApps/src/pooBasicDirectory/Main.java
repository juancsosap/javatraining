package pooBasicDirectory;

public class Main {

	public static void main(String[] args) {
		
		Person juan = new Person("Juan Sosa","M",35);
		
		String[] juan_phones = {"+56 9 4632 7016","+56 9 5427 3471"};
		ContactInfo juan_info = new ContactInfo("Huechuraba",juan_phones);
		
		Student juan_ing = new Student(juan,"Engineer",juan_info);
		
		System.out.println("Nombre: " + juan_ing.getName());
		System.out.println("Gender: " + juan_ing.getGender());
		System.out.println("Age: " + juan_ing.getAge() + " years");
		System.out.println("Branch: " + juan_ing.getBranch());
		System.out.println("Address: " + juan_ing.getContact().getAddress());
		
		System.out.print("Phones: ");
		boolean initial = true;
		for(String phone: juan_ing.getContact().getPhones()) {
			if(!initial) { System.out.print(" / "); }
			else { initial = false; }
			System.out.print(phone);
		}

	}

}

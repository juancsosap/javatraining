package P03_Strings;

public class E05_StringBuilder {

	public static void main(String[] args) {
		
		// Reserve a memory space to store exactly the text required (1 Character)
		String text1 = new String("0");
		
		// Create a new object in each concatenation
		text1 = text1.concat("1"); // (2 Character)  (1 Character copy + 1 Character added)
		text1 = text1.concat("2"); // (3 Character)  (2 Character copy + 1 Character added)
		text1 = text1.concat("3"); // (4 Character)  (3 Character copy + 1 Character added)
		text1 = text1.concat("4"); // (5 Character)  (4 Character copy + 1 Character added)
		text1 = text1.concat("5"); // (6 Character)  (5 Character copy + 1 Character added)
		text1 = text1.concat("6"); // (7 Character)  (6 Character copy + 1 Character added)
		text1 = text1.concat("7"); // (8 Character)  (7 Character copy + 1 Character added)
		text1 = text1.concat("8"); // (9 Character)  (8 Character copy + 1 Character added)
		text1 = text1.concat("9"); // (10 Character) (9 Character copy + 1 Character added)
		text1 = text1.concat("A"); // (11 Character) (10 Character copy + 1 Character added)
		text1 = text1.concat("B"); // (12 Character) (11 Character copy + 1 Character added)
		text1 = text1.concat("C"); // (13 Character) (12 Character copy + 1 Character added)
		text1 = text1.concat("D"); // (14 Character) (13 Character copy + 1 Character added)
		text1 = text1.concat("E"); // (15 Character) (14 Character copy + 1 Character added)
		text1 = text1.concat("F"); // (16 Character) (15 Character copy + 1 Character added)
		text1 = text1.concat("0"); // (17 Character) (16 Character copy + 1 Character added)
		text1 = text1.concat("1"); // (18 Character) (17 Character copy + 1 Character added)
		text1 = text1.concat("2"); // (19 Character) (18 Character copy + 1 Character added)
		text1 = text1.concat("3"); // (20 Character) (19 Character copy + 1 Character added)
		// In total 20 objects created, 20 characters added and 190 characters copied
		// Total memory occupated 210 Characters
		
		System.out.println(text1);
		
		// Reserve a memory space to store 16 Characters Initially
		StringBuilder text2 = new StringBuilder("0");
		
		// Append to an existing object
		text2.append("1"); // (2 Character)  (1 Character added)
		text2.append("2"); // (3 Character)  (1 Character added)
		text2.append("3"); // (4 Character)  (1 Character added)
		text2.append("4"); // (5 Character)  (1 Character added)
		text2.append("5"); // (6 Character)  (1 Character added)
		text2.append("6"); // (7 Character)  (1 Character added)
		text2.append("7"); // (8 Character)  (1 Character added)
		text2.append("8"); // (9 Character)  (1 Character added)
		text2.append("9"); // (10 Character)  (1 Character added)
		text2.append("A"); // (11 Character)  (1 Character added)
		text2.append("B"); // (12 Character)  (1 Character added)
		text2.append("C"); // (13 Character)  (1 Character added)
		text2.append("D"); // (14 Character)  (1 Character added)
		text2.append("E"); // (15 Character)  (1 Character added)
		text2.append("F"); // (16 Character)  (1 Character added)
		text2.append("0"); // (17 Character)  (16 Characters copied and 1 Character added)
		text2.append("1"); // (18 Character)  (1 Character added)
		text2.append("2"); // (19 Character)  (1 Character added)
		text2.append("3"); // (20 Character)  (1 Character added)
		// In total 2 objects created, 20 characters added and 16 characters copied
		// Total memory occupated 48 Characters
		
		System.out.println(text2.toString());
		
		// Reserve a memory space to store 20 Characters Initially
		StringBuilder text3 = new StringBuilder(20);
		text3.append(text2);
		// Each time the total size reserved is reach the StringBuilder 
		// reserve a new memory space with the double of size
		
		System.out.println(text3.toString());
		
	}

}

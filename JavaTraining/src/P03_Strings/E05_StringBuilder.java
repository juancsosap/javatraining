package P03_Strings;

public class E05_StringBuilder {

	public static void main(String[] args) {
		
		System.out.println("---- String Text ----");
		
		// Reserve a memory space to store exactly the text required (1 Character)
		String text1 = new String("0");
		System.out.println("Text Size [0]: " + text1.length());
		
		// Create a new object in each concatenation
		text1 = text1.concat("1"); // (2 Character)  (1 Character copy + 1 Character added)
		System.out.println("Text Size [1]: " + text1.length());
		text1 = text1.concat("2"); // (3 Character)  (2 Character copy + 1 Character added)
		System.out.println("Text Size [2]: " + text1.length());
		text1 = text1.concat("3"); // (4 Character)  (3 Character copy + 1 Character added)
		System.out.println("Text Size [3]: " + text1.length());
		text1 = text1.concat("4"); // (5 Character)  (4 Character copy + 1 Character added)
		System.out.println("Text Size [4]: " + text1.length());
		text1 = text1.concat("5"); // (6 Character)  (5 Character copy + 1 Character added)
		System.out.println("Text Size [5]: " + text1.length());
		text1 = text1.concat("6"); // (7 Character)  (6 Character copy + 1 Character added)
		System.out.println("Text Size [6]: " + text1.length());
		text1 = text1.concat("7"); // (8 Character)  (7 Character copy + 1 Character added)
		System.out.println("Text Size [7]: " + text1.length());
		text1 = text1.concat("8"); // (9 Character)  (8 Character copy + 1 Character added)
		System.out.println("Text Size [8]: " + text1.length());
		text1 = text1.concat("9"); // (10 Character) (9 Character copy + 1 Character added)
		System.out.println("Text Size [9]: " + text1.length());
		text1 = text1.concat("A"); // (11 Character) (10 Character copy + 1 Character added)
		System.out.println("Text Size [A]: " + text1.length());
		text1 = text1.concat("B"); // (12 Character) (11 Character copy + 1 Character added)
		System.out.println("Text Size [B]: " + text1.length());
		text1 = text1.concat("C"); // (13 Character) (12 Character copy + 1 Character added)
		System.out.println("Text Size [C]: " + text1.length());
		text1 = text1.concat("D"); // (14 Character) (13 Character copy + 1 Character added)
		System.out.println("Text Size [D]: " + text1.length());
		text1 = text1.concat("E"); // (15 Character) (14 Character copy + 1 Character added)
		System.out.println("Text Size [E]: " + text1.length());
		text1 = text1.concat("F"); // (16 Character) (15 Character copy + 1 Character added)
		System.out.println("Text Size [F]: " + text1.length());
		text1 = text1.concat("G"); // (17 Character) (16 Character copy + 1 Character added)
		System.out.println("Text Size [G]: " + text1.length());
		text1 = text1.concat("H"); // (18 Character) (17 Character copy + 1 Character added)
		System.out.println("Text Size [H]: " + text1.length());
		text1 = text1.concat("I"); // (19 Character) (18 Character copy + 1 Character added)
		System.out.println("Text Size [I]: " + text1.length());
		text1 = text1.concat("J"); // (20 Character) (19 Character copy + 1 Character added)
		System.out.println("Text Size [J]: " + text1.length());
		// In total 20 objects created, 20 characters added and 190 characters copied
		// Total memory occupated 210 Characters
		
		System.out.println("Text: \"" + text1 + "\"\n");
		
		// -----------------------------------------------------------------------------------------
		System.out.println("---- StringBuilder Text ----");
		
		// Reserve a memory space to store 17 Characters Initially
		StringBuilder text2 = new StringBuilder("0");
		System.out.println("Text Size / Capacity [0]: " + text2.length() + " / " + text2.capacity());
		
		// Append to an existing object
		text2.append("1"); // (2 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [1]: " + text2.length() + " / " + text2.capacity());
		text2.append("2"); // (3 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [2]: " + text2.length() + " / " + text2.capacity());
		text2.append("3"); // (4 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [3]: " + text2.length() + " / " + text2.capacity());
		text2.append("4"); // (5 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [4]: " + text2.length() + " / " + text2.capacity());
		text2.append("5"); // (6 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [5]: " + text2.length() + " / " + text2.capacity());
		text2.append("6"); // (7 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [6]: " + text2.length() + " / " + text2.capacity());
		text2.append("7"); // (8 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [7]: " + text2.length() + " / " + text2.capacity());
		text2.append("8"); // (9 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [8]: " + text2.length() + " / " + text2.capacity());
		text2.append("9"); // (10 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [9]: " + text2.length() + " / " + text2.capacity());
		text2.append("A"); // (11 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [A]: " + text2.length() + " / " + text2.capacity());
		text2.append("B"); // (12 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [B]: " + text2.length() + " / " + text2.capacity());
		text2.append("C"); // (13 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [C]: " + text2.length() + " / " + text2.capacity());
		text2.append("D"); // (14 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [D]: " + text2.length() + " / " + text2.capacity());
		text2.append("E"); // (15 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [E]: " + text2.length() + " / " + text2.capacity());
		text2.append("F"); // (16 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [F]: " + text2.length() + " / " + text2.capacity());
		text2.append("G"); // (17 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [G]: " + text2.length() + " / " + text2.capacity());
		text2.append("H"); // (18 Character)  (17 Characters copied and 1 Character added)
		System.out.println("Text Size / Capacity [H]: " + text2.length() + " / " + text2.capacity());
		text2.append("I"); // (19 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [I]: " + text2.length() + " / " + text2.capacity());
		text2.append("J"); // (20 Character)  (1 Character added)
		System.out.println("Text Size / Capacity [J]: " + text2.length() + " / " + text2.capacity());
		// In total 2 objects created, 20 characters added and 17 characters copied
		// Total memory occupated 53 Characters
		
		System.out.println("Text: \"" + text2.toString() + "\"\n");
		
		// -----------------------------------------------------------------------------------------
		System.out.println("---- StringBuilder Text (Pre-Set Capacity) ----");	
		
		// Reserve a memory space to store 10 Characters Initially
		StringBuilder text3 = new StringBuilder(10);
		System.out.println("Initial Text Size / Capacity [J]: " + text3.length() + " / " + text3.capacity());
		
		text3.append(text2);
		// Each time the total size reserved is reach the StringBuilder 
		// reserve a new memory space with the double of size
		System.out.println("Final Text Size / Capacity [J]: " + text3.length() + " / " + text3.capacity());
		
		System.out.println("Text: \"" + text3.toString() + "\"\n");
		
		// -----------------------------------------------------------------------------------------
		System.out.println("---- StringBuilder Text Deleting ----");	
		
		text3.delete(0, 10);
		text3.deleteCharAt(5);
		System.out.println("Text Size / Capacity : " + text3.length() + " / " + text3.capacity());
		System.out.println("Text: \"" + text3.toString() + "\"\n");
		
		// -----------------------------------------------------------------------------------------
		System.out.println("---- StringBuilder Text Setting Capacity ----");	
		text3.trimToSize();
		System.out.println("Text Size / Capacity : " + text3.length() + " / " + text3.capacity() + "\n");
		
		// -----------------------------------------------------------------------------------------
		System.out.println("---- StringBuilder Text Editing ----");	
		System.out.println("Original Text:      \"" + text3.toString() + "\"");
		text3.setCharAt(5, 'Z');
		System.out.println("Changed Char Text:  \"" + text3.toString() + "\"");
		text3.insert(5, '0');
		System.out.println("Inserted Char Text: \"" + text3.toString() + "\"");
		text3.replace(2, 8, "01234");
		System.out.println("Replaced Text:      \"" + text3.toString() + "\"");
		text3.reverse();
		System.out.println("Reversed Text:      \"" + text3.toString() + "\"\n");
		
	}

}

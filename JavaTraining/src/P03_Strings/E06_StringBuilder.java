package P03_Strings;

public class E06_StringBuilder {

	public static void main(String[] args) {
		
		System.out.println("---- String Text ----");
		
		// Reserve a memory space to store exactly the text required (1 Character)
		String text1 = "";
		System.out.println("Text Size: " + text1.length());
		
		// Create a new object in each concatenation
		for(int i=0; i<20; i++) {
			text1 = text1.concat("0");
			System.out.println("Text Size: " + text1.length());
		}
		// In total 20 objects created, 20 characters added and 190 characters copied
		// Total memory occupated 210 Characters
		
		System.out.println("Text: \"" + text1 + "\"\n");
		
		// -----------------------------------------------------------------------------------------
		System.out.println("---- StringBuilder Text ----");
		
		// Reserve a memory space to store 16 Characters Initially
		StringBuilder text2 = new StringBuilder("");
		System.out.println("Text Size / Capacity: " + text2.length() + " / " + text2.capacity());
		
		// Append to an existing object
		// Re-sizable size (2 x CurrentSize + 2 = NewSize)
		for(int i=0; i<20; i++) {
			text2.append("1");
			System.out.println("Text Size / Capacity: " + text2.length() + " / " + text2.capacity());
		}
		// In total 2 objects created, 20 characters added and 17 characters copied
		// Total memory occupated 53 Characters
		
		System.out.println("Text: \"" + text2.toString() + "\"\n");
		
		// -----------------------------------------------------------------------------------------
		System.out.println("---- StringBuilder Text (Pre-Set Capacity) ----");	
		
		// Reserve a memory space to store 10 Characters Initially
		StringBuilder text3 = new StringBuilder(10);
		System.out.println("Initial Text Size / Capacity: " + text3.length() + " / " + text3.capacity());
		
		text3.append(text2);
		// Each time the total size reserved is reach the StringBuilder 
		System.out.println("Final Text Size / Capacity: " + text3.length() + " / " + text3.capacity());
		
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

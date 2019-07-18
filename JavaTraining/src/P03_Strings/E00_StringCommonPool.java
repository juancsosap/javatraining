package P03_Strings;

public class E00_StringCommonPool {

	public static void main(String[] args) {
		
		// Constants String Values are located in the String Pool Memory
		String text1 = "This is a Text";
		
		// As the text is the same the value in the String Pool is reused
		// Then text1 and text2 point to the same memory location
		String text2 = "This is a Text";
		System.out.println(text1 == text2);
		
		// Its line locate 2 new string objects in the pool
		// After the concatenation of the String constants 
		//   the value is located if it's available in the
		//   string pool and if it's, the reference is asociated
		//   to the existing value
		String text3 = "This is" + " a Text";
		System.out.println(text1 == text3);
		
		// The variables are referencied to the existing values
		//   in the string pool
		String text4 = "This is";
		String text5 = " a Text";
		
		// As text6 is created from variables is not consider as
		//   a string constant and is not located in the string
		//   pool, then it's put in the Heap Memory
		String text6 = text4 + text5;
		System.out.println(text1 == text6);
		
		// When the new keyword is used the value is storage directly
		//   in the Heap Memory
		String text7 = new String("This is a Text");
		System.out.println(text1 == text7);

	}

}

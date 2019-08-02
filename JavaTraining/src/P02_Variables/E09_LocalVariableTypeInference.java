package P02_Variables;

public class E09_LocalVariableTypeInference {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		int a = 10;
		System.out.println(a);
		
		var b = 10;
		//b = "sdjfhdjkfn";
		
		int[] c = {1,2,3,4};
		
		for(var d : c) {
			
		}
		
		// JAVA10
		//var b = 20.1;
		//System.out.println(b);
		
		
		
		//var a =  new String("");
		
	}

}

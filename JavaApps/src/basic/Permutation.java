package basic;

public class Permutation {
	
	private static long count = 0;

	public static void main(String[] args) {
		String values = "0123456789";
		int maxlength = 8;
		for(int length=1; length<=maxlength; length++) {
			for(int i=1; i<=length; i++) {
				bruteForce(i, values);
			}
			System.out.println("Total Combinations with " + length + " characters: " + count);
			count=0;
		}
	}	
	
	public static void bruteForce(int size, String values) {
	    int[] password = new int[size];
	    String[] finalPassword = new String[size];
	    String pass = "";
	    for (int i = 0; i < size; i++) {
	    	password[i] = 0;
	    	finalPassword[i] = "";
	    	pass += values.charAt(values.length()-1);
	    }
	    computePermutations(size, password, 0, pass, values);
	}
	
	private static String computePermutations(int size, int[] password, int position, String pass, String values) {
		String chars = values;
		String testString = "";
		String assemble = "";
		
		for(int i = 0; i < values.length(); i++) {
			password[position] = i;

		    if(position != size - 1) {
		    	testString = computePermutations(size, password, position + 1, pass, values);
		        if (testString != "") {
		        	return testString;
		        }
		    } else if(position == size - 1) {
		        for(int j = 0; j < size; j++) {
		        	assemble += chars.charAt(password[j]);
		        }
		        //System.out.println(assemble);
		        count++;
		        if (assemble.equalsIgnoreCase(pass)) {
		        	break; //replace this with: return assemble;
		        } else {
		        	assemble = "";
		        }
		    }
		}
		return "";
	}
	
}
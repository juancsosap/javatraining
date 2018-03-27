package basic;

import java.util.Arrays;
import java.util.List;

public class Anagram {

	public static boolean isAnagram(String a, String b) {
		List<String> A = Arrays.asList(a.toUpperCase().split(""));
		A.sort((s1, s2) -> s1.compareTo(s2));
		
		List<String> B = Arrays.asList(b.toUpperCase().split(""));
		B.sort((s1, s2) -> s1.compareTo(s2));
		
		return A.toString().equals(B.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("CATERPILA", "CAATERPIL"));
	}

}

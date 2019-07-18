package P24_Regex;

public class E02_StringSplit {

	public static void main(String[] args) {
		
		// https://regexr.com/
		
		String pattern1 = "\\.";
		count("a.b.c.d.e", pattern1);
		count("a..b..c..d", pattern1);
		count("www.netec.com", pattern1);
		count("docs.aws.amazon.com", pattern1);
		
		System.out.println();
		
		String pattern2 = ",";
		count("1,2,3,4,5", pattern2);
		count("hola, como estas", pattern2);
		count("juan, luis, pepe, maria", pattern2);
		count("1,2,,3,,,4,,,,", pattern2);
		
		System.out.println();
		
		String pattern3 = "[-:.]";
		count("192.168.1.1", pattern3);
		count("aa:bb:cc:dd:ee:ff", pattern3);
		count("23.123.456-7", pattern3);
		count("ABCD12-3", pattern3);
		
	}
	
	private static void count(String value, String pattern) {
		int count = value.split(pattern).length;
		System.out.println(count);
	}

}

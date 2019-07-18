package P03_Strings;

import java.time.LocalDateTime;

public class E08_StringBuildervsString {

	public static void main(String[] args) {
		
		LocalDateTime ini = LocalDateTime.now();
		
		String s = "";
		for(int i=0; i < 1_000_000; i++) {
			s += 'A';
		}
		
		LocalDateTime end = LocalDateTime.now();
		
		System.out.println(ini);
		System.out.println(end);
		
		ini = LocalDateTime.now();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < 1_000_000; i++) {
			sb.append('A');
		}
		
		end = LocalDateTime.now();
		
		System.out.println(ini);
		System.out.println(end);
		
		ini = LocalDateTime.now();
		
		StringBuilder sb2 = new StringBuilder(1_000_000);
		for(int i=0; i < 1_000_000; i++) {
			sb.append('A');
		}
		
		end = LocalDateTime.now();
		
		System.out.println(ini);
		System.out.println(end);

	}

}

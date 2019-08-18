package test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static int a = 5;
	
	public static void main(String[] args) {
		
		Test t1 = new Test();
		Test t2 = new Test();
		System.out.println(t1.a + t2.a + Test.a);
		
		String s1 = "";
		String s2 = "";
		
		System.out.println(s1 == s2);
		
		
		System.out.println(s1.equals(s2));
		
		StringBuilder sb1 = new StringBuilder();
		
		StringBuilder sb2 = new StringBuilder();
		
		System.out.println(sb1 == sb2);

		System.out.println(sb1.equals(sb2));
		
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		System.out.println(s1.equals(sb1));
		System.out.println(sb1.equals(s1));
		
		System.out.println(s1.toString().equals(sb1.toString()));
		System.out.println(sb1.toString().equals(s1.toString()));
		
		try {
			List l = new ArrayList();
			while(true) {
				l.add(1);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}
	
	interface testiable {
		void m1();
		void m2();
	}
	
	abstract class tester implements testiable {
		public void m1() {}
		public abstract void m3();
	}
	
	abstract class xsd extends tester {
		public void m2() {}
	}

}

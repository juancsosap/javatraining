package netec.ocp.advanced;

public class Test102 {

	public static void main(String[] args) {
		A a1 = new B();
		A a2 = new C();
		System.out.println(a1.get());
		System.out.println(a2.get());
		
		for(Letters x : Letters.values()) {
			System.out.println(x);
			System.out.println(x.get());
			x.compareTo(x);
		}
		
		X.Y.call();
	}

}

class A {
	int n = 1;
	public int get() {
		return n;
	}
}

class B extends A {
	int n = 2;
}

class C extends A {
	int n = 3;
	public int get() {
		return n;
	}
}

interface Gettable<T> {
	public T get();
}

enum Letters implements Gettable<Character> {
	A('a'), B('b'), C('c'), D('d');
	
	private char l;
	
	private Letters(char l) {
		this.l = l;
	}
	
	public Character get() {
		return this.l;
	}
}

class X {
	static class Y {
		static void call() {
			
		}
	}
}


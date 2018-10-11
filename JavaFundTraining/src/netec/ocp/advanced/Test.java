package netec.ocp.advanced;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface I1 {
	public void m0();
}

@SuppressWarnings("unused")
abstract class C1 implements I1 {
	
	public void m1() {}
	
	private void m2() {}
	
	protected void m3() {}
	
	public abstract void a1();
	
	public abstract void a2();
	
}

class C2 extends C1 {

	public void m1() {}
	
	public void a1() {}
	
	public void a2() {}

	public void m0() {}
	
}


class Multi {
	
	int i;
	long l;
	
	Multi(int i) {
	 this.i = i;
	}
	
	Multi(int i, long l) {
		this(i);
		this.l = l;
	}
	
}

class SubMulti extends Multi {
	
	short s;
	
	SubMulti(short s) {
		super(1);
		this.s = s;
	}
	
	SubMulti(short s, int i) {
		super(i);
		//this(s);
	}
	
}


interface Readable {
	public void readBook();
	public void setBookMark();
}

abstract class Book implements Readable {
	public void readBook() {}
}

class Ebook extends Book {
	public void readBook() {}
	public void setBookMark() {}
}
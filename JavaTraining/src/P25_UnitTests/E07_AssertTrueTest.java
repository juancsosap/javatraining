package P25_UnitTests;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class E07_AssertTrueTest {
	
	private static OperatorPlus oper;
	
	@BeforeClass
	public static void setUpClass() {
		// Arrange
		oper = new OperatorPlus();
		System.out.println("Initializing Test Class");
	}

	@AfterClass
	public static void tearDownClass() {
		oper = null;
		System.out.println("Endding Test Class");
	}

	@Before
	public void setUp() {
		System.out.println("Initializing Test");
	}
	
	@After
	public void tearDown() {
		System.out.println("Endding Test");		
	}
	
	@Test
	public void addTest_AddingCeros() {
		// Act
		int result = oper.add(0, 0);
		
		// Assert
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void addTest_AddingPositive() {
		// Act
		int result = oper.add(2, 2);
		
		// Assert
		Assert.assertEquals(4, result);
	}
	
	@Test
	public void addTest_AddingNegative() {
		// Act
		int result = oper.add(-2, -3);
		
		// Assert
		Assert.assertEquals(-5, result);
	}
	
	@Test
	public void addTest_AddingMixed() {
		// Act
		int result = oper.add(4, -3);
		
		// Assert
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void addTest_IntegerPositiveExceeded() {
		// Act
		boolean throwsed = false;
		try {
			oper.add(Integer.MAX_VALUE, 1);
		} catch(ArithmeticException ex) {
			throwsed = true;
		}
		
		// Assert
		Assert.assertTrue(throwsed);
	}
	
	@Test
	public void addTest_IntegerNegativeExceeded() {
		// Act
		boolean throwsed = false;
		try {
			oper.add(Integer.MIN_VALUE, -1);
		} catch(ArithmeticException ex) {
			throwsed = true;
		}
		
		// Assert
		Assert.assertEquals(true, throwsed);
		Assert.assertTrue(throwsed);
	}
	
}

class OperatorPlus {
	
	public int add(int e1, int e2) throws ArithmeticException {
		int r = e1 + e2;
		if(e1 > 0 && e2 > 0 && r < 0 ) throw new ArithmeticException();
		if(e1 < 0 && e2 < 0 && r > 0 ) throw new ArithmeticException();
		return r;
	}
	
}
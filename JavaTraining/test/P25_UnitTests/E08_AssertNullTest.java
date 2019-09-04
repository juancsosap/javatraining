package P25_UnitTests;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

public class E08_AssertNullTest {
	
	private static OperatorUltra oper;
	
	@BeforeClass
	public static void setUpClass() {
		// Arrange
		oper = new OperatorUltra();
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
	public void addTest_AddingNull() {
		// Act
		Integer result1 = oper.add(null, 10);
		Integer result2 = oper.add(10, null);
		Integer result3 = oper.add(null, null);
		
		// Assert
		Assert.assertNull(result1);
		Assert.assertNull(result2);
		Assert.assertNull(result3);
		Assert.assertEquals(null, result3);
	}
	
	@Test
	public void addTest_AddingCeros() {
		// Act
		Integer result = oper.add(0, 0);
		
		// Assert
		Assert.assertEquals(Integer.valueOf(0), result);
	}
	
	@Test
	public void addTest_AddingPositive() {
		// Act
		Integer result = oper.add(2, 2);
		
		// Assert
		Assert.assertEquals(Integer.valueOf(4), result);
	}
	
	@Test
	public void addTest_AddingNegative() {
		// Act
		Integer result = oper.add(-2, -3);
		
		// Assert
		Assert.assertEquals(Integer.valueOf(-5), result);
	}
	
	@Test
	public void addTest_AddingMixed() {
		// Act
		Integer result = oper.add(4, -3);
		
		// Assert
		Assert.assertEquals(Integer.valueOf(1), result);
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
		Assert.assertTrue(throwsed);
	}
	
}
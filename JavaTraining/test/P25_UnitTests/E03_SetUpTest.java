package P25_UnitTests;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

public class E03_SetUpTest {
	
	private Operator oper;
	
	@Before
	public void setUp() {
		// Arrange
		this.oper = new Operator();
		System.out.println("Initializing Test");
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
		int result = oper.add(Integer.MAX_VALUE, 1);
		
		// Assert
		Assert.assertEquals(Integer.MIN_VALUE, result);
	}
	
	@Test
	public void addTest_IntegerNegativeExceeded() {
		// Act
		int result = oper.add(Integer.MIN_VALUE, -1);
		
		// Assert
		Assert.assertEquals(Integer.MAX_VALUE, result);
	}
	
}
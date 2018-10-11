package P25_UnitTests;

import org.junit.Test;

import org.junit.Assert;

public class E02_SplitTest {
	
	@Test
	public void addTest_AddingCeros() {
		// Arrange
		Operator oper = new Operator();
		
		// Act
		int result = oper.add(0, 0);
		
		// Assert
		Assert.assertEquals(0, result);
	}
	
	@Test
	public void addTest_AddingPositive() {
		// Arrange
		Operator oper = new Operator();
		
		// Act
		int result = oper.add(2, 2);
		
		// Assert
		Assert.assertEquals(4, result);
	}
	
	@Test
	public void addTest_AddingNegative() {
		// Arrange
		Operator oper = new Operator();
		
		// Act
		int result = oper.add(-2, -3);
		
		// Assert
		Assert.assertEquals(-5, result);
	}
	
	@Test
	public void addTest_AddingMixed() {
		// Arrange
		Operator oper = new Operator();
		
		// Act
		int result = oper.add(4, -3);
		
		// Assert
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void addTest_IntegerPositiveExceeded() {
		// Arrange
		Operator oper = new Operator();
		
		// Act
		int result = oper.add(Integer.MAX_VALUE, 1);
		
		// Assert
		Assert.assertEquals(Integer.MIN_VALUE, result);
	}
	
	@Test
	public void addTest_IntegerNegativeExceeded() {
		// Arrange
		Operator oper = new Operator();
		
		// Act
		int result = oper.add(Integer.MIN_VALUE, -1);
		
		// Assert
		Assert.assertEquals(Integer.MAX_VALUE, result);
	}
	
}
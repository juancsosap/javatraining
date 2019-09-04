package P25_UnitTests;

import org.junit.Test;

import org.junit.Assert;

public class E01_AssertEqualsTest {
	
	@Test
	public void addTest() {
		// Arrange
		Operator oper = new Operator();
		
		// Act
		int result1 = oper.add(0, 0);
		int result2 = oper.add(2, 2);
		int result3 = oper.add(-2, -3);
		int result4 = oper.add(4, -3);
		int result5 = oper.add(Integer.MAX_VALUE, 1);
		int result6 = oper.add(Integer.MIN_VALUE, -1);
		
		// Assert
		Assert.assertEquals(0, result1);
		Assert.assertEquals(4, result2);
		Assert.assertEquals(-5, result3);
		Assert.assertEquals(1, result4);
		Assert.assertEquals(Integer.MIN_VALUE, result5);
		Assert.assertEquals(Integer.MAX_VALUE, result6);
	}
	
}
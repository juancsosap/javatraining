package P25_UnitTests;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class E04_TearDownTest {
	
	private Accumulator accu;
	
	@Before
	public void setUp() {
		// Arrange
		this.accu = new Accumulator(1);
		System.out.println("Initializing Test");
	}
	
	@After
	public void tearDown() {
		System.out.println("Endding Test");		
	}
	
	@Test
	public void addTest_AddCero() {
		// Act
		int result = accu.add(0);
		
		// Assert
		Assert.assertEquals(1, result);
	}
	
	@Test
	public void addTest_AddPositive() {
		// Act
		int result = accu.add(2);
		
		// Assert
		Assert.assertEquals(3, result);
	}
	
	@Test
	public void addTest_AddNegative() {
		// Act
		int result = accu.add(-2);
		
		// Assert
		Assert.assertEquals(-1, result);
	}
	
	@Test
	public void addTest_AddMaxInteger() {
		// Act
		int result = accu.add(Integer.MAX_VALUE);
		
		// Assert
		Assert.assertEquals(Integer.MIN_VALUE, result);
	}
	
	@Test
	public void addTest_AddMinInteger() {
		// Act
		int result = accu.add(Integer.MIN_VALUE);
		
		// Assert
		Assert.assertEquals(Integer.MIN_VALUE + 1, result);
	}
	
}
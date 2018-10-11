package P25_UnitTests;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class E06_TearDownClassTest {
	
	private static AccumulatorPlus accu;
	
	@BeforeClass
	public static void setUpClass() {
		// Arrange
		accu = new AccumulatorPlus(1);
		System.out.println("Initializing Test Class");
	}

	@AfterClass
	public static void tearDownClass() {
		accu = null;
		System.out.println("Endding Test Class");
	}

	@Before
	public void setUp() {
		// Arrange
		accu.set(1);
		System.out.println("Initializing Test: " + accu.get());
	}
	
	@After
	public void tearDown() {
		System.out.println("Endding Test: " + accu.get());		
	}
	
	@Test
	@Ignore
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
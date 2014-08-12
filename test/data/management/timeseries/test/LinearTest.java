package data.management.timeseries.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import data.management.timeseries.Linear;

/**
 * Tests for linear time series analysis
 * 
 * @author Ben Long
 */
public class LinearTest {
	
	/**Allows us to catch exceptions*/
	@Rule
  public ExpectedException thrown = ExpectedException.none();
	
	/**Small int array*/
	private int[] zeros = {0};
	
	/**Simple int array*/
	private int[] simple = {2,4,6};
	
	/**Complex int array*/
	private int[] complex = {1,3,7,2,5,8,8,2,3,4,9,6,4,1,4,7,4,4,2,7};
	
	/**Small double array*/
	private double[] zerosD = {0.0};
	
	/**Simple double array*/
	private double[] simpleD = {2.0,4.0,6.0};
	
	/**Complex double array*/
	private double[] complexD = {1.0,3.0,7.0,2.0,5.0,8.0,8.0,2.0,3.0,4.0,9.0,6.0,4.0,1.0,4.0,7.0,4.0,4.0,2.0,7.0};

	/**
	 * Test method for {@link data.management.timeseries.Linear#mean(int[])}.
	 */
	@Test
	public void testMeanIntArrayNull() {
		//First, test null array
		int[] empty = null;
		thrown.expect(NullPointerException.class);
		Linear.mean(empty);
	}
	
	/**
	 * Test method for {@link data.management.timeseries.Linear#mean(int[])}.
	 */
	@Test
	public void testMeanIntArray() {
		//Empty array
		assertEquals(0.0,Linear.mean(this.zeros),0);
		
		//Simple array
		assertEquals(4.0,Linear.mean(this.simple),0);
		
		//Complex array
		assertEquals(4.55,Linear.mean(this.complex),0);
	}

	/**
	 * Test method for {@link data.management.timeseries.Linear#mean(double[])}.
	 */
	@Test
	public void testMeanDoubleArray() {
		//Empty array
		assertEquals(0.0,Linear.mean(this.zerosD),0);
		
		//Simple array
		assertEquals(4.0,Linear.mean(this.simpleD),0);
		
		//Complex array
		assertEquals(4.55,Linear.mean(this.complexD),0);
	}

	/**
	 * Test method for {@link data.management.timeseries.Linear#standardDeviation(int[])}.
	 */
	@Test
	public void testStandardDeviationIntArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link data.management.timeseries.Linear#standardDeviation(double[])}.
	 */
	@Test
	public void testStandardDeviationDoubleArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link data.management.timeseries.Linear#coefficientOfVariation(int[])}.
	 */
	@Test
	public void testCoefficientOfVariationIntArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link data.management.timeseries.Linear#coefficientOfVariation(double[])}.
	 */
	@Test
	public void testCoefficientOfVariationDoubleArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link data.management.timeseries.Linear#normalizeByMean(double[])}.
	 */
	@Test
	public void testNormalizeByMean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link data.management.timeseries.Linear#normalizeByStandardDeviation(double[])}.
	 */
	@Test
	public void testNormalizeByStandardDeviation() {
		fail("Not yet implemented");
	}

}

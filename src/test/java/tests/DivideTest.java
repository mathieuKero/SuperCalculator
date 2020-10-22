package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.Addition;
import controllers.Divide;

/**
 * Addition Test Class
 * @author Mathieu K
 */
public class DivideTest {

	private Divide div;
	
	/**
	 * Before the test, we create a new addition
	 * @exception java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * After the test we verify that the AdditionTwoNumbers method result has the expected type
	 * @exception java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This is the test of the Multiply method.
	 */
	@Test
	public void DivideTwoNumbers() {
		div = new Divide(12, 3);
		double result = this.div.calculate();
		Assert.assertEquals(4, result, 0.0001);
	}
	
	@Test
	public void DivideTwoNumbersWithZero() {
		div = new Divide(12, 0);
		double result = this.div.calculate();
		Assert.assertEquals(0, result, 0.0001);
	}

}

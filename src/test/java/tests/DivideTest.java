
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
@SuppressWarnings("CPD-START")
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
		div = new Divide(12);
		this.div.redo(3);
		Assert.assertEquals(4, div.getValue(), 0.0001);
	}
	
	@Test
	public void DivideTwoNumbersWithZero() {
		div = new Divide(12);
		this.div.redo(0);
		Assert.assertEquals(12, div.getValue(), 0.0001);
	}

}

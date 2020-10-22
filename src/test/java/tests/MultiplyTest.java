package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.Addition;
import controllers.Multiply;

/**
 * Addition Test Class
 * @author Mathieu K
 */
@SuppressWarnings("CPD-START")
public class MultiplyTest {

	private Multiply multi;
	
	/**
	 * Before the test, we create a new addition
	 * @exception java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		multi = new Multiply(10, 5);
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
	public void MultiplyTwoNumbers() {
		this.multi.calculate();
		Assert.assertEquals(50, multi.getResult(), 0.0001);
	}

} 	


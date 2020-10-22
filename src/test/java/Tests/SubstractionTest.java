package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.Substraction;

/**
 * Addition Test Class
 * @author Mathieu K
 */
public class SubstractionTest {

	private Substraction sub;
	
	/**
	 * Before the test, we create a new addition
	 * @exception java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sub = new Substraction(5.5, 5.5);
	}

	/**
	 * After the test we verify that the SubstractionTwoNumbers result has the expected type
	 * @exception java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This is the test of the Addition method.
	 */
	@Test
	public void SubstractionTwoNumbers() {
		this.sub.calculate();
		Assert.assertEquals(0, sub.getResult(), 0.0001);
	}

}

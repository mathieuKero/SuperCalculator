package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Controllers.Addition;

/**
 * Addition Test Class
 * @author Mathieu K
 */
public class AdditionTest {

	private Addition add;

	/**
	 * Before the test, we create a new addition
	 * @exception java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		add = new Addition();
	}
	
	/**
	 * After the test we verify that the AdditionTwoNumbers method result has the expected type
	 * @exception java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This is the test of the Addition method.
	 */
	@Test
	public void AdditionTwoNumbers() {
		double result = this.add.Addition(1, 2);
		Assert.assertEquals(3, result, 0.0001);
	}

}

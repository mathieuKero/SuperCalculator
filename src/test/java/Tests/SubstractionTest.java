package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Controllers.Substraction;

public class SubstractionTest {

	private Substraction sub;
	
	@Before
	public void setUp() throws Exception {
		sub = new Substraction();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void SubstractionTwoNumbers() {
		int result =  this.sub.Substraction(5, 2);
		Assert.assertEquals(3, result);
	}

}
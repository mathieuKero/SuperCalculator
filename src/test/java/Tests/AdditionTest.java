package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllers.Addition;

public class AdditionTest {

	private Addition add;
	
	@Before
	public void setUp() throws Exception {
		add = new Addition();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AdditionTwoNumbers() {
		double result = this.add.calculate(1, 2);
		Assert.assertEquals(3, result, 0.0001);
	}

}

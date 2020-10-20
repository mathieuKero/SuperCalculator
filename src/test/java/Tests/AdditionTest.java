package Tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Controllers.Addition;

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
		int result = this.add.Addition(1, 2);
		Assert.assertEquals(1, result);
	}

}

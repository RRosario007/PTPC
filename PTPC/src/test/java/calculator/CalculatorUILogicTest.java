package calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class CalculatorUILogicTest {
	
	static CalculatorUILogic calcLogic;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calcLogic = new CalculatorUILogic();
	}

	@Test
	public void testUpdateText() {
		String actual = calcLogic.updateText("4", "5+1-2*4");
		
		String expected = "5+1-2*44";
				
		Assert.assertEquals(expected, actual);
		
	}

	@Test
	public void testFixParen() {
		String actual = calcLogic.fixParen("23+(((89-22)-2");
		
		String expected = "23+(((89-22)-2))";
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testSolvEquation() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}
	
	@After
	public void ClearText() {
		calcLogic.clearText();
	}

}

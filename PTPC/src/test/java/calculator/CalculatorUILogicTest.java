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

	/**
	 * Testing with entering multiple values
	 */
	@Test
	public void testUpdateText() {
		String actual = calcLogic.updateText("2", "");
		actual = calcLogic.updateText("+", "2");
		actual = calcLogic.updateText("(", "2+");
		actual = calcLogic.updateText("(", "2+(");
		actual = calcLogic.updateText("(", "2+((");
		actual = calcLogic.updateText("8", "2+(((");
		actual = calcLogic.updateText("-", "2+(((8");
		actual = calcLogic.updateText("2", "2+(((8-");
		actual = calcLogic.updateText(")", "2+(((8-2");
		actual = calcLogic.updateText("*", "2+(((8-2)");
		actual = calcLogic.updateText("3", "2+(((8-2)*");
		
		String expected = "2+(((8-2)*3";
				
		Assert.assertEquals(expected, actual);
		
	}

	/**
	 * Testing to see if after a period an operation and period can't be added from the last string
	 */
	@Test
	public void testUpdateTextPart2() {
		String actual = calcLogic.updateText(".", "2+(((8-2)*3");
		actual = calcLogic.updateText("+", "2+(((8-2)*3");
		actual = calcLogic.updateText("-", "2+(((8-2)*3");
		actual = calcLogic.updateText("/", "2+(((8-2)*3");
		actual = calcLogic.updateText("*", "2+(((8-2)*3");
		actual = calcLogic.updateText(".", "2+(((8-2)*3");
		
		String expected = "2+(((8-2)*3.";
				
		Assert.assertEquals(expected, actual);
		
	}
	
	/**
	 * Here it is testing if any open parenthesis are left, then it adds the closing parenthesis needed
	 */
	@Test
	public void testFixParen() {
		String actual = calcLogic.fixParen("2+(((8-2)*3.");
		
		String expected = "2+(((8-2)*3.))";
		
		Assert.assertEquals(expected, actual);
	}

	/**
	 * Testing when only 1 character is deleted
	 */
	@Test
	public void testDeleteOne() {
		String actual = calcLogic.deleteOne("2+(((8-2)*3.");
		
		String expected = "2+(((8-2)*3";
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * When clearing everything, it just returns a 0
	 */
	@Test
	public void ClearText() {
		String actual = calcLogic.clearText();

		String expected = "0";
		
		Assert.assertEquals(expected, actual);
	}

}

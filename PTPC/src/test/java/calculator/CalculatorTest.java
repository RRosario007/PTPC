package calculator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	static Calculator calc;
	
	/**
	 * Initiating the calculator object
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calc = new Calculator();
	}

	/**
	 * Firstly 4 simple test one for each(addition, subtraction, multiplication, division)
	 * Because comparing double, checking if its within 0.01 of each other
	 */
	@Test
	public void simpleAddition() {
		double actual = calc.DivideNConquer("123 + 456");
		
		double expected = 579;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void simpleSubtraction() {
		double actual = calc.DivideNConquer("123 - 456");
		
		double expected = -333;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void simpleMultiplication() {
		double actual = calc.DivideNConquer("123 * 456");
		
		double expected = 56088;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void simpleDivision() {
		double actual = calc.DivideNConquer("123 / 456");
		
		double expected = 0.2697368421;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	/**
	 * Creating test for the combination of 2 operations(addSub, addMult, addDiv, subMult...)
	 */
	@Test
	public void AddAndSub() {
		double actual = calc.DivideNConquer("123+456-789");
		
		double expected = -210;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void SubAndAdd() {
		double actual = calc.DivideNConquer("123-456+789");
		
		double expected = 456;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void AddAndMult() {
		double actual = calc.DivideNConquer("123+456*789");
		
		double expected = 359907;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void MultAndAdd() {
		double actual = calc.DivideNConquer("123*456+789");
		
		double expected = 56877;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void AddAndDiv() {
		double actual = calc.DivideNConquer("123+456/789");
		
		double expected = 123.577946768;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void DivAndAdd() {
		double actual = calc.DivideNConquer("123/456+789");
		
		double expected = 789.269736842;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void SubAndMult() {
		double actual = calc.DivideNConquer("123-456*789");
		
		double expected = -359661;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void MultAndSub() {
		double actual = calc.DivideNConquer("123*456-789");
		
		double expected = 55299;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void SubAndDiv() {
		double actual = calc.DivideNConquer("123-456/789");
		
		double expected = 122.422053232;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void DivAndSub() {
		double actual = calc.DivideNConquer("123/456-789");
		
		double expected = -788.730263158;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void MultAndDiv() {
		double actual = calc.DivideNConquer("123*456/789");
		
		double expected = 71.0874524715;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void DivAndMult() {
		double actual = calc.DivideNConquer("123/456*789");
		
		double expected = 212.822368421;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	/**
	 * Testing multiple operations
	 */
	@Test
	public void AddSubMulAndDiv() {
		double actual = calc.DivideNConquer("12+34-56*78/90");
		
		double expected = -2.53333333333;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void AddDivSubAndMult() {
		double actual = calc.DivideNConquer("12+34/56-78*90");
		
		double expected = -7007.39285714;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void AddMultDivAndSub() {
		double actual = calc.DivideNConquer("12+34*56/78-90");
		
		double expected = -53.5897435897;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void MultAddSubAndDiv() {
		double actual = calc.DivideNConquer("1234*5678+9876-5432/1596");
		
		double expected = 7016524.59649;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void parenthesis() {
		double actual = calc.DivideNConquer("1234*((5678+(9876-5432))/1596)");
		
		double expected = 7826.15789474;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	/**
	 * Testing when diving by 0
	 */
	@Test
	public void dividebyZero() {
		double actual = calc.DivideNConquer("4568/0");
		
		double expected = Double.POSITIVE_INFINITY;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void zerodivbyZero() {
		double actual = calc.DivideNConquer("0/0");
		
		double expected = Double.NaN;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test 
	public void limitPositive() {
		double actual = calc.DivideNConquer("8.6813E200 * 2.548E120");
		
		double expected = Double.POSITIVE_INFINITY;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void limitNegative() {
		double actual = calc.DivideNConquer("-8.6813E200 * 2.548E120");
		
		double expected = Double.NEGATIVE_INFINITY;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void bigNumber() {
		double actual = calc.DivideNConquer("8.6813E200 * 2.548E106");
		
		double expected = 2.21199524E307;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
	@Test
	public void bigNumberNegative() {
		double actual = calc.DivideNConquer("-8.6813E200 * 2.548E106");
		
		double expected = -2.21199524E307;
		
		Assert.assertEquals(expected, actual, 0.01);
	}
	
}

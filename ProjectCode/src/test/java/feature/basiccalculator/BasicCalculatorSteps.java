package feature.basiccalculator;

import org.junit.Assert;

import io.cucumber.java.en.When;
import leetcode.BasicCalculator;

public class BasicCalculatorSteps {

	@When("I calculate {}, the result should be {int}")
	public void calculateAndCheckResult(String formula, int expectedResult) {
	    int actualResult = new BasicCalculator().calculate(formula);
	    Assert.assertEquals("incorrect result for " + formula, expectedResult, actualResult);
	}

}
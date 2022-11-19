package feature.fizzbuzz;

import java.util.List;

import org.junit.Assert;

import feature.TestWorld;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testproject.FizzBuzz;

public class FizzBuzzSteps {
	
	private TestWorld testWorld;
	
	public FizzBuzzSteps(TestWorld testWorld) {
		this.testWorld = testWorld;
	}
	
	@When("^I fizz buzz for (\\d+)$")
	public void triggerFizzBuzz(int n) throws Throwable {
	    List<String> answer = new FizzBuzz().fizzBuzz(n);
	    testWorld.setFizzBuzzAnswer(answer);	    
	}

	@Then("^the fizz buzz answer should be:$")
	public void checkFizzBuzzAnswer(List<String> expectedAnswer) throws Throwable {
	    List<String> actualAnswer = testWorld.getFizzBuzzAnswer();
	    Assert.assertNotNull("should not be null", actualAnswer);
	    Assert.assertEquals("should have same size", expectedAnswer.size(), actualAnswer.size());
	    for(int i = 0; i < expectedAnswer.size(); i++) {
	    	Assert.assertEquals("should have same value for index " + i, expectedAnswer.get(i), actualAnswer.get(i));
	    }
	}

}

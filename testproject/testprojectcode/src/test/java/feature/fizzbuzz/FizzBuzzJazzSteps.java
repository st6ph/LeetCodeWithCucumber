package feature.fizzbuzz;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import feature.TestWorld;
import feature.fizzbuzz.bean.FizzBuzzResultBean;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testproject.FizzBuzzJazz;

public class FizzBuzzJazzSteps {
	
	private TestWorld testWorld;
	
	public FizzBuzzJazzSteps(TestWorld testWorld) {
		this.testWorld = testWorld;
	}
	
    @DataTableType(replaceWithEmptyString = "[blank]")
    public FizzBuzzResultBean convert(Map<String, String> entry){
      return new FizzBuzzResultBean(
         Integer.parseInt(entry.get("index")),
         entry.get("value")
      );
    }
    
	@When("^I fizz buzz jazz for (\\d+)$")
	public void triggerFizzBuzzJazz(int n) throws Throwable {
	    List<String> answer = new FizzBuzzJazz().fizzBuzzJazz(n);
	    testWorld.setFizzBuzzAnswer(answer);	    
	}

	@Then("^the fizz buzz jazz answer should be:$")
	public void checkFizzBuzzAnswer(List<String> expectedAnswer) throws Throwable {
	    List<String> actualAnswer = testWorld.getFizzBuzzAnswer();
	    Assert.assertNotNull("should not be null", actualAnswer);
	    Assert.assertEquals("should have same size", expectedAnswer.size(), actualAnswer.size());
	    for(int i = 0; i < expectedAnswer.size(); i++) {
	    	Assert.assertEquals("should have same value for index " + i, expectedAnswer.get(i), actualAnswer.get(i));
	    }
	}

	@Then("the fizz buzz jazz answer should have:")
	public void checkFizzBuzzJazzAnswer(List<FizzBuzzResultBean> expectedResults) {
	    List<String> actualAnswer = testWorld.getFizzBuzzAnswer();
	    Assert.assertNotNull("should not be null", actualAnswer);
	    for(FizzBuzzResultBean expectedResult : expectedResults) {
	    	Assert.assertTrue("answer size should be at least " + expectedResult.getIndex(), actualAnswer.size() >= expectedResult.getIndex());
	    	Assert.assertEquals("should have same value for index " + expectedResult.getIndex(), expectedResult.getValue(), actualAnswer.get(expectedResult.getIndex()-1));
	    }
	}
}

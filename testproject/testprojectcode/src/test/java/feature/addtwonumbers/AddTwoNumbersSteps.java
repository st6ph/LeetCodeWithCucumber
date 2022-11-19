package feature.addtwonumbers;

import java.util.List;

import org.junit.Assert;

import feature.TestWorld;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testproject.AddTwoNumbers;
import testproject.bean.ListNode;

public class AddTwoNumbersSteps {
	
	private TestWorld testWorld;
	
	public AddTwoNumbersSteps(TestWorld testWorld) {
		this.testWorld = testWorld;
	}

	@When("I add the following numbers:")
	public void addNumbers(List<String> listNodes) {
		
		
		ListNode additionResult = new AddTwoNumbers().addTwoNumbers(null, null);
		testWorld.setAdditionResult(additionResult);
	}
	
	@Then("the addition result should be:")
	public void checkAdditionResult(List<String> listNode) {
		ListNode additionResult = testWorld.getAdditionResult();
		
		Assert.assertTrue("only one result", listNode != null && listNode.size() == 1);
		
	}
	
	private ListNode convert(String stringRepresentation) {
		return null;
	}

}

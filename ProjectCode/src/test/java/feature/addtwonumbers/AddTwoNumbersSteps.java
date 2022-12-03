package feature.addtwonumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

import feature.TestWorld;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import leetcode.AddTwoNumbers;
import leetcode.bean.ListNode;

public class AddTwoNumbersSteps {
	
	private TestWorld testWorld;
	
	public AddTwoNumbersSteps(TestWorld testWorld) {
		this.testWorld = testWorld;
	}

	@When("I add the following numbers:")
	public void addNumbers(List<String> listNodes) {
		Assert.assertTrue("should only have 2 list nodes", listNodes != null && listNodes.size() ==2);
		
		ListNode l1 = convertToListNode(listNodes.get(0));
		ListNode l2 = convertToListNode(listNodes.get(1));
		
		ListNode additionResult = new AddTwoNumbers().addTwoNumbers(l1, l2);
		testWorld.setAdditionResult(additionResult);
	}
	
	@Then("the addition result should be:")
	public void checkAdditionResult(List<String> listNode) {
		ListNode additionResult = testWorld.getAdditionResult();

		Assert.assertTrue("should only have 1 list node", listNode != null && listNode.size() == 1);
		String expectedStringRep = listNode.get(0);
		String actualStringRep = convertToStringRepresentation(additionResult);
		
		Assert.assertEquals("unexpected addition result", expectedStringRep, actualStringRep);
	}
	
	private ListNode convertToListNode(String stringRepresentation) {
		List<Integer> ints = Arrays.stream(stringRepresentation.split(","))
				.map(String::trim)
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());
		ListNode listNode = new ListNode();
		ListNode currentListNode = listNode;
		boolean first = true;
		for(int intValue : ints) {
			if(first) {
				currentListNode.setVal(intValue);
				first = false;
			}
			else {
				ListNode nextListNode = new ListNode();
				nextListNode.setVal(intValue);
				currentListNode.setNext(nextListNode);
				currentListNode = nextListNode;
			}
		}								
		return listNode;
	}
	
	private String convertToStringRepresentation(ListNode listNode) {
		StringBuilder sb = new StringBuilder();
		if(listNode == null) {
			return "";
		}
		
		ListNode currentListNode = listNode;
		boolean first = true;
		do {
			if(first) {
				first = false;
				sb.append(currentListNode.getVal());
			}
			else {
				currentListNode = currentListNode.getNext();
				sb.append(",");
				sb.append(currentListNode.getVal());
			}
		}
		while(currentListNode.getNext() != null);
		
		return sb.toString();
	}
}

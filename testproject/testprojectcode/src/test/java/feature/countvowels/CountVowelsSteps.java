package feature.countvowels;

import org.junit.Assert;

import io.cucumber.java.en.When;
import testproject.CountVowels;

public class CountVowelsSteps {

	@When("I count of sorted vowel strings for {int}, the count should be {int}")
	public void countVowelStrings(int length, int expectedCount) {
		int actualCount = new CountVowels().countVowelStrings(length);
		
		Assert.assertEquals("Unexpected count for length " + length, expectedCount, actualCount);
	}
}

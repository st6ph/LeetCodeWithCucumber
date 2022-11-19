package testproject;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	
    public List<String> fizzBuzz(int n) {
        List<String> fizzBuzzAnswer = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
        	if(isDivisible(i, 3)) {
        		if(isDivisible(i, 5)) {
        			fizzBuzzAnswer.add("FizzBuzz");
        		}
        		else {
        			fizzBuzzAnswer.add("Fizz");
        		}
        	}
        	else {
        		if(isDivisible(i, 5)) {
            		fizzBuzzAnswer.add("Buzz");
            	}
        		else {
        			fizzBuzzAnswer.add("" + i);
        		}
        	}
        }
        
    	return fizzBuzzAnswer;
    }
    
    private boolean isDivisible(int n, int by) {
    	if(by == 0)
    		return false;
    	return n % by == 0;
    }
}

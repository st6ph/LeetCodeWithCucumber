package testproject;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzJazz {
	
    public List<String> fizzBuzzJazz(int n) {
        List<String> fizzBuzzJazzAnswer = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
        	String str = "";
        	if(isDivisible(i, 3)) {
        		str += "Fizz";
        	}
        	if(isDivisible(i, 5)) {
        		str += "Buzz";
        	}
        	if(isDivisible(i, 7)) {
        		str += "Jazz";
        	}
        	if("".equals(str)) {
        		str = "" + i;
        	}
        	fizzBuzzJazzAnswer.add(str);
        }
        
    	return fizzBuzzJazzAnswer;
    }
    
    private boolean isDivisible(int n, int by) {
    	if(by == 0)
    		return false;
    	return n % by == 0;
    }
}

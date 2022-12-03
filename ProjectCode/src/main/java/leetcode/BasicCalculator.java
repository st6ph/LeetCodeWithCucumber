package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.OptionalInt;

public class BasicCalculator {
	
	private enum Keyword {
		PLUS('+'),
		MINUS('-'),
		START_EXPR('('),
		END_EXPR(')');
		
		char key;
		
		Keyword(char key) {
			this.key = key;
		}
	}
	
	public int calculate(String s) {
		int result = 0;
		int sign = 1;

		Deque<Integer> st = new ArrayDeque<>();

		int currentIndex = 0;
		while (currentIndex < s.length()) {
			char currentChar = s.charAt(currentIndex);
			if (Character.isDigit(currentChar)) {
				int val = 0;
				while (currentIndex < s.length() && Character.isDigit(s.charAt(currentIndex))) {
					val = val * 10 + Character.getNumericValue(s.charAt(currentIndex));
					currentIndex++;
				}
				currentIndex--;
				val = val * sign;
				sign = 1;
				result += val;
			}
			else if (currentChar == '(') {
				st.push(result);
				st.push(sign);
				result = 0;
				sign = 1;
			}
			else if (currentChar == ')') {
				result *= st.pop();
				result += st.pop();
			}
			else if (currentChar == '-') {
				sign *= -1;
			}
			currentIndex++;
		}
		return result;
	}
    
	public int calculate2(String formula) {

		//System.out.println("Formula : " + formula);
		
		// Remove all spaces
		formula = formula.replace(" ", "");
		
		//System.out.println("Formula without space: " + formula);

		int startIndex = -1;
		int endIndex = -1;
		int nbIteration = 1;
		do {
			int[] firstParenthesisExpression = getFirstParenthesisExpression(formula);
			startIndex = firstParenthesisExpression[0];
			endIndex = firstParenthesisExpression[1];
			if(startIndex != -1 && endIndex != -1) {
				String subFormula = formula.substring(startIndex+1, endIndex);
				int subFormulaValue = calculateNoParenthesis(subFormula);
				String subFormulaValueStr;
				if(subFormulaValue < 0) {
					if(startIndex == 0 || formula.charAt(startIndex - 1) == Keyword.PLUS.key) {
						subFormulaValueStr = "0" + subFormulaValue;
					}
					else {
						subFormulaValueStr = "0+" + (-subFormulaValue);
					}
				}
				else {
					subFormulaValueStr = "" + subFormulaValue;
				}
				formula = String.format("%s%s%s", formula.substring(0, startIndex), subFormulaValueStr, formula.substring(endIndex+1));
				//System.out.println(String.format("Formula after iteration %d: %s", nbIteration++, formula));
			}
		}
		while(startIndex != -1 && endIndex != -1);
		
		return calculateNoParenthesis(formula);
	}
	
	private int[] getFirstParenthesisExpression(String formula) {
		int startIndex = -1;
		int endIndex = -1;
		for(int i = 0; i < formula.length(); i++) {
			char currentChar = formula.charAt(i);
			if(currentChar == Keyword.START_EXPR.key) {
				startIndex = i;
			}
			else if(currentChar == Keyword.END_EXPR.key) {
				endIndex = i;
				break;
			}
		}
		return new int[] { startIndex, endIndex };
	}
	
	private int calculateNoParenthesis(String formula) {
		int value = 0;
		String[] plusFormulaArr = formula.split("\\+");
		for(int i = 0; i < plusFormulaArr.length; i++) {
			if(plusFormulaArr[i].startsWith("" + Keyword.MINUS.key)) {
				plusFormulaArr[i] = "0" + plusFormulaArr[i];
			}
			String[] minusFormulaArr = plusFormulaArr[i].split("\\-");
			OptionalInt optValue = Arrays.stream(minusFormulaArr)
					.mapToInt(Integer::parseInt)
					.reduce((x,y)-> x-y);
			if(optValue.isPresent()) {
				value += optValue.getAsInt();
			}
		}
		return value;
	}
}

package leetcode;

import java.util.Arrays;

public class CountVowels {
	private static final int NB_VOWELS = 5;
			
    public int countVowelStrings(int n) {
    	if(n == 0) {
    		return 0;
    	}
    	int[] sortedVowels = new int[] {1, 1, 1, 1, 1};
    	for(int i = 1; i < n; i++) {
    		sortedVowels = getSortedVowelString(sortedVowels);
    	}
    	
        return Arrays.stream(sortedVowels).sum();
    }
    
    public int[] getSortedVowelString(int[] sortedVowels) {
    	int[] nextSortedVowelString = new int[NB_VOWELS];
    	for(int i = 0; i < NB_VOWELS; i ++) {
			if(i > 0) {
				nextSortedVowelString[i] += nextSortedVowelString[i-1];
			}
			nextSortedVowelString[i] += sortedVowels[i];
    	}    	
    	return nextSortedVowelString;
    }    
}

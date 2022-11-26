@tag
Feature: Count Sorted Vowel Strings
  
  https://leetcode.com/problems/count-sorted-vowel-strings/
  
  Example 1:
  Input: n = 1
  Output: 5
  Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
  
  Example 2:
  Input: n = 2
  Output: 15
  Explanation: The 15 sorted strings that consist of vowels only are
  ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
  Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
  
  Example 3:
  Input: n = 33
  Output: 66045
  
  Constraints:  
    1 <= n <= 50 

  Scenario Outline: Count Sorted Vowel Strings for different lengths
    When I count of sorted vowel strings for <length>, the count should be <count>

    Examples: 
      | length | count |
      |      1 |     5 |
      |      2 |    15 |
      |      3 |    35 |
      |     33 | 66045 |

@tag
Feature: Fizz Buzz
  
  For an integer n, return a string array answer (1-indexed) where:  
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.
  
  Input: n = 3
  Output: ["1","2","Fizz"]
  
  Example 2:
  
  Input: n = 5
  Output: ["1","2","Fizz","4","Buzz"]
  
  Example 3:
  
  Input: n = 15
  Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

  Scenario: Compute Fizz Buzz for n=3
    When I fizz buzz for 3
    Then the fizz buzz answer should be:
      |    1 |
      |    2 |
      | Fizz |

  Scenario: Compute Fizz Buzz for n=5
    When I fizz buzz for 5
    Then the fizz buzz answer should be:
      |    1 |
      |    2 |
      | Fizz |
      |    4 |
      | Buzz |

  Scenario: Compute Fizz Buzz for n=15
    When I fizz buzz for 15
    Then the fizz buzz answer should be:
      |        1 |
      |        2 |
      | Fizz     |
      |        4 |
      | Buzz     |
      | Fizz     |
      |        7 |
      |        8 |
      | Fizz     |
      | Buzz     |
      |       11 |
      | Fizz     |
      |       13 |
      |       14 |
      | FizzBuzz |

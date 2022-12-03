@tag
Feature: Fizz Buzz Jazz

  https://leetcode.com/problems/fizz-buzz/
  Variant with 3 prime numbers
  
  For an integer n, return a string array answer (1-indexed) where:  
    answer[i] == "FizzBuzzJazz" if i is divisible by 3 and 5 and 7.
    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "FizzJazz" if i is divisible by 3 and 7.
    answer[i] == "BuzzJazz" if i is divisible by 5 and 7.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == "Jazz" if i is divisible by 7.
    answer[i] == i (as a string) if none of the above conditions are true.
  
  Input: n = 3
  Output: ["1","2","Fizz"]
  
  Example 2:
  
  Input: n = 5
  Output: ["1","2","Fizz","4","Buzz"]
  
  Example 3:
  
  Input: n = 7
  Output: ["1","2","Fizz","4","Buzz", "Fizz", "Jazz"]

  Scenario: Compute Fizz Buzz Jazz for n=3
    When I fizz buzz for 3
    Then the fizz buzz jazz answer should be:
      |    1 |
      |    2 |
      | Fizz |

  Scenario: Compute Fizz Buzz Jazz for n=5
    When I fizz buzz jazz for 5
    Then the fizz buzz jazz answer should be:
      |    1 |
      |    2 |
      | Fizz |
      |    4 |
      | Buzz |

  Scenario: Compute Fizz Buzz Jazz for n=7
    When I fizz buzz jazz for 7
    Then the fizz buzz jazz answer should be:
      |    1 |
      |    2 |
      | Fizz |
      |    4 |
      | Buzz |
      | Fizz |
      | Jazz |

  Scenario: Compute Fizz Buzz Jazz for n=105
    When I fizz buzz jazz for 105
    Then the fizz buzz jazz answer should have:
      | index | value        |
      |     3 | Fizz         |
      |     5 | Buzz         |
      |     7 | Jazz         |
      |     8 |            8 |
      |    15 | FizzBuzz     |
      |    21 | FizzJazz     |
      |    35 | BuzzJazz     |
      |    63 | FizzJazz     |
      |    64 |           64 |
      |    65 | Buzz         |
      |    66 | Fizz         |
      |    70 | BuzzJazz     |
      |    71 |           71 |
      |   105 | FizzBuzzJazz |

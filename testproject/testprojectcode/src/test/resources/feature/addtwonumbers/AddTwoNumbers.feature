@tag
Feature: Add Two Numbers
  
  Example 1:
  Input: l1 = [2,4,3], l2 = [5,6,4]
  Output: [7,0,8]
  Explanation: 342 + 465 = 807.
  
  Example 2:
  Input: l1 = [0], l2 = [0]
  Output: [0]
  
  Example 3:
  Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
  Output: [8,9,9,9,0,0,0,1]
  
  Constraints:  
    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.

  Scenario: Add Two Numbers standard use case
    When I add the following numbers:
      | 2,4,3 |
      | 5,6,4 |
    Then the addition result should be:
      | 7,0,8 |

  Scenario: Add Two Numbers zeroes use case
    When I add the following numbers:
      | 0 |
      | 0 |
    Then the addition result should be:
      | 0 |

  Scenario: Add Two Numbers with size mismatch
    When I add the following numbers:
      | 9,9,9,9,9,9,9 |
      | 9,9,9,9       |
    Then the addition result should be:
      | 8,9,9,9,0,0,0,1 |

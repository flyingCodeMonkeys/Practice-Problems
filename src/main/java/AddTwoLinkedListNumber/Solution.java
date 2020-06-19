package AddTwoLinkedListNumber;

public class Solution {
}

/**

 # // You are given two non-empty linked lists representing two
 # // non-negative integers. The digits are stored in reverse order and
 # //  each of their nodes contain a single digit. Add the two numbers and
 # // return it as a linked list.
 # // You may assume the two numbers do not contain any leading zero,
 # // except the number 0 itself.

 # // Example:

 # // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 # // Output: 7 -> 0 -> 8
 # // Explanation: 342 + 465 = 807.

 class ListNode:
 def __init__(self, val=None):
 self.val = val
 self.next = None

 def generateLinkedlist(arr):
 if len(arr) == 0: return None
 head = ListNode(arr[0])
 cur = head
 for i in range(1, len(arr)):
 cur.next = ListNode(arr[i])
 cur = cur.next

 return head


 l1 = generateLinkedlist([2,4,3])
 l2 = generateLinkedlist([5,6,4])

 def addTwoNumber(l1,l2):
 dummy = head = ListNode(0)
 carry = 0

 while l1 or l2 or carry:
 if l1:
 carry += l1.val
 l1 = l1.next

 if l2:
 carry += l2.val
 l2 = l2.next

 dummy.next = ListNode(carry%10)
 dummy = dummy.next
 carry = carry//10
 return head.next

 print(addTwoNumber(l1,l2))




 # 4+6 = 10//10  = 1
 #  carrier = num//10   go to the linked list = num%10 = 0

**/


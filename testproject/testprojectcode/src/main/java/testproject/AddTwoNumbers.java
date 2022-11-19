package testproject;

import testproject.bean.ListNode;

public class AddTwoNumbers {
		
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {    	
    	ListNode additionResult = new ListNode();
        
    	ListNode currentResultNode = additionResult;
    	ListNode currentListNode1 = l1;
    	ListNode currentListNode2 = l2;
    	
    	int carry = 0;    	
    	boolean first = true;
    	while(currentListNode1 != null || currentListNode2 != null || carry != 0) {
    		int val = carry;
    		if(currentListNode1 != null) {
    			val += currentListNode1.getVal();
    		}
    		if(currentListNode2 != null) {
    			val += currentListNode2.getVal();
    		}
    		if(val > 9) {
    			carry = val / 10;
    			val = val % 10;
    		}
    		else {
    			carry = 0;
    		}
    		if(first) {
    			currentResultNode.setVal(val);
    			first = false;
    		}
    		else {
    			ListNode nextResultNode = new ListNode(val);
    			currentResultNode.setNext(nextResultNode);
    			currentResultNode = nextResultNode;
    		}
			currentListNode1 = getNext(currentListNode1);
			currentListNode2 = getNext(currentListNode2);
    	}
    	
    	return additionResult;
    }
    
    private ListNode getNext(ListNode listNode) {
    	return listNode == null ? null : listNode.getNext();
    }
}

package testproject.bean;

public class ListNode {
	
	private int val;
	private ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public int getVal() {
		return val;
	}

	public ListNode getNext() {
		return next;
	}	
}
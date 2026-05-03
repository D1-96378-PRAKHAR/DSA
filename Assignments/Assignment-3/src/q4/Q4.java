package q4;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode halfReversedHead = reverseList(slow);

		ListNode trav1 = head;
		ListNode trav2 = halfReversedHead;
		boolean result = true;
		while (trav2 != null) {
			if (trav1.val != trav2.val)
				result = false;
			trav1 = trav1.next;
			trav2 = trav2.next;
		}
		return result;
	}
}

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

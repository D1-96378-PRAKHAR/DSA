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
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode lNode = temp;
        ListNode rNode = temp;

        for (int i = 1; i < left; i++) {
            lNode = lNode.next;
        }

        for (int i = 1; i <= right; i++) {
            rNode = rNode.next;
        }

        ListNode rNodeNext = rNode.next;
        
        rNode.next = null;

        lNode.next = reverseList(lNode.next);

        while (lNode.next != null) {
            lNode = lNode.next;
        }

        lNode.next = rNodeNext;

        return temp.next;
    }
}

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package q3;

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
        /*
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode headNext = head.next;
        while(headNext != null){
            head.next = prev;
            prev = head;
            head = headNext;
            headNext = headNext.next;
        }
        head.next = prev;
        return head;
        */
    }
}

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

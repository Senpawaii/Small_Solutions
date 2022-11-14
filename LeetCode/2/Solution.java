/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode resultList = new ListNode();
        ListNode head = resultList;
        while(l1 != null || l2 != null || carry != 0) {
            int l1_val = l1==null ? 0: l1.val;
            int l2_val = l2==null ? 0: l2.val;
            int new_val = l1_val + l2_val + carry;
            carry = 0;
            if(new_val > 9) {
                carry = 1;
                new_val = new_val % 10;
            }

            resultList.next = new ListNode(new_val);
            resultList = resultList.next;
            
            if(l1 != null) {
                l1 = l1.next;
            } 
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }
}

/*
* Time complexity: Let n be the size of l1, and m be the size of l2: O(max(n,m))
*
* Space complexity: Let n be the size of l1, and m be the size of l2: O(max(n,m) + 1)
*/
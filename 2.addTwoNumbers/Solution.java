/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null;
        ListNode current = null;
        int overflow = 0;
        while (l1 != null || l2 != null) {
            int val = (null==l1?0:l1.val) 
                + (null==l2?0:l2.val) + overflow;
            overflow = val / 10;
            ListNode tmp = new ListNode(val % 10);
            if (null == root) {
                root = current = tmp;
            } else {
                current.next = tmp;
                current = tmp;
            }
            if (null != l1) {
                l1 = l1.next;
            }
            if (null != l2) {
                l2 = l2.next;
            }
        }
        if (overflow > 0 && null != current) {
            current.next = new ListNode(overflow);
        }
        return root;
    }
}
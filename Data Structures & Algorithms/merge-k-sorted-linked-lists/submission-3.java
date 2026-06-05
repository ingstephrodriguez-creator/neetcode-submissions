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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeLists(lists[0], lists[1]);
        } else if (lists.length >= 3) {
            ListNode merged = mergeLists(lists[0], lists[1]);
            return mergeLists(merged, mergeKLists(Arrays.copyOfRange(lists, 2, lists.length)));
        }
        return null;
    }

    public ListNode mergeLists(ListNode one, ListNode two) {
        if (one != null && two == null) {
            return one;
        } else if (two != null && one == null) {
            return two;
        } else if (one == null && two == null) {
            return null;
        }
        ListNode head = new ListNode();
        if (one.val <= two.val) {
            head = one;
            one = one.next;
        } else {
            head = two;
            two = two.next;
        }
        ListNode cur = head;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next;
        }

        if (one != null) {
            cur.next = one;

        } else if (two != null) {
            cur.next = two;
        }
        return head;
    }
}

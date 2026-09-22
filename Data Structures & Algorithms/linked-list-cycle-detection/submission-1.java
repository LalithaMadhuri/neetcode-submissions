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

 /*

 slow and fast pointer

 slow pointer moves by 1 => slow = slow.next
 fast pointer moves by 2 => fast = fast.next.next;

 if(slow == fast) => cycle found! 

 TC: O(N)
 SC: O(1)


 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;

        ListNode slow = head, fast = head;

        while(slow != null && fast != null && slow.next != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return false;
        
    }
}

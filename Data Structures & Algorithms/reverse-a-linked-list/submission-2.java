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

 0 -> 1 -> 2 -> 3 -> null

 3-> 2 -> 1 -> 0 -> null

 Maintain prev and curr pointer 

 prev = null ; curr = 0
 null 0 -> 1 -> 2 -> 3 -> null

 0 -> null 1 -> 2 -> 3

 curr.next = prev
 prev = curr 
 curr = next

 prev = 0, curr = 1

 1->0->null 2 -> 3

 prev = 1, curr = 2

 2 -> 1 -> 0 -> null 3

 prev = 2, curr = 3

 3 -> 2 -> 1 -> 0 -> null

 prev = 3, curr = null

 

 TC: O(N)
 SC: O(1)





 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode prev = null, curr = head;


        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
        
    }
}

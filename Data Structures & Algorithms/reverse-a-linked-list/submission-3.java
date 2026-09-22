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

 0 -> 1 -> 2 -> 3 -> Null

 3 -> 2 -> 1 -> 0 -> Null

 prev = null
 curr 

 Step - 1: null <- 0  1 -> 2 -> 3 prev = null, curr = 0

 curr.next = prev
 prev = 0
 curr = 1

 Step - 2: 

 prev = 0, curr = 1

 null <- 0 <- 1 2 -> 3 

 curr.next = prev 
 prev = 1 
 curr = 2

 Step -3: 
 null <- 0 <- 1 <- 2 3
 prev = 2;
 curr = 3

 Step -4: 
 null <- 0 <- 1 <- 2 <- 3
 prev = 3
 curr = null

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

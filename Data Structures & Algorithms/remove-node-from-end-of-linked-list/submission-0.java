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
 1 -> 2 -> 3 -> 4 -> 5

 n = 1

 1 -> 2 -> 3 -> 4

 prev = 4 curr = 5

 prev.next = curr.next => 1 -> 2 -> 3 -> 4 => return head;

 n = 5

 2 -> 3 -> 4 -> 5

 curr = curr.next => return curr




 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr = head;
        int size = 0, i = 1;

        while(ptr != null){
            size++;
            ptr = ptr.next;

        }

        
        ListNode prev = null;
        ptr = head;

        while(ptr != null){
            if(size - n + 1 == i){ // ptr is the node to delete
                if(prev == null){ // delete first node
                    ptr = ptr.next;
                    return ptr;
                }
                else{
                    prev.next = ptr.next;
                    return head;
                }

            }

            i++;
            prev = ptr;
            ptr = ptr.next;

        }
        return head;

    }
}

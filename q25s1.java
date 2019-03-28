// it takes super long to adjust those pointers. The idea is simple, travel once, go back and reverse sublist. 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1){
            return head;
        }
        int count = 0;
        int t_count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head;
        ListNode movehead = head;
        ListNode preend = head;
        while (movehead!= null){
            if (count == k - 1){
                ListNode movenext = movehead.next;
                count = 0;
                ListNode newh = reverse(prev, k);
                if (t_count == 0){
                    dummy.next = newh;
                    t_count++;
                }
                else{
                    preend.next = newh;
                    preend = prev;
                }   
                prev = movenext;
                movehead = movenext;
            } 
            else{
                count++;
                movehead = movehead.next;
            }
        }
        return dummy.next;
    }
    // reverse the list, and connect reversed list to original next node, return the head of reversed list
    public ListNode reverse(ListNode head, int k){
        ListNode dummy = head;
        ListNode prev = null;
        ListNode cnext = null;
        while (k > 0){
            cnext = head.next;
            head.next = prev;
            prev = head;
            head = cnext;
            k--;
        }
        dummy.next = head;
        return prev;        
    }
}

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
        if (head == null || k <= 0){
            return head;
        }
        int count = 0;
        ListNode dummy = new ListNode(-1);
        ListNode prev = new ListNode(-1);
        ListNode next = null;
        while (head!= null){
            if (count == k - 1){
                count = 0;
                ListNode cnext = head.next;
                List<ListNode> result = reverse(ListNode head, int k);
                prev.next = result.get(1);
                prev = result.get(0);
                result.get(0).next = cnext;
            } 
            else{
                count++;
                head = head.next;
            }
        }
    }
    // reverse the list, return: end of reverselist, head of reverselist 
    public List<ListNode> reverse(ListNode head, int k){
        ListNode prev = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (k > 0){
            ListNode cnext = head.next;
            head.next = prev;
            prev = head;
            head = cnext;
            k--;
        }
        List<ListNode> r = new ArrayList<ListNode>;
        r.add(dummy);
        r.add(prev);
        return r;        
    }
}

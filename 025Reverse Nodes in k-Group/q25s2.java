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
        if (head == null || k <= 1){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 用prev 理清顺序，同dummy记录head
        // prev/dummy->1->2->3->4/last
        ListNode prev = dummy;
        // reverse看接下来的数字是否足够reverse, reverse numbers between prev and last.
        // prev should be used to record previous end
        while(prev != null){
            prev = reverse(prev, k);            
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode prev, int k){
        ListNode last = prev;
        while (k + 1> 0){
            if (last == null){
                return null;
            }
            k--;
            last = last.next;
        }
        // 变化其实一直只和1 （head）和下一个要加入的数字有关, HEAD这里一直不变，永远指1.
        ListNode head = prev.next;
        ListNode end = prev.next.next;
        while(end != last){
            ListNode next = end.next;
            head.next = next;
            end.next = prev.next;
            prev.next = end;
            end = next;
        }
        return head;
    }
}

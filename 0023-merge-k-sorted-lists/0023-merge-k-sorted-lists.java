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
        List<Integer> l = new ArrayList<>();
        for(ListNode i : lists) {
            while(i != null) {
                l.add(i.val);
                i = i.next;
            }
        }
        if(l.size() == 0) {
            return null;
        }
        Collections.sort(l);
        ListNode head = new ListNode(l.get(0));
        ListNode curr = head;
        for(int i = 1; i < l.size(); i++) {
            curr.next = new ListNode(l.get(i));
            curr = curr.next;
        }
        return head;
    }
}
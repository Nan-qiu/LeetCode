package leetcode.linkList;

public class DeleteTheMiddleNodeOfLinkedList {
    public ListNode deleteMiddle(ListNode head){
        ListNode ct = head;
        int count = 1;
        while (ct.next != null) {
            count++;
            ct = ct.next;
        }
        if (count == 1) return null;
        ListNode del = head;
        for(int i = 1; i < count / 2; i++) del = del.next; // i从1开始，相当于(count/2)-1
        del.next = del.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(){
        }

        ListNode(int val){
            this.val = val;
        }

        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}

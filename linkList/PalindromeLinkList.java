package leetcode.linkList;

public class PalindromeLinkList { // 判断链表是否为回文链表

    public static boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) return true;
        ListNode f = head;
        ListNode cur = head;

        while (f.next != null && f.next.next != null) { //获得中点
            f = f.next.next;
            cur = cur.next;
        }
        ListNode pre = null;
        ListNode tmp;
        while (cur != null) { // 逆序   cur为当前节点 pre为cur的前一个节点
            tmp = cur.next; // tmp为临时变量 存放cur的下一个节点，保证节点不断
            cur.next = pre; // 把cur的箭头指向它的前一个节点，就是逆序了
            pre = cur; // 然后把pre指针移到当前节点上
            cur = tmp; //把当前节点移到它的下一个节点上
        }
        while (head != null && pre != null) {
            if (head.val != pre.val){
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
        //   老朱的代码
//        if (head == null || head.next == null) return true;
//        ListNode slow = head;
//        ListNode fast = head;
//
//        while (fast.next != null && fast.next.next != null) { //获得中点
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        // reverse
//        ListNode pre = slow;
//        fast = pre.next;
//        while (fast != null) {
//            ListNode next = fast.next;
//            fast.next = pre;
//            pre = fast;
//            fast = next;
//        }
//        fast = pre;
//        slow.next = null;
//        slow = head;
//
//        //
//        while (slow != null) {
//            if (slow.val != fast.val) return false;
//            slow = slow.next;
//            fast = fast.next;
//        }
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

package leetcode.linkList;

public class AddTwoNumbers {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3,null)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4,null)));
        ListNode res = addTwoNumbers(l1,l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        int plus = 0;
        ListNode res = null;
        ListNode cur = null;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + plus;
            if (cur == null){
                res = cur = new ListNode(sum % 10);
            } else{
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            plus = sum > 9 ? 1 : 0;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (plus > 0) cur.next = new ListNode(1);
        return res;
    }

    public static ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    static class ListNode {
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

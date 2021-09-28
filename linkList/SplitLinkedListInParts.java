package leetcode.linkList;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head,int k){
        if (head == null) return null;
        ListNode[] list = new ListNode[k];// 创建数组
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length += 1;
            cur = cur.next;
        }
        int n = length % k;
        cur = head;
        for(int i = 0; i < k; i++){
            list[i] = cur;
            for(int j = 0; j < length / k; j++){//指针来到平均的位置
                cur = cur == null ? null : cur.next;
            }
        }

        //指针来到正确的位置
        int tmp = 1;
        while (tmp <= n) {// while循环一次，tmp+1，直到tmp==n
            for(int i = tmp; i < k; i++){// 第一次是靠右k-1段的指针移动，第二次是k-2段，以此类推
                list[i] = list[i] == null ? null : list[i].next;
            }
            tmp++;
        }

        // 断尾巴
        cur = head;
        for(int i = 1; i < k; i++){
            while (cur.next != null) {
                if (cur.next == list[i]){
                    cur.next = null;
                    cur = list[i];
                    break;
                }
                cur = cur.next;
            }
        }

        return list;
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

    public static void main(String[] args){
        ListNode root = new ListNode(1,new ListNode(2,new ListNode(3)));
        ListNode[] nodes = new SplitLinkedListInParts().splitListToParts(root,5);
        for(ListNode node : nodes){
            if (node == null) System.out.println((Object) null);
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }
}


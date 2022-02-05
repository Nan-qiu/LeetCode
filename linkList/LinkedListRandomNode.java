package leetcode.linkList;

import java.util.Random;

public class LinkedListRandomNode {

    static int count = 0;
    static ListNode cHead;

    public LinkedListRandomNode(ListNode head){
        ListNode tmp = head;
        cHead = head;
        int ct=0;
        while (tmp != null) {
            ct++;
            tmp = tmp.next;
        }
        count=ct;
        System.out.println(count);
    }

    public int getRandom(){
        ListNode cur = cHead;
        if (count == 1) return cur.val;
        int i1 = new Random().nextInt(count);

        for(int i = 0; i < i1; i++){
            cur = cur.next;
        }
        return cur.val;
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



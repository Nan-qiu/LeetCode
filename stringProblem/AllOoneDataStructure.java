package leetcode.stringProblem;

import java.util.*;

public class AllOoneDataStructure {
    public static void main(String[] args){
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");
        allOne.dec("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        System.out.println(allOne.getMaxKey());
    }


    static class AllOne {

        static class Node {
            Node pre;
            Node next;
            String key;
            int val;

            Node(String key,int val){
                this.pre = null;
                this.next = null;
                this.key = key;
                this.val = val;
            }
        }

        Node head, tail;
        HashMap<String, Node> map;

        public AllOne(){
            this.head = new Node(null,-1);
            this.tail = new Node(null,100000);
            head.next = tail;
            tail.pre = head;
            this.map = new HashMap<>();
        }

        public void inc(String key){
            //map存在key
            if (map.containsKey(key)){
                Node newNode = map.get(key);
                newNode.val += 1;
                //交换位置
                while (newNode.val > newNode.next.val) {
                    Node node = newNode.next;
                    newNode.next = node.next;
                    node.next = newNode;
                    node.pre = newNode.pre;
                    newNode.pre = node;
                    newNode.next.pre = newNode;
                    node.pre.next = node;
                }
            } else{
                //不存在
                Node newNode = new Node(key,1);
                Node next = head.next;
                next.pre = newNode;
                newNode.next = next;
                head.next = newNode;
                newNode.pre = head;
                map.put(key,newNode);
            }
        }

        public void dec(String key){
            Node curNode = map.get(key);
            if (curNode.val == 1){
                map.remove(key);
                curNode.next.pre = curNode.pre;
                curNode.pre.next = curNode.next;
            } else{
                curNode.val--;
                while (curNode.val < curNode.pre.val) {
                    Node node = curNode.pre;
                    node.next=curNode.next;
                    curNode.next=node;
                    curNode.pre=node.pre;
                    node.pre=curNode;
                    node.next.pre=node;
                    curNode.pre.next=curNode;
                }
            }

        }

        public String getMaxKey(){
            return tail.pre == head ? "" : tail.pre.key;
        }

        public String getMinKey(){
            return head.next == tail ? "" : head.next.key;
        }
    }
}

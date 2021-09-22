package leetcode;

public class CopyListWithRandomPointer {


    public static Node copyRandomList(Node head){
        if (head == null) return null;
        Node next;
        Node cur = head;
        // 1->1`->2->2`->3->3`->null
        while (cur != null) { // 构建串联好的链表
            next = cur.next; // 先把原链表cur指针的下一个给next
            cur.next = new Node(cur.val);// 然后把cur的下一个节点赋复制的节点 n`
            cur.next.next = next;// 把next指向cur的下下个节点
            cur = next; // cur移到next位置
        }

        Node curCopy = null;
        cur = head;
        while (cur != null) { // 完成拷贝链表的random属性
            next = cur.next.next;// next指针指向原链表的下一个位置
            curCopy = cur.next;// curCopy指针指向复制链表的头
            curCopy.random = cur.random == null ? null : cur.random.next; // 复制节点的random指针就为当前cur节点的random指针的下一个
            cur = next;// cur移到next位置
        }
        cur = head;
        Node res = head.next;
        // 1->1`->2->2`->3->3`->null
        while (cur != null) { // 把拷贝链表分离出来
            next = cur.next.next;// next指针指向第二个原节点
            curCopy = cur.next; // curCopy指针指向第一个拷贝节点
            cur.next = next;// 把第一个原节点和第二个原节点相连
            curCopy.next = next == null ? null : next.next;// 判断当前next指针是否为空，为空则返回空，不为空就把curCopy的下一个与next的下一个相连
            cur = next; // 移动
        }
        return res;
    }


    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

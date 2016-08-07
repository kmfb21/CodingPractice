import java.util.*;
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
    void out() {
        System.out.println(this.label);
    }
};
public class Solution {
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode headcp = head;
        while(head!=null) {
            RandomListNode cp = new RandomListNode(head.label);
            cp.next = head.next;
            head.next = cp;
            head = cp.next;
        }
        head = headcp;
        while(headcp!=null) {
            if(headcp.random!=null)
            headcp.next.random = headcp.random.next;
            headcp = headcp.next.next;
        }
        RandomListNode ans = head.next;
        while(head!=null) {
            RandomListNode tmpcp = head;
            head = head.next.next;
            if(head!=null) tmpcp.next.next = head.next;
            else tmpcp.next.next = null;
            tmpcp.next = head;
        }
        return ans;
    }
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        a.next = b;
        a.random = c;
        b.next = c;
        b.random = a;
        c.random = b;
        RandomListNode d = copyRandomList(a);
        while(d!=null) {
            d.out();
            d.random.out();
            d = d.next;
        }
        System.out.println("Origin one:");
        while(a!=null) {
            a.out();
            a.random.out();
            a = a.next;
        }
        return;
    }
}

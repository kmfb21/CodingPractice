/*
Return reference to rotated linked list 
 class Node {
   int value;
 Node next;

  Node(int value) {
   this.value = value;

  }
}
This is method only submission.
You only need to complete the method.
*/
class gfg
{
Node rotate(Node head,int k)
 {
//add code here
    if(head==null||head.next==null||k==0) return head;
    Node first = head;
    for(int i=0;i<k-1;i++) head=head.next;
    Node end = head;
    if(end.next==null) return first;
    while(head.next!=null) head=head.next;
    Node result = end.next;
    end.next = null;
    head.next = first;
    return result;
 }
}

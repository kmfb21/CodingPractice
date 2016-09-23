import java.util.*;

class Node {
	int val;
	Node left;
	Node right;
	Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
class Tree {
	Node root;
	Tree(Node root) {
		this.root = root;
	}

	//build tree with preorder and inorder
	Tree(int[] preorder, int[] inorder) {
		this.pre = preorder;
		this.in = inorder;
		this.root = build(0,preorder.length-1,0,inorder.length-1); 
	}
	int[] pre;
	int[] in;
	Node build(int p1,int p2,int i1,int i2) {
		if(p1==p2) return new Node(pre[p1]);
		Node root = new Node(pre[p1]);
		int rootIndex = index(pre[p1],i1,i2);
		if(rootIndex!=i1)
			root.left = build(p1+1,rootIndex-i1+p1,i1,rootIndex-1);
		if(rootIndex!=i2)
			root.right = build(rootIndex-i1+p1+1,p2,rootIndex+1,i2);
		return root;
	}
	int index(int val,int start,int end) {
		for(int i=start;i<=end;i++)
			if(in[i]==val) return i;
		return -1;
	}

	//O(n) Space Traversal
	void preorder() {
		if(this.root==null) return;
		System.out.print(this.root.val);
		new Tree(this.root.left).preorder();
		new Tree(this.root.right).preorder();
	}
	void inorder() {
		if(this.root==null) return;
		new Tree(this.root.left).inorder();
		System.out.print(this.root.val);
		new Tree(this.root.right).inorder();
	}
	void postorder() {
		if(this.root==null) return;
		new Tree(this.root.left).postorder();
		new Tree(this.root.right).postorder();
		System.out.print(this.root.val);
	}

	//O(1) Space Traversal
	void preorder2() {
		Node root = this.root;
		while(root!=null) {
			if(root.left==null) {
				System.out.print(root.val);
				root = root.right;
			} else {
				Node head = root.left;
				while(head.right!=null && head.right!=root) head = head.right;
				if(head.right==null) {
					head.right = root;
					System.out.print(root.val);
					root = root.left;
				} else {
					head.right = null;
					root = root.right;
				}
			}
		}
	}
	void inorder2() {
		Node root = this.root;
		while(root!=null) {
			if(root.left==null) {
				System.out.print(root.val);
				root = root.right;
			} else {
				Node head = root.left;
				while(head.right!=null && head.right!=root) head = head.right;
				if(head.right==null) {
					head.right = root;
					root = root.left;
				} else {
					head.right = null;
					System.out.print(root.val);
					root = root.right;
				}
			}
		}
	}
	void postorder2() {
		Node root = new Node(0);
		root.left = this.root;
		while(root!=null) {
			if(root.left==null) root = root.right;
			else {
				Node head = root.left;
				while(head.right!=null && head.right!=root) head = head.right;
				if(head.right==null) {
					head.right = root;
					root = root.left;
				} else {
					head.right = null;
					reversePrint(root.left);
					root = root.right;
				}
			}
		}
	}
	void reversePrint(Node root) {
		int n = 0;
		for(Node head=root;head!=null;head=head.right) n++;
		for(int i=n;i>0;i--) {
			Node head = root;
			for(int j=1;j<i;j++) head = head.right;
			System.out.print(head.val);
		}
	}
}
class Traversal {
	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.right = new Node(9);
		root.left.right.left = new Node(3);
		root.left.right.right = new Node(5);
		root.right.right.left = new Node(8);
		Tree test = new Tree(root);

		int[] preorder = new int[]{6,2,1,4,3,5,7,9,8};
		int[] inorder = new int[]{1,2,3,4,5,6,7,8,9};
		test = new Tree(preorder,inorder);

		System.out.println("Pre");
		test.preorder2();
		System.out.println("\nIn");
		test.inorder2();
		System.out.println("\nPost");
		test.postorder2();
		System.out.println();
	}
}

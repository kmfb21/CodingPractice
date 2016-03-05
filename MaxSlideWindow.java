import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int[] a=new int[n],b=new int[n-k+1];
		    for(int i=0;i<n;i++) a[i]=sc.nextInt();
		    Deque<Integer> q = new LinkedList<Integer>();
		    for(int i=0;i<k;i++) {
		        while(!q.isEmpty() && a[q.getLast()]<a[i])
		            q.removeLast();
		        q.addLast(i);
		    }
		    for(int i=k;i<n;i++) {
		        b[i-k]=a[q.getFirst()];
		        while(!q.isEmpty() && a[q.getLast()]<a[i])
		            q.removeLast();
		        q.addLast(i);
		        while(!q.isEmpty() && q.getFirst()<=i-k)
		            q.removeFirst();
		    }
		    b[n-k]=a[q.getFirst()];
		    for(int i=0;i<n-k;i++)
		        System.out.print(b[i]+" ");
		    System.out.println(b[n-k]);
		}
	}
}

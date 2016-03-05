import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int n = sc.nextInt();
		    int[] a=new int[n],left=new int[n],right=new int[n];
		    for(int i=0;i<n;i++) {
		        a[i]=sc.nextInt();
		        left[i] = i>0 ? Math.max(left[i-1],a[i-1]) : 0;
		    }
		    for(int i=n-1;i>=0;i--)
		        right[i] = i<n-1 ? Math.max(right[i+1],a[i+1]) : 0;
		    int ans=0;
		    for(int i=0;i<n;i++) {
		        int water=Math.min(right[i],left[i]);
		        if(water>a[i]) ans+=water-a[i];
		    }
		    System.out.println(ans);
		}
	}
}

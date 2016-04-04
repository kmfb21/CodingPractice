import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    long product = 1;
		    for(int i=0;i<n;i++) {
		        a[i] = sc.nextInt();
		        product *= a[i];
		    }
		    for(int i=0;i<n-1;i++)
		        System.out.print((product / a[i])+" ");
		    System.out.println(product/a[n-1]);
		}
	}
}

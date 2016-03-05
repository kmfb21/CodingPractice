import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    //if it requires change array to rotate one
    //use swap
    //or just print it out
    public static void swap(Object a,Object b) {
        Object tmp=a;
        a=b;
        b=tmp;
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int n = sc.nextInt();
		    int[][] a = new int[n][n];
		    for(int i=0;i<n;i++)
		        for(int j=0;j<n;j++)
		            a[i][j]=sc.nextInt();
		    for(int i=0;i<n;i++)
		        for(int j=0;j<n;j++) {
		            System.out.print(a[n-1-j][i]);
		            if(i!=n-1||j!=n-1) System.out.print(" ");
		        }
		    System.out.println();
		}
	}
}

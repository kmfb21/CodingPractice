import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    int x = sc.nextInt();
		    long[][] nx = new long[n+1][x+1];
		    for(int i=1;i<=m && i<=x;i++) nx[1][i]=1;
		    for(int times=2;times<=n;times++)
		      for(int sum=1;sum<=x;sum++)
		        for(int i=1;i<=m && i<sum;i++)
		          nx[times][sum] += nx[times-1][sum-i];
		    System.out.println(nx[n][x]);
		}
	}
}

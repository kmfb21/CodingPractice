import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turn = sc.nextInt();
		for(int t=0;t<turn;t++) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int ans = 0;
		    int[][] dp = new int[n+1][m+1];
		    for(int i=1;i<n+1;i++) {
		        for(int j=1;j<m+1;j++) {
		            if(sc.nextInt()==1) {
dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
		                ans = Math.max(ans,dp[i][j]);
		            }
		        }
		    }
		    System.out.println(ans);
		}
	}
}

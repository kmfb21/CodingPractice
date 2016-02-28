import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++){
		    int n = sc.nextInt();
		    int[][] m = new int[n][n];
		    int[][] dp = new int[n][n];
		    int ans = 0;
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            m[i][j] = sc.nextInt();
		            if(i==n-1){
		                dp[i][j] = m[i][j];
		            }
		        }
		    }
		    for(int i=n-2;i>=0;i--){
		        for(int j=0;j<n;j++){
		            int temp=0;
		            if(j>0){
		                temp = temp>dp[i+1][j-1] ? temp:dp[i+1][j-1];
		            }
		            if(j<n-1){
		                temp = temp>dp[i+1][j+1] ? temp:dp[i+1][j+1];
		            }
		            temp = temp>dp[i+1][j] ? temp:dp[i+1][j];
		            dp[i][j] = m[i][j] + temp;
		            if(i==0){
		                ans = ans>dp[0][j] ? ans:dp[0][j];
		            }
		        }
		    }
		    System.out.println(ans);
		}
	}
}

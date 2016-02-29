import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int[] a;
    //Recursion failed for time limit
    //public static int ans(int index,int sum) {
    //if(index==a.length) return sum;
    //return Math.min(Math.abs(ans(index+1,sum+a[index])),Math.abs(ans(index+1,sum-a[index])));
    //}
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int turns = sc.nextInt();
        for(int t=0;t<turns;t++) {
            int n = sc.nextInt();
            a = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++) {
                a[i] = sc.nextInt();
                //dp
                sum += a[i];
            }
            boolean[][] dp = new boolean[n+1][sum+1];
            for(int i=0;i<=n;i++) dp[i][0]=true;
            for(int i=1;i<=sum;i++) dp[0][i]=false;
            for(int i=1;i<=n;i++)
                for(int j=1;j<=sum;j++) {
                    dp[i][j]=dp[i-1][j];
                    if(a[i-1]<=j) dp[i][j] |= dp[i-1][j-a[i-1]];
                }
            for(int i=sum/2;i>=0;i--) {
                if(dp[n][i]) {
                    System.out.println(sum-i*2);
                    break;
                }
            }
            //System.out.print(ans(0,0));
        }
    }
}
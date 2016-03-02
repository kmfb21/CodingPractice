import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int[][] dp;
    public static String s1,s2;
    //recursion way(time limit exceeded)
    public static void cut(int i,int j,int steps) {
        if(dp[i][j]==0) dp[i][j] = steps;
        else dp[i][j] = Math.min(dp[i][j],steps);
        if(i==0 && j!=0) {cut(0,j-1,steps+1); return;}
        if(j==0 && i!=0) {cut(i-1,0,steps+1); return;}
        if(i==0 && j==0) return;
        if(s1.charAt(i-1)==s2.charAt(j-1)) cut(i-1,j-1,steps);
        else {
            cut(i-1,j,steps+1);
            cut(i,j-1,steps+1);
            cut(i-1,j-1,steps+1);
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int turn = sc.nextInt();
        for(int t=0;t<turn;t++) {
            int l1 = sc.nextInt();
            int l2 = sc.nextInt();
            s1 = sc.next();
            s2 = sc.next();
            dp = new int[l1+1][l2+1];
            //dp correct way
            for(int i=0;i<=l1;i++) {
                for(int j=0;j<=l2;j++) {
                    if(i==0) dp[0][j] = j;
                    else if(j==0) dp[i][0] = i;
                    else if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    else dp[i][j] = 1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                }
            }
            //cut(l1,l2,0);
            //debug
            //for(int i=0;i<l1+1;i++) {
            //for(int j=0;j<l2+1;j++) System.out.print(dp[i][j]+" ");
            //System.out.println();
            //}
            System.out.println(dp[l1][l2]);
        }
    }
}
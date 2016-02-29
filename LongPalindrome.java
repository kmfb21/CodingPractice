import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int turn = sc.nextInt();
        for(int t=0;t<turn;t++) {
            String s = sc.next();
            char[] c = s.toCharArray();
            int n = c.length;
            boolean[][] dp = new boolean[n][n];
            int max = 0,lb = 0;
            for(int i=0;i<n;i++) {
                dp[i][i] = true;
                if(i<n-1 && c[i]==c[i+1]) {
                    dp[i][i+1]=true;
                    max = 1;
                    lb = i;
                }
            }
            for(int len=2;len<=n;len++)
                for(int i=0;i<n-len;i++){
                    int j = i + len;
                    if(dp[i+1][j-1] && c[i]==c[j]) {
                        dp[i][j]=true;
                        lb=i;
                        max=len;
                    }
                }
            //print the last one
            //System.out.println(s.substring(lb,max+lb+1));
            //for debug
//            for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) if(dp[i][j]) System.out.print("1 "); else System.out.print("0 ");
//            System.out.println();
//            }
//            System.out.println(max);
            //print the first one
            for(int i=0;i<n-max;i++)
                if(dp[i][max+i]) {
                    System.out.println(s.substring(i,max+i+1));
                    break;
                }
        }
    }
}
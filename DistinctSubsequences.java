public class Solution {
    static int[][] dp,dps;
    static char[] ss,tt;
    static int solve(int si,int ti) {
        if(dps[si][ti]==1) return dp[si][ti];
        dps[si][ti] = 1;
        if(ti==tt.length) {
            dp[si][ti] = 1;
            return 1;
        }
        char tc = tt[ti];
        for(int i=si;i<ss.length;i++) {
            if(tc==ss[i])
                dp[si][ti] += solve(i+1,ti+1);
        }
        return dp[si][ti];
    }
    public int numDistinct(String s, String t) {
        ss = s.toCharArray();
        tt = t.toCharArray();
        dp = new int[s.length()+1][t.length()+1];
        dps = new int[s.length()+1][t.length()+1];
        return solve(0,0);
    }
}

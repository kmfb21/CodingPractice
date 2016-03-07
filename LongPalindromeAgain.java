import java.util.*;
public class LongPalindromeAgain {
    public static void main(String[] args) {
	String s = args[0];
	char[] a = s.toCharArray();
	int n = a.length,maxlen=1,start=0;
	boolean[][] dp = new boolean[n][n];
	for(int i=0;i<n;i++) dp[i][i]=true;
	for(int len=2;len<=n;len++) {
	    for(int i=0;i<n-len+1;i++) {
		int j = i+len-1;
		if(a[i]==a[j] && (dp[i+1][j-1] || i+1==j)) {
		    dp[i][j]=true;
		    //if we want the first Longest Palindrome, uncomment below,or we will get last one
		    // if(len>maxlen) 
		    start=i;
		    maxlen=len;
		}
	    }
	}
	System.out.println(start+" "+maxlen);
	System.out.println(s.substring(start,start+maxlen));
    }
}

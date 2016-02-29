import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turn = sc.nextInt();
		for(int t=0;t<turn;t++) {
		    int n = sc.nextInt();
		    int[] a = new int[n+1];
		    int[] mark = new int[101];
		    int ans = 0;
		    for(int i=1;i<n+1;i++) {
		        a[i] = sc.nextInt();
		        int min=1001;
		        for(int j=0;j<=a[i];j++) if(mark[j]!=0) min = Math.min(mark[j],min);
                mark[a[i]] = min==1001 ? i : min;
                ans = Math.max(ans,i-mark[a[i]]);
		    }
		    System.out.println(ans);
		}
	}
}

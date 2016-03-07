import java.util.*;
public class PossibleAS {
    public static void main(String[] args) {
	int[] a = {-1,1,3,3,3,2,1,0,-1,1,3};
	int n = a.length;
	if(n<=2) {System.out.println(0);return;}
	int diff,lastdiff=Integer.MIN_VALUE,lasts=1,ans=0;
	for(int i=1;i<n;i++) {
	    diff=a[i]-a[i-1];
	    if(diff==lastdiff) ans+=lasts++;
	    else lasts=1;
	    lastdiff=diff;
	}
	System.out.println(ans);
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int length(int a) {
        int ans = 0;
        while(a>0) {
            a /= 10;
            ans++;
        }
        return ans;
    }
    static int power(int di, int mi) {
        if(mi==0) return 1;
        else return di * power(di,mi-1);
    }
    static void quick_sort(int[][] s, int l, int r) {
        if (l < r) {
            int i = l, j = r;
            int[] x = s[l];
            while (i < j) {
                while(i < j && s[j][0] < x[0]) j--;
                if(i < j) s[i++] = s[j];
                while(i < j && s[i][0] >= x[0]) i++;
                if(i < j) s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1);
            quick_sort(s, i + 1, r);
        }
        return;
    }
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++){
		    int n = sc.nextInt();
		    int[][] a = new int[n][2];
		    for(int i=0;i<n;i++){
		        a[i][0] = sc.nextInt();
		        a[i][1] = Math.max(1,length(a[i][0]));
		        if(a[i][1]==3) {
		            a[i][0] = a[i][0] / 100 + a[i][0] * 10;
		        }
		        if(a[i][1]==2) {
		            a[i][0] = a[i][0] + a[i][0] * 100;
		        }
		        if(a[i][1]==1) {
		            a[i][0] = a[i][0] + a[i][0] * 10 + a[i][0] * 100 + a[i][0] * 1000;
		        }
		    }
		    quick_sort(a,0,n-1);
		    for(int[] i:a){
		        System.out.print(""+i[0] / power(10,4-i[1]));
		    }
		    System.out.println();
		}
	}
}
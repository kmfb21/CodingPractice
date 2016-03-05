import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int min = 1000,max = 0;
    public static int[] a;
    public static void refresh(int i,int j) {
        while(i<j) {
            min = Math.min(a[i],min);
            max = Math.max(a[i],max);
            i++;
        }
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int n = sc.nextInt();
		    a = new int[n];
		    int[][][] val = new int[n][n][2];
            for(int i=0;i<n;i++) a[i] = sc.nextInt();
            int result = n;
            for(int i=0;i<n;i++) {
                min = 1000;max = 0;
                refresh(i,n);
                val[i][0][0] = min;
                val[i][0][1] = max;
                if(min*2>max) result = Math.min(result,i);
            }
            for(int i=0;i<n;i++)
            for(int j=1;j<n-i;j++)
                if(a[n-j]==val[i][j-1][0] || a[n-j]==val[i][j-1][1]) {
                    min = 1000;max = 0;
                    refresh(i,n-j);
                    val[i][j][0] = min;
                    val[i][j][1] = max;
                    if(min*2>max) result = Math.min(result,i+j);
                } else {
                    val[i][j][0] = val[i][j-1][0];
                    val[i][j][1] = val[i][j-1][1];
                }
            //for(int i=0;i<n;i++) {
            //for(int j=0;j<n-i;j++)
            //System.out.print(""+val[i][j][0]+","+val[i][j][1]+"  ");
            //System.out.println();
            //}
            System.out.println(result);
		}
	}
}

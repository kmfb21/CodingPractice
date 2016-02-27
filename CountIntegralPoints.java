import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][]=new int[n][4];
		for(int i=0;i<n;i++){
		    for(int j=0;j<4;j++){
		        a[i][j]=sc.nextInt();
		    }
		    int r = a[i][3]-a[i][1];
		    int c = a[i][2]-a[i][0];
		    if(r<0){
		        r *= -1;
		    }
		    if(c<0){
		        c *= -1;
		    }
		    if(r<c){
		        int temp = r;
		        r=c;
		        c=temp;
		    }
		    int count=0;
		    for(int k=1;k<c;k++){
		        if(k*r%c==0){
		            count++;
		        }
		    }
		    System.out.println(count);
		}
		
	}
}

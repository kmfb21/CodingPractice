import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    int result = a ^ b;
		    int count = 0;
		    while(result!=0) {
		        if(result%2==1) count++;
		        result = result >>1;
		    }
		    System.out.println(count);
		}
	}
}

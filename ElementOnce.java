import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		short turns = sc.nextShort();
		for(short t=0;t<turns;t++) {
		    short n = sc.nextShort();
		    int result = 0;
		    for(short i=0;i<n;i++) result^=sc.nextInt();
		    System.out.println(result);
		}
	}
}

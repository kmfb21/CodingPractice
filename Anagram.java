import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		sc.nextLine();
		for(int t=0;t<turns;t++) {
		    String s1=sc.nextLine();
		    String s2=sc.nextLine();
		    if(s1.length()!=s2.length()) {
		        System.out.println("NO");
		        continue;
		    }
		    char[] c1 = s1.toCharArray();
		    char[] c2 = s2.toCharArray();
		    Arrays.sort(c1);
		    Arrays.sort(c2);
		    boolean flag = true;
		    for(int i=0;i<c1.length;i++)
		        if(c1[i]!=c2[i]) flag = false;
		    if(flag) System.out.println("YES");
		    else System.out.println("NO");
		}
	}
}

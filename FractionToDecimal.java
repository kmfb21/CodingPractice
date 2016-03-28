import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turns = sc.nextInt();
		for(int t=0;t<turns;t++) {
		    int up = sc.nextInt();
		    int down = sc.nextInt();
		    //save decimal part and remainder part
		    LinkedList<Integer> decimal = new LinkedList<Integer>();
		    LinkedList<Integer> remainder = new LinkedList<Integer>();
		    //integer part of answer
		    String digits = up/down + "";
		    //loop "begin" mark
		    int begin = -1;
		    while(up%down!=0) {
		        up%=down;
		        remainder.add(up);
		        up *= 10;
		        decimal.add(up/down);
		        if(remainder.contains(up%down)) {
		            begin = remainder.indexOf(up%down);
		            break;
		        }
		    }
		    //if it has decimal
		    if(decimal.size()>0) digits = digits + ".";
            for(int i=0;decimal.size()>0;i++) {
                if(begin==i) digits = digits+"(";
                digits = digits + decimal.remove();
            }
            if(begin!=-1) digits = digits + ")";
		    System.out.println(digits);
		}
	}
}

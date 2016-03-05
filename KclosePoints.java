import java.util.*;
import java.lang.*;
import java.io.*;

class Point {
	public int x;
	public int y;
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void output() {
		System.out.println("Point("+this.x+","+this.y+")");
	}
}
class Solution {
	public static void outKpoints(Point[] p, int k) {

		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				return (p2.x*p2.x+p2.y*p2.y)-(p1.x*p1.x+p1.y*p1.y);
			}
		});
		for(int i=0;i<p.length;i++) {
			pq.offer(p[i]);
			if(i>=k) pq.poll();
		}
		while(!pq.isEmpty()) pq.poll().output();
	}
	public static void main(String[] arg){
		Point[] p = {new Point(2,2),new Point(3,4),new Point(4,5),new Point(1,0),new Point(3,2),new Point(4,3)};
		System.out.println("Points:");
		for(Point x:p) x.output();
		System.out.println("Visualize:");
		System.out.println("* 0 1 2 3 4 5");
		for(int i=0;i<6;i++) {
			System.out.print(i+" ");
			for(int j=0;j<6;j++) {
				boolean flag=false;
				for(Point z:p)
				  if(z.x==i && z.y==j) flag=true;
				if(flag) System.out.print("0 ");
				else System.out.print("- ");
			}
			System.out.println();
		}
		int k = 3;
		System.out.println("The most close "+k+" points to (0,0):");
		outKpoints(p,k);
	}
}


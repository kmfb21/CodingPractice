import java.util.*;
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
class Solution {
    public List<Interval> merge(List<Interval> intervals) {//using idea of Bubble Sort
        List<Interval> ans = new LinkedList<Interval>();
        Interval last = null;
        boolean conti = false;
        for(Interval i:intervals) {
            if(last!=null) {
                if(last.end<i.start) {//last's and current's order correct
                    ans.add(last);
                    last = i;
                } else if(i.end<last.start) {//order reversed, swap them!
                    ans.add(i);
                    conti = true;
                } else {//intervals overlapped, combine them!
                    int[] tmp = {i.start,i.end,last.start,last.end};
                    Arrays.sort(tmp);
                    last = new Interval(tmp[0],tmp[3]);
                    conti = true;
                }
            } else {
                last = i;
            }
        }
        if(last!=null)
	    ans.add(last);
        if(conti) return merge(ans);//if merge happened, run again
        return ans;
    }
}
public class MergeIntervals {
    public static void main(String[] args) {
	Solution s = new Solution();
	Interval t1 = new Interval(1,3);
	LinkedList<Interval> an = new LinkedList<Interval>();
	an.add(t1);
	an.add(new Interval(2,6));
	an.add(new Interval(8,10));
	an.add(new Interval(15,18));
	an.add(new Interval(16,19));
	List<Interval> ans = s.merge(an);
	for(Interval i:ans) {
	    System.out.println(i.start+" "+i.end);
	}
    }
}

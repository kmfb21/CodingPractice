import java.util.*;

class Request {
    public int atime;
    public int dtime;
    public Request(int a,int d) {
	this.atime=a;
	this.dtime=d;
    }
}

class ShortJobFirst {
    public static double CalWaitingTime(int[] requestTimes, int[] durations) {
	int n =requestTimes.length;
	if(requestTimes==null||durations==null||requestTimes.length!=durations.length) return 0;
	PriorityQueue<Request> qu = new PriorityQueue<Request>(n,new Comparator<Request>() {
		public int compare(Request a,Request b) {
		    if(a.dtime==b.dtime) return a.atime-b.atime;
		    return a.dtime-b.dtime;
		}
	    });
	int i=0,ctime=0,wtime=0;
	while(!qu.isEmpty()||i<n) {
	    if(qu.isEmpty()) {
		qu.offer(new Request(requestTimes[i],durations[i]));
		ctime=requestTimes[i++];
	    } else {
		Request now = qu.poll();
		wtime+=ctime-now.atime;
		ctime+=now.dtime;
		for(;i<n && requestTimes[i]<=ctime;i++)
		    qu.offer(new Request(requestTimes[i],durations[i]));
	    }
	}
	return (double)wtime/n;
    }
    public static void main(String[] args) {
	int[] rt = {0,2,4,5,6};
	int[] d = {7,4,1,4,1};
	double ans = CalWaitingTime(rt,d);
	System.out.println(ans);
    }
}
import java.util.*;

class Request {
    public int atime;
    public int etime;
    public Request(int a,int e) {
	this.atime=a;
	this.etime=e;
    }
}

public class Test {
    public static float Solution(int[] arr,int[] exe,int q) {
	if(arr==null||exe==null||arr.length!=exe.length) return 0;
	int n = exe.length;
	int wait=0,time=0,i=0;
	Queue<Request> qu = new LinkedList<Request>();
	while(!qu.isEmpty()||i<n) {
	    if(!qu.isEmpty()) {
		Request current = qu.poll();
		wait+=time-current.atime;
		time+=Math.min(q,current.etime);
		for(;i<n && arr[i]<=time;i++)
		    qu.offer(new Request(arr[i],exe[i]));
		if(current.etime>q)
		    qu.offer(new Request(time,current.etime-q));
	    } else {
		qu.offer(new Request(arr[i],exe[i]));
		time = arr[i++];
	    }
	}
	return (float)wait/n;
    }

    public static void main(String[] args) {
	int[] arr = {0,2,4,5,6}; 
	int[] bur = {7,4,1,4,1}; 
	int q = 3;
	float ans = Solution(arr, bur, q);
	System.out.println(ans);
    }
}
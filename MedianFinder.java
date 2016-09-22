import java.util.*;
public class MedianFinder {
    
    // Adds a number into the data structure.
    public static void addNum(int num) {
        if(small.size()==0) {
            small.add(num);
            return;
        }
        if(big.size()==0||num<=big.get(0)) {
            smalladd(num);
            if(small.size()-2==big.size()) {
                swap(small,0,small.size()-1);
                int tmp = small.remove(small.size()-1);
                Mheapify(0);
                bigadd(tmp);
            }
        } else {
            bigadd(num);
            if(small.size()!=big.size()) {
                swap(big,0,big.size()-1);
                int tmp = big.remove(big.size()-1);
                Sheapify(0);
                smalladd(tmp);
            }
        }
    }
    
    // Returns the median of current data stream
    public static double findMedian() {
        //if(small.size()==31&&big.size()==31&&small.get(0)==31&&big.get(0)==35) return 32*1.0;
        if(small.size()==big.size()) return (small.get(0) + big.get(0))/2.0;
        else return small.get(0);
    }
    
    static List<Integer> small = new ArrayList<>();
    static List<Integer> big = new ArrayList<>();
    static void Mheapify(int i) {
        int max = i;
        if(i*2+1<small.size() && small.get(i*2+1) > small.get(max)) max = i*2+1;
        if(i*2+2<small.size() && small.get(i*2+2) > small.get(max)) max = i*2+2;
        if(max!=i) {
            swap(small,i,max);
            Mheapify(max);
        }
    }
    static void Sheapify(int i) {
        int min = i;
        if(i*2+1<big.size() && big.get(i*2+1) < big.get(min)) min = i*2+1;
        if(i*2+2<big.size() && big.get(i*2+2) < big.get(min)) min = i*2+2;
        if(min!=i) {
            swap(big,i,min);
            Sheapify(min);
        }
    }
    static void swap(List<Integer> a,int i,int j) {
        int tmp = a.get(i);
        a.set(i,a.get(j));
        a.set(j,tmp);
    }
    static void smalladd(int a) {
        small.add(a);
        int i = small.size()/2-1;
        while(i>=0) {
            Mheapify(i);
            i = (i+1)/2-1;
        }
    }
    static void bigadd(int a) {
        big.add(a);
        int i = big.size()/2-1;
        while(i>=0) {
            Sheapify(i);
            i = (i+1)/2-1;
        }
    }
    public static void main(String[] args) {
        addNum(78);System.out.println(findMedian());
        addNum(14);System.out.println(findMedian());
        addNum(50);System.out.println(findMedian());
        addNum(20);System.out.println(findMedian());
        addNum(13);System.out.println(findMedian());
        addNum(9);System.out.println(findMedian());
        addNum(25);System.out.println(findMedian());
        addNum(8);System.out.println(findMedian());
        addNum(13);System.out.println(findMedian());
        addNum(37);System.out.println(findMedian());
        addNum(29);System.out.println(findMedian());
        addNum(33);System.out.println(findMedian());
        addNum(55);System.out.println(findMedian());
        addNum(52);System.out.println(findMedian());
        addNum(6);System.out.println(findMedian());
        addNum(17);System.out.println(findMedian());
        addNum(65);System.out.println(findMedian());
        addNum(23);System.out.println(findMedian());
        addNum(74);System.out.println(findMedian());
        addNum(43);System.out.println(findMedian());
        addNum(5);System.out.println(findMedian());
        addNum(29);System.out.println(findMedian());
        addNum(29);System.out.println(findMedian());
        addNum(72);System.out.println(findMedian());
        addNum(7);System.out.println(findMedian());
        addNum(13);System.out.println(findMedian());
        addNum(56);System.out.println(findMedian());
        addNum(21);System.out.println(findMedian());
        addNum(31);System.out.println(findMedian());
        addNum(66);System.out.println(findMedian());
        addNum(69);System.out.println(findMedian());
        addNum(69);System.out.println(findMedian());
        addNum(74);System.out.println(findMedian());
        addNum(12);System.out.println(findMedian());
        addNum(77);System.out.println(findMedian());
        addNum(23);System.out.println(findMedian());
        addNum(10);System.out.println(findMedian());
        addNum(6);System.out.println(findMedian());
        addNum(27);System.out.println(findMedian());
        addNum(63);System.out.println(findMedian());
        addNum(77);System.out.println(findMedian());
        addNum(21);System.out.println(findMedian());
        addNum(40);System.out.println(findMedian());
        addNum(10);System.out.println(findMedian());
        addNum(19);System.out.println(findMedian());
        addNum(59);System.out.println(findMedian());
        addNum(35);System.out.println(findMedian());
        addNum(40);System.out.println(findMedian());
        addNum(44);System.out.println(findMedian());
        addNum(4);System.out.println(findMedian());
        addNum(15);System.out.println(findMedian());
        addNum(29);System.out.println(findMedian());
        addNum(63);System.out.println(findMedian());
        addNum(27);System.out.println(findMedian());
        addNum(46);System.out.println(findMedian());
        addNum(56);System.out.println(findMedian());
        addNum(0);System.out.println(findMedian());
        addNum(60);System.out.println(findMedian());
        addNum(72);System.out.println(findMedian());
        addNum(35);System.out.println(findMedian());
        addNum(54);System.out.println(findMedian());
        System.out.println(small.get(0)+"<-"+small.size()+"##"+big.get(0)+"<-"+big.size());
        addNum(50);System.out.println(findMedian());
        System.out.println(small.get(0)+"<-"+small.size()+"##"+big.get(0)+"<-"+big.size());
        addNum(14);System.out.println(findMedian());
        addNum(29);System.out.println(findMedian());
        addNum(62);System.out.println(findMedian());
        addNum(24);System.out.println(findMedian());
        addNum(18);System.out.println(findMedian());
        addNum(79);System.out.println(findMedian());
        addNum(16);System.out.println(findMedian());
        addNum(19);System.out.println(findMedian());
        addNum(8);System.out.println(findMedian());
        addNum(77);System.out.println(findMedian());
        addNum(10);System.out.println(findMedian());
        addNum(21);System.out.println(findMedian());
        addNum(66);System.out.println(findMedian());
        addNum(42);System.out.println(findMedian());
        addNum(76);System.out.println(findMedian());
        addNum(14);System.out.println(findMedian());
        addNum(58);System.out.println(findMedian());
        addNum(20);System.out.println(findMedian());
        addNum(0);System.out.println(findMedian());
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
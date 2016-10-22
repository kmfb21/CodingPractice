import java.util.*;
class Sort {
	public static void main(String[] args) {

		int[] a = new int[]{4,2,8,5,7,1,3,6,9};
		System.out.println("Original Array:");
		print(a);

		quicksort(a);
		System.out.println("Quick Sort:");
		print(a);

		a = new int[]{4,2,8,5,7,1,3,6,9};
		mergesort(a);
		System.out.println("Merge Sort:");
		print(a);

		a = new int[]{4,2,8,5,7,1,3,6,9};
		heapsort(a);
		System.out.println("Heap Sort:");
		print(a);

	}
	static void print(int[] a) {
		for(int i=0;i<a.length-1;i++) System.out.print(a[i]+" ");
		System.out.println(a[a.length-1]);
	}
	static void swap(int[] a,int i,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	static void quicksort(int[] a) {
		quick(a,0,a.length-1);
	}
	static void quick(int[] a,int s,int e) {
		if(s>=e) return;
		int i = s,j = e;
		int pivot = a[e];
		while(i<j) {
			while(a[i] < pivot && i<=j && i<e) i++;
			while(a[j] >= pivot && i<=j && j>s) j--;
			if(i<j) swap(a,i,j);
		}
		if(i<e) {
			swap(a,i,e);
			quick(a,i+1,e);
		}
		if(j>s) quick(a,s,j);
	}

	static void mergesort(int[] a) {
		if(a.length<=1) return;
		int n1 = a.length/2;
		int n2 = a.length - n1;
		int[] a1 = new int[n1];
		int[] a2 = new int[n2];
		int count = 0;
		for(int i:a) {
			if(count<n1) a1[count] = i;
			else a2[count-n1] = i;
			count++;
		}
		mergesort(a1);
		mergesort(a2);
		merge(a,a1,a2);
	}
	static void merge(int[] a,int[] a1,int[] a2) {
		int i1=0,i2=0;
		while(i1+i2<a.length) {
			if(i1==a1.length) {
				a[i1+i2] = a2[i2];
				i2++;
			} else if(i2==a2.length) {
				a[i1+i2] = a1[i1];
				i1++;
			} else if(a1[i1]<a2[i2]) {
				a[i1+i2] = a1[i1];
				i1++;
			} else {
				a[i1+i2] = a2[i2];
				i2++;
			}
		}
	}

	static void heapsort(int[] a) {
		for(int i=a.length/2;i>=0;i--) heapify(a,i,a.length);
		//print(a);
		for(int i=a.length-1;i>0;i--) {
			swap(a,0,i);
			heapify(a,0,i);
		}
	}
	static void heapify(int[] a,int i,int size) {
		int max = i;
		if(i*2+1<size && a[i*2+1] > a[max]) max = i*2+1;
		if(i*2+2<size && a[i*2+2] > a[max]) max = i*2+2;
		if(max!=i) {
			swap(a,i,max);
			heapify(a,max,size);
		}
	}
}

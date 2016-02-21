package sort;
/**
 * A class designed for sorting, using top-down mergesort.
 * @author Chaoyi Kuang
 *
 */
public class Merge {
	
	private static Comparable aux[];
	
	public static boolean isSorted(Comparable[] a){
		for (int i=1;i<a.length;i++)
			if (lessComparable(a[i],a[i-1])) return false;
		return true;
	}
	
	private static boolean lessComparable(Comparable a, Comparable b){
		return a.compareTo(b) < 0;	
	}
	/**
	 * merge sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		aux = new Comparable [n];
		sort(x,0,n-1);
		
	}
	private static void sort(Comparable[] a, int lo, int hi){
		if (hi<= lo) return;
		int mid = lo + (hi-lo)/2;
		sort (a,lo,mid);
		sort (a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	private static void merge(Comparable[] a,int lo,int mid,int hi){
		int i = lo;
		int j = mid+1;
		for (int k = lo;k<=hi;k++){
			aux[k] = a[k];
		}
		for (int k =lo;k<=hi;k++){
			if (i>mid){
				a[k] = aux[j];
				j++;
			}
			else if (j>hi){
				a[k]=aux[i];
				i++;
			}
			else if (aux[j].compareTo(aux[i])<0){
				a[k]=aux[j];
				j++;
			}
			else{
				a[k] = aux[i++];
			}
		}
	}
}

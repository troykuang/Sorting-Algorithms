package sort;
/**
 * A class uses top-down mergesort to sort an array containing times of jobs.
 * @author Chaoyi Kuang
 *
 */
public class Merge {
	
	private static Comparable aux[];
	
	/**
	 * Check the resulting array is already sorted
	 * @param a - the input array containing times of jobs that need to be examined whether it's sorted or not
	 * @return true if the array is sorted; and false it's not sorted.
	 */
	public static boolean isSorted(Comparable[] a){
		for (int i=1;i<a.length;i++)
			if (lessComparable(a[i],a[i-1])) return false;
		return true;
	}
	
	/**
	 * Check the resulting array is already sorted
	 * @param a - the input array containing times of jobs that need to be examined whether it's sorted or not
	 * @return true if the array is sorted; and false it's not sorted.
	 */
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
	
	/**
	 * Recursively divide the current array to halves and sort them then merge then togeter
	 * @param a - the input array containing times of jobs that need to be sorted.
	 * @param lo - the starting index of the current array
	 * @param hi - the ending index of the current array
	 */
	private static void sort(Comparable[] a, int lo, int hi){
		if (hi<= lo) return;
		int mid = lo + (hi-lo)/2;
		// Recursively divide the whole array to half and sort the halves 
		sort (a,lo,mid);
		sort (a,mid+1,hi);
		// And merge all the halves
		merge(a,lo,mid,hi);
	}
	
	/**
	 * merge sorted two halves together by picking the smaller element at the head of two arrays
	 * @param a - the input array containing times of jobs that need to be sorted.
	 * @param lo - the starting index of the current array
	 * @param mid - the middle index of the current array
	 * @param hi - the ending index of the current array
	 */
	private static void merge(Comparable[] a,int lo,int mid,int hi){
		int i = lo;
		int j = mid+1;
		
		for (int k = lo;k<=hi;k++){
			aux[k] = a[k];
		}
		for (int k =lo;k<=hi;k++){
			// all the elements in the first array has already been placed
			if (i>mid){
				a[k] = aux[j];
				j++;
			}
			else if (j>hi){
				// all the elements in the auxiliary array has already been placed
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

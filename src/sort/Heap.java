package sort;
/**
 * A class uses Heap sort to sort an array containing times of jobs
 * @author Chaoyi Kuang
 *
 */
public class Heap {
	/**
	 * Heap sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
		// Since Heap Sort requires the arrays start from 1 to make it
		// Another array is created to accommodate that
		Comparable[] heapX = new Comparable[n+1]; 
		heapX[0] = null;
		// Copy the whole array from x[1]
		for(int i =0;i<n;i++){
			heapX[i+1] = x[i];
		}
		for (int k =n/2;k>=1;k--){ // Construct heap tree
			sink(heapX,k,n); 
		}
		while (n>1) {
			exch (heapX,1,n--); // Find max
			sink(heapX,1,n); // Reheapifying 
		}
		n = x.length;
		// Copy back the resulting array
		for (int i =1;i<n+1;i++){
			x[i-1]=heapX[i];
		}
		
	}

	/**
	 * Top-down reheapify
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param k - the index of the element needs to be sinked.
	 * @param n - the size of the input array.
	 */
	private static void sink(Comparable[] x, int k, int n){
		// exchanging the node with the larger of its two children. This switch may 
		// cause a violation at the child; we fix that violation in the same way, and 
		// so forth, moving down the heap until we reach a node with both children 
		// smaller (or equal), or the bottom. 
		while (2*k<=n){
			int j = 2*k ;
			if ((j<n) && (x[j].compareTo(x[j+1])<0))
				j++;
			if (!(x[k].compareTo(x[j])<0))
				break;
			exch(x,k,j);
			k = j;
		}	
	}
	
	/**
	 * Exchange two elements in a Comparable array
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param i - the index of the first element to be exchanged.
	 * @param j - the index of the second element to be exchanged.
	 */
	private static void exch(Comparable[] x, int i, int j){
		Comparable temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
	
	/**
	 * Check the resulting array is already sorted
	 * @param a - the input array containing times of jobs that need to be examined whether it's sorted or not
	 * @return true if the array is sorted; and false it's not sorted.
	 */
	public static boolean isSorted(Comparable[] a){
		for (int i=1;i<a.length;i++)
			if (a[i].compareTo(a[i-1])<0) return false;
		return true;
	}
	
	
	
}


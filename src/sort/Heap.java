package sort;
/**
 * A class designed for sorting, using Heap Sort.
 * @author Chaoyi Kuang
 *
 */
public class Heap {
	/**
	 * heap sort using Comparable
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
	private static void sink(Comparable[] x, int k, int n){
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
	private static void exch(Comparable[] x, int i, int j){
		Comparable temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
	public static boolean isSorted(Comparable[] a){
		for (int i=1;i<a.length;i++)
			if (a[i].compareTo(a[i-1])<0) return false;
		return true;
	}
	
	
	
}


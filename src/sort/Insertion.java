package sort;
/**
 * A class uses 3 kinds of Insertion sorts (regular Insertion sort, Comparable Insertion sort and Binary Insertion Sort) 
 * to sort an array containing times of jobs.
 * @author Chaoyi Kuang
 *
 */
public class Insertion {
	
	/**
	 * Exchange two elements in a Comparable array
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param i - the index of the first element to be exchanged.
	 * @param j - the index of the second element to be exchanged.
	 */
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * Compare two Jobs and return true if the first one is less than the second one.
	 * @param a - the first Job
	 * @param b - the second Job
	 * @return true if a is less than b; and false if a is equal or greater than b
	 */
	private static boolean lessJob(Job a, Job b){
		if (a.getTime() < b.getTime()) return true;
		else return false;
		
	}
	
	/**
	 * Compare two Comparables and return true if the first one is less than the second one.
	 * @param a - the first comparable
	 * @param b - the second comparable
	 * @return true if a is less than b; and false if a is equal or greater than b
	 */
	private static boolean lessComparable(Comparable a, Comparable b){
		return a.compareTo(b) < 0;	
	}
	
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
	 * regular insertion sort
	 * @param x - the input array containing processing times of jobs that need to be sorted.
	 */
	public static void sortInsert ( Job[] x ) {
		int N = x.length;
		for (int i = 0; i<N;i++){
			// If the current element is smaller than the one previous to it exchange them
			for (int j = i ;j>0 && lessJob(x[j],x[j-1]);j--){
				exch(x,j,j-1);
			}
		}
		
	}
	
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
		for (int i = 0; i<n;i++){
			for (int j = i ;j>0 && lessComparable(x[j],x[j-1]);j--){
				exch(x,j,j-1);
			}
		}
	}
	
	/**
	 * optimized insertion sort
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary (Comparable[] x, int n ) {
		for (int i=0;i<n;++i){       
            Comparable temp = x[i];
            int head=0;        
            int end=i;
            // Find the location to insert the current element
            while (head<end){
                int middle=(end+head)/2;
                if (!(temp.compareTo(x[middle])<0))
                    head=middle+1;
                else
                    end=middle;
            }
            for (int j=i;j>head;--j){
                exch(x,j-1,j);
            }
        }
    }
}

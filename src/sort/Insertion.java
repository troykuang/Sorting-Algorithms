package sort;

public class Insertion {
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static boolean lessJob(Job a, Job b){
		if (a.getTime() < b.getTime()) return true;
		else return false;
		
	}
	private static boolean lessComparable(Comparable a, Comparable b){
		return a.compareTo(b) < 0;	
	}
	
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
		
/*		int target;
		for (int i=1;i<n;i++){
			Comparable[] b = new Comparable[i+1];
			for (int j=0;j<i+1;j++){
				b[j] = x[j];
				
			}
			target = findKey(b,i);
			for (int j = i ;j>target;j--){
			exch(x,j,j-1);
		}
			
		}
	}
	
	public static int findKey(Comparable[] x, int i){
		
		int head = 0;
		int end = i-1;
		
		while(true){
			if (x[i].compareTo(x[0])<0)
				return 0;
			if (x[i].compareTo(x[end])>0)
				return i;
			int mid = (head+end)/2;
			if (head >= end){
				if(x[mid].compareTo(x[i])<0)
					return (mid+1);
				else
					return mid;
			}
			if ((x[mid].compareTo(x[i])>0) && (x[mid-1].compareTo(x[i])<0))
				{return mid;}
			else if ((x[mid].compareTo(x[i])<0) && (x[mid+1].compareTo(x[i])>0))
				{return (mid +1);}
			else{
				if (x[mid].compareTo(x[i])>0)
					end = mid-1;
				else
					head = mid +1;
			}
		}*/	
	

}

import java.util.Vector;

public class binaryInsertion {
	public static int findKey(Comparable[] x, int i){
		
		int head = 0;
		int end = i-1;
		
		while(true){
			if (x[i].compareTo(x[0])<0)
				return 0;
			int mid = (head+end)/2;
			if (head >= end){
				if(x[mid].compareTo(x[i])<0)
					return (mid+1);
				else
					return mid;
			}
			if ((x[mid].compareTo(x[i])>0) && (x[mid-1].compareTo(x[i])<0))
				return mid;
			else if ((x[mid].compareTo(x[i])<0) && (x[mid+1].compareTo(x[i])>0))
				return (mid +1);
			else{
				if (x[mid].compareTo(x[i])>0)
					end = mid-1;
				else
					head = mid +1;
			}
		}
	}


	public static void sortBinary (Comparable[] x, int n ) {
		int target;
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
	private static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;

	}

	public static void main(String[] args) {
		Integer[] a = new Integer[8];
		a[0]=117;
		a[1]=855;
		a[2]=257;
		a[3]=327;
		a[4]=638;
		a[5]=515;
		a[6]=847;
		a[7]=890;
		sortBinary(a,8);
		System.out.println(a);

	}

}

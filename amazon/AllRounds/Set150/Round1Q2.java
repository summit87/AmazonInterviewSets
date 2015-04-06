package amazon.AllRounds.Set150;

public class Round1Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//int[] a = {5, 10, 20, 15};// incresing and then decresing order
			//int[] a = {10, 20, 30, 40, 50}; //Strictly incresing order
			int[] a = {100, 80, 60, 50, 20}; //Strictly decresing order
			int peak = new Round1Q2().peakByUsingBinarySearch(a, 0,a.length,a.length-1);
			System.out.println(a[peak]);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private int getPeak(int[] a){
		try{
			for(int  i =0;i< a.length ; i++){
				if(i-1 >=0 && a[i-1] < a[i] && i == a.length-1){
					return i;
				}else if(a[i] > a[i+1] && i== 0){
					return i;
				}else if(i-1 >= 0 && i+1 <= a.length-1 && a[i] > a[i-1] && a[i] > a[i+1]){
					return i;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
		return -1;
	}
	
	private int peakByUsingBinarySearch(int[] a,int l,int r,int n){
		try{
			int mid = (l+r)/2;
			if(mid - 1 >= 0 && mid + 1 <a.length && a[mid] > a[mid+1] && a[mid] > a[mid-1]){
				return mid;
			}
			if(a[0] > a[1]){
				return 0;
			}
			if(a[n - 1] < a[n]){
				return n;
			}
			if(mid - 1 > l && a[mid] < a[mid-1]){
				return peakByUsingBinarySearch(a, l,mid-1, n);
			}
			if(mid + 1 < r && a[mid] > a[mid+1]){
				return peakByUsingBinarySearch(a, mid + 1, r, n);
			}
			return -1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
}

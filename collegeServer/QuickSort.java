package collegeServer;
import java.lang.*;
import java.util.Timer;
public class QuickSort {
	
	public static void quicksort_array(final int[]A,final int low,final int hi)
	{
	   if (low < hi){
	      final int pivot = partition(A, low, hi);
	      quicksort_array(A, low, pivot);
	      quicksort_array(A, pivot+1, hi);
	      
	      
	     
	   }
	   
	}
	public static void mtquick_sort(final int[]A,final int low, final int hi)
	{
		if(low<hi){
			final int p=partition(A,low,hi);
			Thread t=new Thread(){
				public void run(){mtquick_sort(A,low,p);}
			};
			t.start();
			mtquick_sort(A,p+1,hi);
			try
			{
				t.join();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static int partition(int[]A, int low, int hi){
		int x = A[low];
		int tempHi = hi+1;
		int tempLo = low-1;
		while(true)
		{
			
			do tempHi--;
			while(A[tempHi]>x);
			{
			
			}
			do tempLo++;
			while(A[tempLo]<x);
			if(tempLo<tempHi)
			{
				int hold=A[tempHi];
				A[tempHi]=A[tempLo];
				A[tempLo]=hold;
			}
			else
				break;
								     
		}
		
		return tempHi;
		
	}
	public static void printArray(int[]ar)
	{
		for(int dex=0;dex<ar.length;dex++)
		{
			System.out.print(ar[dex]+", ");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array={2,21,23,3255,596,6,58,5,4,8,9,68,468,5,5,4,8,6,8,9456,89,654,868,56,84,48,66,88,99,55,66,11,22,123,456,789,78,85,852,25,36,14,51,78,75,74,14,12,15,35,25,15,14,15,22,25,29,28,21,48,96,252,645,552,11,123,148,77,55,14789,12369,14,1456,125,1258,145,14,42,47,48,49,46,25,258,23,5,15,52,65,452,33,25,289,654,12574,14569,1236,123651,145,14,15,16,17,18,19,20,21,21,23,22,24,25,26};
		int[]array={1654,521,65865,15,86,56,51,4,8,76,5,49,835,23,11,868,35,4,9};
		final long startTimeMT=System.currentTimeMillis();
		mtquick_sort(array,0,array.length-1);
		final long endTimeMT=System.currentTimeMillis();
		final long startTimeQS=System.currentTimeMillis();
		quicksort_array(array,0,array.length-1);
		final long endTimeQS=System.currentTimeMillis();
		printArray(array); 
		System.out.println("\n"+(endTimeMT-startTimeMT) +" for multi threading");
		System.out.println(endTimeQS-startTimeQS+" for regular quick sort");
	}

}

package collegeServer;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class TPQuicksort {

	public static class quicksort_array extends RecursiveTask<int[]>
	{
	   private int[] A;
	   private int low;
	   private int hi;
	   public quicksort_array(int[]A,int low,int hi)
	   {
		   this.A=A;
		   this.low=low;
		   this.hi=hi;
	   }
	   @Override
	   protected int[] compute()
	   {
		   
		   if (low < hi){
			      final int pivot = partition(A, low, hi);
			      quicksort_array task1=new quicksort_array(A,low,pivot);
				  quicksort_array task2=new quicksort_array(A,pivot+1,hi); 
				  task1.fork();
				  task2.compute();
				  task1.join();
		   }
		   return A;
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
	public static void regularQS(int[]A,int low, int hi)
	{
		if(low<hi)
		{
			int pivot=partition(A,low,hi);
			regularQS(A,low,pivot);
			regularQS(A,pivot+1,hi);
		}
	}
	public static int[] createArray()
	{
		int[]randArray=new int[40000];
		for(int dex=0;dex<40000;dex++)
		{
			randArray[dex]=(int)(Math.random()*50000);
		}
		return randArray;
	}
	
	public static void printArray(int[]ar)
	{
		for(int dex=0;dex<ar.length;dex++)
		{
			System.out.print(ar[dex]+", ");
		}
		System.out.print("\n");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array=createArray();
		long mttime=0;
		long qstime=0;
		long tempBeg;
		long tempFin;
		int counter=0;
		int qtavg;
		int tavg;
		int switchoverPoint=0;
		ForkJoinPool pool=new ForkJoinPool();
		
		for(int dex=5;dex<array.length;dex+=5)
		{
			tempBeg=System.currentTimeMillis();
			int[]sortedArray=pool.invoke(new quicksort_array(array,0,dex));
			tempFin=System.currentTimeMillis();
			mttime=(tempFin-tempBeg);
			counter++;
			printArray(sortedArray);
			
			tempBeg=System.currentTimeMillis();
			regularQS(array,0,dex);
			tempFin=System.currentTimeMillis();
			qstime=(tempFin-tempBeg);
			printArray(array);
			if(mttime<qstime)
			{
				if(switchoverPoint==0||dex<switchoverPoint)
				{
					switchoverPoint=dex;
				}
			}
		}

		tavg=(int)mttime/counter;
		qtavg=(int)qstime/counter;
		
		System.out.print("Single threaded time was "+(qtavg)+". Multi-threaded time was "+tavg+"\nMulti-threaded time became faster with an array of "+switchoverPoint);
		
	}

}

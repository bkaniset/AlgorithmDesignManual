package com.triplebyte.Algorithms;

public class InsertionSortDemonstration {

	public static void main(String[] args) {
		int[] arr= new int[] {8 ,19 ,1 ,5 ,16 ,43 ,73 ,49 ,37, 24, 13};
		MergeSort m=new MergeSort();
	    m.arr=arr;
        m.sort(arr, 0, 10);	
        m.print();			
     
	  
	
	}	
}



/*
InsertionSort i=new InsertionSort(arr);
i.insertionSort();
i.print();
		
 MergeSort m=new MergeSort();
	    m.arr=arr;
        m.sort(arr, 0, 10);	
        m.print();			
	


*/
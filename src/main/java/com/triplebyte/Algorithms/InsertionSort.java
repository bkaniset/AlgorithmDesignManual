package com.triplebyte.Algorithms;

/* Heap sort is covered in DataStructres package. 
 * 
 * 
 */


public class InsertionSort {

int[] arr; 

public InsertionSort(int[] arr)
{
this.arr=arr;	
}

public void insertionSort()
{
	for(int i=2;i<this.arr.length;i++)
	{   
		int j=i;
		while((j>=1)&&(this.arr[j]<this.arr[j-1]))
		{
				int temp=this.arr[j];
				this.arr[j]=this.arr[j-1];
				this.arr[j-1]=temp;
				j--;
			
		}
	}
}
	
public void print()
{
	for(int i=0;i<this.arr.length;i++)
	{
		System.out.print(arr[i]+" ");
	}
}
}

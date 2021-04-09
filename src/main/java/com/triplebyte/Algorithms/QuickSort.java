package com.triplebyte.Algorithms;

public class QuickSort {

int[] arr;

public void print()
{
	for(int i: arr)
	{
		System.out.print(i+" ");
	}
}


public void sort(int[] arr, int low, int high)
{
	if(low<high)
	{
		int pi= partition(arr, low , high);
		sort(arr, low, pi-1);
		sort(arr, pi+1, high);
	}
}

public int partition(int[] arr, int low, int high)
{
  int i=low-1;
  int pivot= arr[high];
  
  for(int j=low;j<high;j++)
  {
	  if(arr[j]<pivot)
	  {
		  i++;
		  int temp=arr[i];
		  arr[i]=arr[j];
		  arr[j]=temp;
	  }
	  
  }
  int temp = arr[i+1];
  arr[i+1]=arr[high];
  arr[high]=temp;
  return i+1;
  
}

}
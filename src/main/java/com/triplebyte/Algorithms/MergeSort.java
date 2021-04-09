package com.triplebyte.Algorithms;

public class MergeSort {

int[] arr;	
	
public void print()
{
	for(int i: arr)
	{
		System.out.print(i+" ");
	}
}

public void sort(int[] arr, int l, int h)
{
	if(l<h)
	{
		int m=(l+h)/2;
      sort(arr, l, m);
      sort(arr, m+1 ,h);
      merge(arr , l , m , h);
	}
}

public void merge(int[] arr, int l , int m , int h)
{
	int first_size=m-l+1;
	int second_size=h-m;
	int[] first_half=new int[first_size];
	int[] second_half=new int[second_size];
	
	for(int i=0;i<first_size;++i)
	{
		first_half[i]=arr[l+i];
	}
	for(int i=0;i<second_size;i++)
	{
		second_half[i]=arr[m+1+i];
	}
    int i=0;
    int j=0;
    int k=l;
    int[] res=new int[2];
    while(i<first_size&&j<second_size)
    {
    	if(first_half[i]-second_half[j]<0)
    	{
    		arr[k]=first_half[i];    		   	
       	 	
       	 
       	 	res[0]=first_half[i];
       	 	res[1]=second_half[j];
       	 	if(Math.abs(res[0]-res[1])>Math.abs(first_half[i]-second_half[j]))
       	 	{
       	 		res[0]=first_half[i];
       	 		res[1]=second_half[j];
       	 	}
       	 i++;
    	}
    	else
    	{
    		arr[k]=second_half[j];
    		j++;
    		
    	}
    	k++;
    	
      
    }
     
    while(i<first_size)
    {
    	arr[k]=first_half[i];
    	if(i>1&&(Math.abs(res[0]-res[1])>Math.abs(first_half[i]-first_half[i-1])))
   	 	{
   	 		res[0]=first_half[i];
   	 		res[1]=second_half[j];
   	 	}
    	i++;
    	k++;
    	
    }
    while(j<second_size)
    {
    	arr[k]=second_half[j];
    	if(j>1&&(Math.abs(res[0]-res[1])>Math.abs(second_half[j]-second_half[j-1])))
   	 	{
   	 		res[0]=first_half[i];
   	 		res[1]=second_half[j];
   	 	}
    	j++;
    	k++;	
    }
  System.out.println(res[0]+"Carthago delanda est"+res[1]);
}

}

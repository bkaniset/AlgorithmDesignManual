package com.triplebyte.finaleffort;

/* Implementing a Stack and a queue using an array.  
 * 
 * 
 */


public class stackandqueuedemo {

/* inserting onto the stack. 
 * 1) There needs to be a check if the stack if full
 * 2) There needs to be a check if the stack if empty Line 34. If j=0 then stack is empty. 
 * */	
public void stackPush(int[] arr, int i)
{   
	boolean arr_indicator=false;
	int j=0;
	while(j<arr.length)
	{
		if(arr[j]==0)
		{
			arr_indicator=true;
		    break;
		}
		else
		{
			j++;
		}
	}
	System.out.println(j+"J indicator");
	
	if(arr_indicator)
	{
		if(j==0) {
			arr[0]=i;
	     System.out.println(i+" Is inserted into the stack"); 		
		      }else 
		      {
	            while(j>0)
	            {
		         arr[j]=arr[j-1];
		         j--;
	             }
	             arr[0]=i;
	}
	}
	else
	{
		System.out.println("Stack if full babayya");
	}
	
}

/*Utility method to print a stack to output */
public void stackOrQueuePrint(int[] arr)
{
	
			
	for(int i:arr)
	{
		System.out.println(i);
	}
			
}

/*Popping a stack */
public int stackPop(int[] arr)
{
	int topOfTheStack=arr[0];
	for(int i=1;i<arr.length;i++)
	{
	 arr[i-1]=arr[i];	
	}
	return topOfTheStack;
}

/* Pushing onto a queue */ 
public void queuePut(int[] arr, int j)
{
	boolean arr_indicator=false;
	int i=0;
	while(i<arr.length)
	{
		if(arr[i]==0)
		{
			arr_indicator=true;
			arr[i]=j;
			break;
		}
		else {
			i++;
		}
	}
	if(!arr_indicator)
	{
		System.out.println("Queue is full");
	}
}

/* Getting from a stack */
public int queueGet(int[] arr)
{
	boolean fullCheck=queueFullCheck(arr);
	int topoftheQueue=arr[0]; 
	for(int i=1;i<arr.length;i++)
	{
	   arr[i-1]=arr[i];	
	}
	System.out.println("Wassup");
	if(fullCheck)
	{
		arr[arr.length-1]=0;
	}
	return topoftheQueue;
}

/*
 * Queue full check returns true if the queue is full.  
 * 
 * */
public boolean queueFullCheck(int[] arr)
{
	boolean fullCheck=true;
	int i=0;
	while(i<arr.length)
	{
		if(arr[i]==0)
		{
			fullCheck=false; 
			break;
		}
		i++;
	}	
	return fullCheck; 
}
}


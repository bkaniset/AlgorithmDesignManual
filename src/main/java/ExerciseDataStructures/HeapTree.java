package ExerciseDataStructures;

/* This is the implementation of heaptree as an Array. 
 * Functions include; 
 * 1) insert. 
 * 2) retrive min. 
 * 
 * 
 * This is built as described in Algorithm Design Manual, Steven Skeina.
 * Chapter 4: Sorting
 * Array of n elements 
 * 
 */



public class HeapTree {

	int[] arr; 
	int insert_index;
	
public HeapTree(int size)
{
	this.arr=new int[size];
	this.insert_index=1;
}


	

public void insertIntoHeap(int i)
{
	if(this.insert_index<this.arr.length)
	{
	System.out.println(i+"is being inserted at "+this.insert_index);	
	arr[this.insert_index]=i;
	bubbleUp(i, this.insert_index);
	this.insert_index++;
    }
	
}

/*  Logic for bubble up 
 *  Check for the element's parent, if is is before the parent in a sorted order, swap. 
 *  Perform this until you come to the root. 
 * 
 */


public void bubbleUp(int i, int insert_index)
{
	if(insert_index<1)
	{
		return; 
	}
	else
	{
		if(i<this.arr[insert_index/2])
		{
			int temp=arr[insert_index/2];
			arr[insert_index/2]=i;
			arr[insert_index]=temp;
			bubbleUp(i, insert_index/2);
		}
	}
}

/*  Logic: 
 *  1) Return this.arr[1];
 *  2) swap this.arr[insert_index]=arr[1]; decrement insert_index by 1. 
 *  3) Call bubble down on arr[1]; 
 * 
 * */

 
public int extractMin()
{
	int min=this.arr[1];	
	arr[1]=arr[this.insert_index-1];
	this.insert_index--;
    bubbleDown(1);
	return min;
}

/* Logic: 
 * 1) Compare arr[1] to its two children at arr[2] and arr[3].  
 * 2) Swap this element with one of its children, one that is dominant of the three. 
 * 3) repeat this process, with this element and its new children. 
 * 4) return when calling index> insert_index.  
 */


public void bubbleDown(int parent)
{
	if(2*parent+1>this.insert_index)
	{
		return;
	}
	if(this.arr[parent]<this.arr[2*parent]&&this.arr[parent]<this.arr[2*parent+1])
	{
		return;
	}
	
	if(this.arr[2*parent]>this.arr[2*parent+1])
	{
		if(this.arr[parent]>this.arr[2*parent+1])
		{   
			int temp=this.arr[parent];
			this.arr[parent]=this.arr[2*parent+1];
			this.arr[2*parent+1]=temp;
			bubbleDown((2*parent+1));
		}
	}
	else
	{
		if(this.arr[parent]>this.arr[2*parent])
		{
			int temp=this.arr[parent];
			this.arr[parent]=this.arr[2*parent];
			this.arr[2*parent]=temp;
			bubbleDown(2*parent);
		}
	}
}



public void printTree()
{
	for(int i=1;i<this.insert_index;i++)
	{
		System.out.print(" "+arr[i]);
	}
	System.out.println();
}

/* Find out if the k'th smallest element is bigger than a number x 
 * Steven Skeina: Page 129. 
 * Hint: Find how many elements are less than x. 
 * If count is greater than k, then k th smallest element must be less than x. 
 */

public int lessThanCount(int comparator, int startingpoint)
{   int count=0;
	if(startingpoint<insert_index&&this.arr[startingpoint]<comparator)
	{
		count++;
		count=count+lessThanCount(comparator, 2*startingpoint);
		count=count+lessThanCount(comparator, 2*startingpoint+1);
	}
	return count;
}


}

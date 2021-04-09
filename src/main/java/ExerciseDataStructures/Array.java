package ExerciseDataStructures;

/*  All Functions of an dictionary are implemented here. 
 *  Insert- Done. 
 *  Delete- Done.   
 *  Search- Done.  
 *  Amortize- worst case is 2*n moves of elements- Done.  
 *  Return Minimum- Done.  
 *  Return Maximum- Done. 
 *  Successor- Using correct logic. 
 *  Predecessor- using correct logic. 
 *
 */


public class Array {

int[] arr;
int insert_index;


public Array()
{
arr=new int[2];
insert_index=0;
}


public int[] amortizer(int[] arr)
{
	int[] new_arr=new int[arr.length*2];
    for(int i=0;i<this.insert_index;i++)
	{
	  new_arr[i]=arr[i];	
	}
	System.out.println("Returning amortized array");
    return new_arr;
}

public void insertIntoArray(int i)
{
	 
	if(this.insert_index<=this.arr.length-1)
	{	
	this.arr[insert_index]=i;
	System.out.println("element "+i+" Inserted at "+insert_index);
	this.insert_index++;
	}
	else
	{
		this.arr=amortizer(arr);
		insertIntoArray(i);
	}
}

public void deleteFromArray(int i)
{
 int readjust_index=this.searchInArray(i);	
  if(readjust_index>=0)
  {
	  this.arrayReadjust(readjust_index);
  } 
}

public int searchInArray(int i)
{
	int isPresent_index=-1;
	for(int p=0;p<this.arr.length;p++)
	{
		if(arr[p]==i)
		{
			isPresent_index=p;
			System.out.println("element is present at "+p);
			return isPresent_index;
		}
	}
	return isPresent_index;
}

public void arrayReadjust(int readjust_index)
{	
	for(int i=readjust_index;i<this.arr.length-1;i++)
	{
		this.arr[i]=this.arr[i+1];
	} 
	this.arr[this.arr.length-1]=0;
System.out.println("readjust successful");
}

public void printArray()
{
	for(int i: this.arr)
	{
		System.out.print(i+" ");
	}
	
}

public int returnMax()
{
int max=this.arr[0];	
for(int i=1;i<this.arr.length;i++)
{
 if(this.arr[i]>max)
 {
	 max=this.arr[i];
 }
 
}
return max;
}

public int returnMin()
{
int min=this.arr[0];	
for(int i=1;i<this.arr.length;i++)
{
 if(this.arr[i]!=0&&this.arr[i]<min)
 {
	 min=this.arr[i];
 }
 
}
return min;
}

/*  Returns; 
 *  Greater than or equal to zero if the element is present.  
 *  less than zero is the element is not present. 
 *  Return the element which gives you the least difference other than zero. 
 *
 *
 */


public int returnPredecessorCV(int i) throws ArrayIndexOutOfBoundsException
{
	int index=this.searchInArray(i);
	int predecessor_index=-1; 
	int p=0;
	int min=-1;
	while(p<this.arr.length&&p!=index)
	{
		if(min<=0)
		{
			min=i-this.arr[p];
		}
		else
		{
			if(min>i-this.arr[p])
			{
				min=i-this.arr[p];
				predecessor_index=p;
			}
		}
		p++;
	}
	System.out.println(predecessor_index);
return this.arr[predecessor_index];
}


public int returnSuccessor(int i) throws ArrayIndexOutOfBoundsException 
{
	int index=this.searchInArray(i);
	int successor_index=-1; 
	int p=0;
	int min=0;
	while(p<this.arr.length)
	{
		if(p!=index&&this.arr[p]!=0)
		{
		if(min<=0)
		{
			min=this.arr[p]-i;
		   
		}
		else
		{
			if(min>this.arr[p]-i)
			{
				min=this.arr[p]-i;
				successor_index=p;
			}
		}
	}
		p++;
	       
		}
	System.out.println(successor_index);
return this.arr[successor_index];
	
}

public int returnPredecessorRV(int i)
{
	int isPresent=this.searchInArray(i);
	int min=0;
	int predecessor=0; 
	if(isPresent>=0)
	{
		int p=0;
		while(p<this.arr.length)
		{
		if(min==0&&this.arr[p]<i)
		{
			min=i-this.arr[p];
			predecessor=arr[p];
			p++;
		}
		else
		{
			if(this.arr[p]<i&&min>i-this.arr[p])
			{
				min=i-this.arr[p];
				predecessor=arr[p];
				p++;
			}
			else
			{
				p++;
			}
		}
   }
		
}
		
	return predecessor;
}

public int returnSuccessorRV(int i)
{
    int isPresent=this.searchInArray(i);
	int min=0;
	int successor=0;
	int p=0;
  	if(isPresent>=0)
  	{
  		while(p<this.arr.length)
  		{
  			if(min==0&&this.arr[p]>i)
  			{
  				min=this.arr[p]-i;
  				successor=this.arr[p];
  				p++;
  			}
  			else
  			{
  				if(this.arr[p]>i&&min>this.arr[p]-i)
  				{
  					min=this.arr[p]-i;
  					successor=this.arr[p];
  					p++;
  				}
  				else
  				{
  					p++;
  				}
  			}
  		}
  	}
	
return successor;
}

}

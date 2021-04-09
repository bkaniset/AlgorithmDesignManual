package com.depthfirstsearch;

public class Timer {


int[] time; 
int insertIndex; 


public Timer()
{
this.time=new int[2];
this.insertIndex=0;
}

public int[] amortize()
{
	int[] new_time=new int[2*this.time.length];
	for(int i=0;i<2*this.time.length;i++)
	{
		if(i<this.time.length)
		{
		new_time[i]=this.time[i];
		}
		else
		{
			new_time[i]=0;
		}
	}	
	return new_time;
}

public void insertTime(int i)
{
	if(this.insertIndex<=this.time.length-1)
	{
		this.time[this.insertIndex]=i;
	}
	else
	{
		this.time=amortize();
		insertTime(i);
	}
}



}

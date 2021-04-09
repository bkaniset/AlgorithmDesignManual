package com.kruskall;


/* We need to be able to; 
 * 1) Add an edge to an existing component. Create a new component.  
 * 2) Create a new component, if necessary.  
 * 3) Merge Components in response to adding a new Edge. 
 * 4) In The end, there will only be one component.  
 */



public class KruskallTree {

Component[] c;	
int componentInsertIndex;

public KruskallTree()
{
	this.c=new Component[2];
	this.c[0]=new Component();
	this.c[1]=new Component();
	this.componentInsertIndex=0;
}
	
/*  Inserting an edge into this tree is a little complicated. 
 * 1) we have to go through all the components, If the edge    
 * 2) creates a cycle in any of the components, Reject it. 
 * 3) If it is not a part of any component, create a new component.  
 */

public void insertEdge(Edge e)
{
	if(this.insertIndex<this.c.length)
	{
		this.c[this.insertIndex].insertEdge(e);
		this.insertIndex++;
		
	}
     
}

public Component[] amortize()
{
	Component[] arr=new Component[this.c.length+2];
	for(int i=0;i<this.c.length+2;i++)
	{
		if(i<this.componentInsertIndex)
		{
			arr[i]=this.c[i];
		}
		else
		{
			arr[i]=new Component();
		}
	}
	return arr;
}
}

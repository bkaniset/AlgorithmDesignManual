package com.kruskall;

/* This is a data structure which works as a kruskall's tree and has the following functionality.  
 * 1. Insert Edge.  
 * A. inserts an edge into an appropriate component- One Vertex in common. 
 * B. creates a component if it is required- No Vertices in common.    
 * C. rejects the edge if a cycle would be created- Two Vertices in common between the edge being inserted and   
 * 
 * 2. Union 
 * A. Merges two components if one edge belongs to one component and another vertex belongs to another component. 
 * 
 * Returns a single component after which the Kruskall's minimum spanning tree is complete and the loop exists. 
 */



public class UnionFind {
Component[] c;
int componentInsertIndex;

public UnionFind()
{
	this.c=new Component[2];
	this.componentInsertIndex=0;
}

/* Should we use int as a return value? 
 * 
 *  
 */

public void insertEdge(Edge e)
{
int fromIdentifier=-1;
int toIdentifier=-1;

for(int i=0;i<this.componentInsertIndex;i++)
{
	if(this.c[i].checkIfVertexExists(e.from))
	{
		fromIdentifier=i;
	}
	if(this.c[i].checkIfVertexExists(e.to))
	{
		toIdentifier=i;
	}
}

if(fromIdentifier==-1&&toIdentifier==-1)
{
  Component A=new Component();
  A.insertEdge(e);
  System.out.println("Component created with edge "+e.from.name+" and "+e.to.name);
  if(this.componentInsertIndex<this.c.length)
  {
  this.c[this.componentInsertIndex]=A;		
  this.componentInsertIndex++;
  }
  else
  {
	this.c=amortize();
	this.c[this.componentInsertIndex]=A;		
	this.componentInsertIndex++;	
  }
}
else if(fromIdentifier==toIdentifier)
{
  System.out.println("This would create an cycle");
 return ; 
}
else if(fromIdentifier>=0&&toIdentifier>=0)
{ 	
  this.mergeComponents(fromIdentifier, toIdentifier, e);
}
else if(fromIdentifier>=0&&toIdentifier<0)
{
	System.out.println("Adding an Edge to an existing component");
	this.c[fromIdentifier].insertEdge(e);
}
else if(fromIdentifier<0&&toIdentifier>=0)
{
	System.out.println("Adding an Edge to an existing component");
	this.c[toIdentifier].insertEdge(e);
}
}

/* merges component from a higher index to the lower index.
 * 
 */


public void mergeComponents(int a, int b, Edge e)
{
    
	if(a<b)
	{
	System.out.println("Merging component at "+b+" with component at "+a);
	this.c[a].insertEdge(e);
	this.c[a].mergeComponent(this.c[b]);
	this.deleteCompoenent(b); 
	}
	else
	{	
	System.out.println("Merging component at "+c+" with component at "+b);	
	this.c[b].insertEdge(e);
	this.c[b].mergeComponent(this.c[a]); 	
    this.deleteCompoenent(a);
    }
}

/*
Delete one component at index a, and 
move all the components from a to insertindex-1 left. 
*/

public void deleteCompoenent(int a)
{
this.c[a]=null;
for(int i=a;i<this.componentInsertIndex-1;i++)
{
    this.c[a]=this.c[a+1];    
}
this.componentInsertIndex--;
this.c[this.componentInsertIndex]=null;
System.out.println("Component deleted "+this.c[this.componentInsertIndex]);
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

public boolean treeComplete(int a)
{
	if(this.componentInsertIndex==1&&this.c[1]==null&&this.c[0].v.length==a)	
	{
		return true;
	}
	return false;
}


}

package com.depthfirstsearch;

/* constructor. 
 * 
 * 
 * 
 * 
 * 
 */



public class Stack {

Vertex[] q_PushandPop;
QueueVertex[] q_discandProc;
Vertex[] treeedges;
Vertex[] backedges;
int treeEdgeInsertIndex;
int backEdgeinsertIndex;
int poptracker;  
int insertIndex;
int clock;

public Stack(AdjacencyList a)
{
	initialize(a);
	this.poptracker=-1;
	this.insertIndex=0;
	this.clock=0;
	this.treeEdgeInsertIndex=0;
	this.backEdgeinsertIndex=0;
	this.backedges=new Vertex[2];
	this.treeedges=new Vertex[2];
}

public void initialize(AdjacencyList a)
{
	this.q_discandProc=new QueueVertex[a.vertices.length];
	this.q_PushandPop=new Vertex[a.vertices.length];
	for(int i=0;i<a.vertices.length;i++)
	{
		this.q_discandProc[i]=new QueueVertex();
		this.q_PushandPop[i]=new Vertex();
	}
}

/* Vertex v1 is the vertex that is being pushed. 
 * Vertex V2 is the parent of the vertex v1. 
 * 
 * 
 */

public void push(Vertex v1, Vertex v2)
{
	this.poptracker++;
	this.q_PushandPop[this.poptracker]=v1;
	this.q_discandProc[this.insertIndex].vertex=v1;
	this.q_discandProc[this.insertIndex].Parent=v2;
	this.q_discandProc[this.insertIndex].isDiscovered=true;
	this.q_discandProc[this.insertIndex].isProcessed=false;
	this.q_discandProc[this.insertIndex].t.insertTime(clock);
	this.treeedges[this.treeEdgeInsertIndex]=v2;
	this.treeedges[this.treeEdgeInsertIndex+1]=v1;
	this.treeEdgeInsertIndex=this.treeEdgeInsertIndex+2;
	System.out.println("Tree edge "+v2.name+", "+v1.name+" also added");
	this.treeedges=this.amortize(this.treeedges);
	System.out.println(v1.name+" pushed onto the stack at "+this.insertIndex+ " location with "+v2.name+" as parent");
	this.insertIndex++;
	this.clock++;
}

public void push(Vertex v1)
{
	System.out.println(v1.name+" pushed onto the stack at "+this.insertIndex+ " location");
	this.poptracker++;
	this.q_PushandPop[this.poptracker]=v1;
	this.q_discandProc[this.insertIndex].vertex=v1;
	this.q_discandProc[this.insertIndex].Parent=null;
	this.q_discandProc[this.insertIndex].isDiscovered=true;
	this.q_discandProc[this.insertIndex].isProcessed=false;
	this.q_discandProc[this.insertIndex].t.insertTime(clock);
	this.insertIndex++;		
	this.clock++;	
}

public boolean isThisVertexStacked(Vertex v)
{ 
  boolean res=false;
  for(int i=0;i<this.insertIndex;i++)
  {
	  if(v.equals(q_discandProc[i].vertex))
	  {
		  System.out.println(v.name+" is already stacked at "+i+" location.");
		  res=true;
	  }
  }
   if(!res)
   {
	   System.out.println(v.name+" is not stacked");
   }
	return res;
}

public EdgeList getEdgeList(Vertex v, AdjacencyList a)
{
	for(int i=0;i<a.edges.length;i++)
	{
	    if(a.edges[i].from.equals(v))
	    {
	    	return a.edges[i];
	    }
	}	
	return null;
}

public boolean isStackFilled()
{
	boolean res=false; 
	int fillCount=0;
	if(this.insertIndex<this.q_discandProc.length)
	{
		System.out.println(this.insertIndex+" Not all vertices are discovered.");
		return false;
	}
	else
	{	
		for(int i=0;i<this.q_discandProc.length;i++)
		{
			if(this.q_discandProc[i].isDiscovered==true&&this.q_discandProc[i].isProcessed==true)
			{
				fillCount++;
			}
		}
	}
	if(fillCount==this.q_discandProc.length)
	{
		System.out.println("All Vertices are discoverd and processed");
		res=true;
	}
	else
	{
		System.out.println("Not all vertices are processed.");
	}
	return res;
	
}

/* Make sure you include clock while popping. 
 * 
 * 
 */

public Vertex pop(int discoveryCount)
{
Vertex v=null;
if(discoveryCount>0)
{
v=this.q_PushandPop[this.poptracker];
System.out.println("moving forward in the stack");
this.insertTime(v);
}
else
{
  if(this.poptracker>=1)
  {
	this.q_PushandPop[this.poptracker]=null;
	this.poptracker--;
	System.out.println("moving backward in the stack by popping "+this.q_PushandPop[this.poptracker].name);
    v=this.q_PushandPop[this.poptracker];    
	this.insertTime(v);
    
   }
  }	
return v;
}

public void insertTime(Vertex v)
{
	for(int i=0;i<this.insertIndex;i++)
	{
		
		if(this.q_discandProc[i].vertex.equals(v))
		{
			Timer timus=this.q_discandProc[i].t;
			timus.insertTime(this.clock);
		}
	}
	this.clock++;
	
}


public Vertex[] amortize(Vertex[] arr)
{
	System.out.println("Amortizing");
	Vertex[] new_arr=new Vertex[arr.length+2];
	for(int i=0;i<arr.length+2;i++)
	{
		if(i<arr.length)
		{
		new_arr[i]=arr[i];  
		}
	}	
	return new_arr;
}

public void insertbackEdge(Vertex v1, Vertex v2)
{
	System.out.println(this.backEdgeinsertIndex);
	this.backedges[this.backEdgeinsertIndex]=v1;
	this.backedges[this.backEdgeinsertIndex+1]=v2;	
	this.backEdgeinsertIndex=this.backEdgeinsertIndex+2;
	this.backedges=amortize(this.backedges);
}

public void markProcessed(Vertex v)
{	
	for(int i=0;i<this.insertIndex;i++)
	{
		if(v.equals(this.q_discandProc[i].vertex))
		{
			this.q_discandProc[i].isProcessed=true;
			System.out.println(this.q_discandProc[i].vertex.name+" is marked processed");
		}
	}
}

public void earliestReachableAncestor()
{
	
}

}


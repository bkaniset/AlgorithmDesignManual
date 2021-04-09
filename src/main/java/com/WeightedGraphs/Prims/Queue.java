package com.WeightedGraphs.Prims;

public class Queue {
	
QueueVertex[] queuevertex;
int insertIndex;
int popIndex;
Edge[] edges;
int edgeinsertIndex;
Vertex[] mstcompletion; 

public Queue(AdjacencyList a)
{
	this.queuevertex=new QueueVertex[a.vertices.length];
	this.mstcompletion=new Vertex[a.vertices.length];
	for(int i=0;i<a.vertices.length;i++)
	{
		this.queuevertex[i]=new QueueVertex();
		this.mstcompletion[i]=a.vertices[i];
	}
	this.edges=new Edge[2];
	this.edges[0]=new Edge();
	this.edges[0]=new Edge();
	this.edgeinsertIndex=0;
	this.insertIndex=0;
	this.popIndex=0;
}
	
public Edge[] amortize(Edge[] edges)
{
	Edge[] new_edges=new Edge[2*edges.length];
  
			for(int i=0;i<this.edgeinsertIndex;i++)
			{
				if(i<edgeinsertIndex)
				{
					new_edges[i]=edges[i];
				}
				else
				{
					new_edges[i]=new Edge();
				}
			}
return new_edges;
}
	
public boolean isThisVertexEnqueued(Vertex v)
{
	boolean res=false;
	for(int i=0;i<this.insertIndex;i++)
	{
		if(this.queuevertex[i].vertex!=null&&this.queuevertex[i].vertex.equals(v))
		{
			System.out.println("Vertex "+this.queuevertex[i].vertex.name+ " is enqueued");
		   return true;
		}
	}	
	if(!res)
	{System.out.println("Vertex "+v.name+ " is not enqueued");	 	
	}
return false;		
}

public void push(Vertex v, Vertex parent)
{
	
	this.queuevertex[insertIndex].vertex=v;
	this.queuevertex[insertIndex].isDiscovered=true;
	this.queuevertex[insertIndex].isProcessed=false;
	this.queuevertex[insertIndex].Parent=parent;
	System.out.println(this.queuevertex[insertIndex].vertex.name+" is discovered and being pushed onto the stack with a parent "+this.queuevertex[insertIndex].Parent.name);
	insertIndex++;
}

public void push(Vertex v)
{
	this.queuevertex[insertIndex].vertex=v;
	this.queuevertex[insertIndex].isDiscovered=true;
	this.queuevertex[insertIndex].isProcessed=false;
	this.queuevertex[insertIndex].Parent=null;
	System.out.println(this.queuevertex[insertIndex].vertex.name+" pushed onto the stack");
	insertIndex++;
}

public QueueVertex queueHead()
{   	 
   return this.queuevertex[popIndex];
}

public void moveHead()
{
	this.popIndex++;
}

public void markProcessed()
{
this.queuevertex[popIndex].isProcessed=true;
System.out.println(this.queuevertex[popIndex].vertex.name+ " is marked processed");
}

public Vertex pop()
{
	moveHead();
	if(this.popIndex<this.queuevertex.length)
	{
	return this.queuevertex[popIndex].vertex;
    }
	else
	{
		return null;
	}
}


public boolean isQueueEmpty()
{
	 boolean res=true;
	 for(int i=0;i<this.queuevertex.length;i++)
	  {
		 if(this.queuevertex[i].isProcessed==false)
		 {
				 System.out.println(this.queuevertex[i].vertex.name+" is next to be processed");
				 return false;	 
			 
			 
		 }
	 }
	 if(res)
	 {
		 System.out.println("Queue is empty");
	 }
   return res;
}

/* This function is specifically for minimum spanning trees. 
 * Use a new data structure to add all vertices from the adjacencyList, 
 * and peel off each time its pushed onto the queue. 
 * 
*/

public void markMapped(Vertex v)
{
	for(int i=0;i<this.mstcompletion.length;i++)
	{
		if(this.mstcompletion[i].equals(v))
		{
			this.mstcompletion[i]=null;
		}
	}
}

public boolean isTreeMapped()
{
	for(int i=0;i<this.mstcompletion.length;i++)
	{
		if(this.mstcompletion[i]!=null)
		{
			return false;
		}
	}
	System.out.println("Tree is completely Mapped");
	return true;
}

public boolean isThisEdgeEnqueued(Vertex v, Vertex startNode)
{
	for(int i=0;i<this.edgeinsertIndex;i++)
	{
		if(this.edges[i].from.equals(startNode)&&this.edges[i].to.equals(v))
		{
			return true;
		}
	}
 return false;
}







}

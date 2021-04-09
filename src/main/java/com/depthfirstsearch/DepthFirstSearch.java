package com.depthfirstsearch;

import ExerciseDataStructures.BreadthFirstSearch;

public class DepthFirstSearch {

AdjacencyList a;	
Stack s;	


public DepthFirstSearch(AdjacencyList a)
{
	this.a=a;
	this.s=new Stack(a);
}

/* Algorithm: 
 * 1) add start node to the stack.  
 * 2) get next vertex from the adjacencylist. 
 * 3) get the edgelist of that vertex. 
 * 4) repeat step 3.  
 * If- we reach a point where there are no new vertices to be discovered, and stack is not filled. 
 * backtrack through the edgelist array. 
 */

public Vertex[] depthFirstSearch(Vertex startNode)
{
   int jumpingOffPoint=a.checkIfVertexExists(startNode);
   if(jumpingOffPoint<0)
   {
	   System.out.println("Vertex is not in the graph");
	   return null;
   }
   else
   {
	  if(!s.isThisVertexStacked(startNode)) 
	  {
	     s.push(startNode);  	  
	   
	    while(!s.isStackFilled())
	    {
	    	int discoveryCount=0;
	    	outer: for(int i=0;i<this.a.edges.length;i++)
	    	{
	    		if(startNode.equals(this.a.edges[i].from))
	    		{
	    			EdgeList e=this.a.edges[i];
	    			 for(int j=0;j<e.insertIndex;j++)
	    			{
	    				if(e.to[j]!=null&&(!s.isThisVertexStacked(e.to[j].v)))
	    				{
	    				  s.push(e.to[j].v, startNode);	
                          discoveryCount++;
                          break outer;
	    				}
	    			}
	    		  
	    		}
	    		
	    	}
	    	 if(discoveryCount==0)
	    	 {
	    		 s.markProcessed(startNode);
	    	 }
	    	startNode=s.pop(discoveryCount);
	    }
	    
	  
	  }
	  	   
   }

return s.treeedges;
}

public AdjacencyList cleanTreeEdges(Vertex v)
{
AdjacencyList a=this.a;	
Vertex[] treeedges=depthFirstSearch(v);
for(int i=0;i<treeedges.length;i=i+2)
{
  Vertex edgeStart=treeedges[i];
  Vertex edgeEnd=treeedges[i+1];
  if(edgeEnd!=null&&edgeStart!=null)
  {
  a.deleteEdge(edgeStart, edgeEnd);
}
}
return a;
}

public AdjacencyList cleanTreeEdges(Vertex v, Vertex[] tree)
{
AdjacencyList a=this.a;	
Vertex[] treeedges=tree;
for(int i=0;i<treeedges.length;i=i+2)
{
  Vertex edgeStart=treeedges[i];
  Vertex edgeEnd=treeedges[i+1];
  if(edgeEnd!=null&&edgeStart!=null)
  {
  a.deleteEdge(edgeStart, edgeEnd);
}
}
return a;
}


public Vertex[] backEdges(Vertex v)
{
	AdjacencyList a=this.cleanTreeEdges(v);
    for(int i=this.a.vertices.length-1;i>=0;i--)
    {
    	EdgeList e=a.edges[i];
    	for(int j=0;j<e.insertIndex;j++)
    	{
    	if(e.to[j]!=null)
      	{
      		this.s.insertbackEdge(e.from, e.to[j].v);
      	}    	
    	}    	
    }
    Vertex[] res=new Vertex[this.s.backedges.length/2];
    for(int i=0;i<res.length;i++)
    {
    	res[i]=this.s.backedges[i];
    }
    return res;
}

public Vertex[] backEdges(Vertex v, Vertex[] tree)
{
	AdjacencyList a=this.cleanTreeEdges(v, tree);
    for(int i=this.a.vertices.length-1;i>=0;i--)
    {
    	EdgeList e=a.edges[i];
    	for(int j=0;j<e.insertIndex;j++)
    	{
    	if(e.to[j]!=null)
      	{
      		this.s.insertbackEdge(e.from, e.to[j].v);
      	}    	
    	}    	
    }
    Vertex[] res=new Vertex[this.s.backedges.length/2];
    for(int i=0;i<res.length;i++)
    {
    	res[i]=this.s.backedges[i];
    }
    return res;
}


public void earliestReachbleAncestor(Vertex v)
{
	Vertex[] treeedges=depthFirstSearch(v);
	Vertex[] backedges=backEdges(v, treeedges);
	
	Vertex[] stack=new Vertex[this.a.vertices.length];
	stack[0]=v;
	int j=1;
	for(int i=1;i<treeedges.length;i=i+2)
	{
	 if(treeedges[i]!=null&&treeedges[i].name!=null)
	 {
	 stack[j]=treeedges[i]; 
	 j++;
	 System.out.println(treeedges[i].name+" is being entered.");
	 }
	}





}
}

package com.WeightedGraphs.Prims;


/* The adjacency list has already given us a list of items in a sorted order. 
 * Follow the leash.   
 * 
 * 1) At Each Vertex V, select the vertex which; 
 * A. has an edge with V. 
 * B. has not been included in the queue yet. 
 * B. has the least weight.  
 * 
 *  
 */





public class PrimsMinimumSpanningTrees {

AdjacencyList a; 
OutTree o;
Tree t;

public PrimsMinimumSpanningTrees(AdjacencyList a)
{
	this.a=a;
    this.o=new OutTree(a);
    this.t=new Tree(a);
}

/*  1)   Add vertex to the tree. 
 *  2) Get the least costly edge to the tree and add edge. 
 *  3)   
 *     
 *     
 *     */


public Edge[] GetMSTPrims(Vertex startNode)
{
	int point=a.checkIfVertexExists(startNode);
	if(point<0)
	{
		System.out.println("Node does not exist in the graph");
		return null;
	}
	else
	{
		
		t.insertVertices(startNode);
		while(!t.isTreefull(this.a.vertices.length))
		{
			Edge e=o.requestEdge(t);
			t.insertEdgeIntree(e);
			this.o.edgesOutTree=o.deleteEdge(e);
		}
	}
	
	return t.edgesinTree;
}



public void PrintPrimsMST(Vertex startNode)
{
	Edge[] e=this.GetMSTPrims(startNode);	
	System.out.println("completed");
	for(int i=0;i<e.length;i++)
	{
		if(e[i]!=null)
		{
		System.out.println(e[i].from.name+ "->"+ e[i].to.name);
	}
	}	
}
	
}

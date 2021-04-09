package com.WeightedGraphs.Prims;

public class Tree {

Vertex[] verticesinTree;
Edge[] edgesinTree;
int verticesinsertIndex;
int edgesinsertIndex;
AdjacencyList a;

public Tree(AdjacencyList a)
{
	this.a=a;
	this.verticesinTree=new Vertex[a.vertices.length];
	this.edgesinTree=new Edge[2];
	this.edgesinTree[0]=new Edge();
 	this.edgesinTree[1]=new Edge();
    for(int i=0;i<a.vertices.length;i++)
    {
    	this.verticesinTree[i]=new Vertex();
    }
    this.verticesinsertIndex=0;
    this.edgesinsertIndex=0;
}
	
public void insertEdgeIntree(Edge e)
{
    if(edgesinsertIndex<this.edgesinTree.length)
    {
	this.edgesinTree[this.edgesinsertIndex]=e;
	this.edgesinsertIndex++;
	insertVertices(e);	
    }
    else
    {
     this.edgesinTree=amortize(this.edgesinTree);
	 insertEdgeIntree(e);  
    }
}

public void insertVertices(Edge e)
{
	if(e!=null)
	{
	insertVertices(e.from);
	insertVertices(e.to);
	System.out.println("Edge inserted");
}
}

public void insertVertices(Vertex v)
{
	
	if(!isVertexpresent(v))
	{
		System.out.println(" Vertex "+v.name+" is added to the MST");
		this.verticesinTree[this.verticesinsertIndex]=v;
		this.verticesinsertIndex++;
	}	
}

public Edge[] amortize(Edge[] arr)
{
	Edge[] new_arr=new Edge[arr.length+2];
	for(int i=0;i<arr.length+2;i++)
	{
		if(i<arr.length)
		{
		new_arr[i]=arr[i];
	   }
		else
		{
			new_arr[i]=new Edge();
		}
	} 
	return new_arr;
}

public boolean isVertexpresent(Vertex v)
{
	for(int i=0;i<this.verticesinsertIndex;i++)
	{
		if(this.verticesinTree[i].equals(v))
		{
			System.out.println(v.name+"This present in the tree");
			return true;
		}
	}
	return false;
}

/* This logic itself is false;
 * 
 * 
 * 
 */


public boolean isTreefull()
{
	int treesize=0;
	for(int i=0;i<a.vertices.length;i++)
	{
		if(isVertexpresent(a.vertices[i]))
		{
			treesize++;
		}
	}
	if(treesize==a.vertices.length&&isTreeConnected())
    {
	return true;
    }
	else
	{
		return false;
	}
    	
}

/* This function should return true when all vertices are added to the tree, 
 * are are all reachable. 
 */

public boolean isTreeConnected()
{
	Vertex[] v=a.vertices;
	boolean[] connectionChecker=new boolean[a.vertices.length];
	
}




}

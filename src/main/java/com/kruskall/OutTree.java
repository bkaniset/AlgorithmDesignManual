package com.kruskall;



/* Vertices out of tree will all the vertices at the begining, 
 * but as edges are added, they will be removed. 
 * and we will exit once vertices outTree is all null! 
 * 
 * 
 */


public class OutTree {

	
Vertex[] verticesOutTree;
Edge[] edgesOutTree;	
	
public OutTree(AdjacencyList a)
{
	this.verticesOutTree=new Vertex[a.vertices.length];
	this.edgesOutTree=new Edge[a.edgecount];
	for(int i=0;i<a.vertices.length;i++)
    {
    	this.verticesOutTree[i]=a.vertices[i];
    }
	int p=0;
	for(int i=0;i<a.edges.length;i++)
	{
		for(int j=0;j<a.edges[i].insertIndex;j++)
		{
			if(a.edges[i].to[j]!=null&&p<this.edgesOutTree.length)
			{
				
			this.edgesOutTree[p]=new Edge(a.edges[i].from, a.edges[i].to[j].v, a.edges[i].to[j].weight);
		    p++;
			}
		}
	}
	quickSortEdges(edgesOutTree, 0, this.edgesOutTree.length-1);
}

public void quickSortEdges(Edge[] edgesOutTree, int low, int high)
{
  if(low<high)
  {
	  int pi=partition(edgesOutTree, low, high);
	  quickSortEdges(edgesOutTree, low, pi-1);
	  quickSortEdges(edgesOutTree, pi+1, high);
  }
	
}

public int partition(Edge[] arr, int low, int high)
{
  
	int i=low-1; 
	int pivot=arr[high].weight;    
	for(int j=low;j<high;j++)
	{
		if(arr[j].weight<pivot)
		{
			i++;
			Edge temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
	Edge temp=arr[i+1];
    arr[i+1]=arr[high];
    arr[high]=temp;
    return i+1;
}

/* Delete Vertex and Edge from this? How ? 
 * Also need function for Tree empty.  
 * 
 * 
 * 
 */


public boolean isVertexpresent(Vertex v)
{
	for(int i=0;i<this.verticesOutTree.length;i++)
	{
		if(this.verticesOutTree[i]!=null&&this.verticesOutTree[i].equals(v))
		{
			System.out.println(v.name+"This present in the tree");
			return true;
		}
	}
	return false;
}


public Vertex[] deleteVertex(Vertex v) 
{
	
	System.out.println(this.verticesOutTree.length);
	Vertex[] new_arr=new Vertex[this.verticesOutTree.length-1]; 
	int i=0;
	int j=0;
	while(i<this.verticesOutTree.length-1&&j<new_arr.length)
	{
		if(this.verticesOutTree[i].equals(v))
		{
		   i++;	
		}
		else
		{
			new_arr[j]=this.verticesOutTree[i];
			i++;
			j++;
		}
	}
	return new_arr;
	
}

public Edge[] deleteEdge(Edge e)
{  
	 if(this.edgesOutTree.length==0)
	 {
		 return null;
	 }
    	
	Edge[] new_edges=new Edge[this.edgesOutTree.length-1];
	int i=0;
	int j=0;
	while(i<this.edgesOutTree.length&&j<new_edges.length)
	{
	  if(this.edgesOutTree[i].equals(e))
	  {
		 System.out.println(this.edgesOutTree[i].from.name+" is being deleted with "+this.edgesOutTree[i].to.name);
		  i++;
	  }
	  else
	  {
		  new_edges[j]=this.edgesOutTree[i];		  
		  i++;
		  j++;
	  }			
	}
	if(isVertexpresent(e.from))
	{
	this.verticesOutTree=deleteVertex(e.from);	
	}
	if(isVertexpresent(e.to))
	{
	this.verticesOutTree=deleteVertex(e.to);
	}
return new_edges;
}

public boolean isTreeEmpty()
{
 if(this.verticesOutTree.length==0)
 {
	 System.out.println("tree is empty");
	 return true;
 }
 return false;
}

public void printEdges()
{
	for(int i=0;i<this.edgesOutTree.length;i++)
	{
		System.out.println(this.edgesOutTree[i].from.name+" "+this.edgesOutTree[i].to.name+" "+this.edgesOutTree[i].weight);
	}
}

public Edge requestEdge(Tree intree)
{
for(int i=0;i<this.edgesOutTree.length;i++)
{
	if(intree.isVertexpresent(this.edgesOutTree[i].from))
	{
		System.out.println("edge "+this.edgesOutTree[i].from.name+" and "+this.edgesOutTree[i].to.name+" is under consideration");
		return this.edgesOutTree[i];
	}
	
}
 return null;
}
}

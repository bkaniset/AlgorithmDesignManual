package DijkstraShortestPath;



public class DikjstraOuttree {
IntreeVertex[] v;
Edge[] edgesOutTree;



 public DikjstraOuttree(AdjacencyList a)
{
	this.v=new IntreeVertex[a.vertices.length];	
	for(int i=0;i<a.vertices.length;i++)
	{
	this.v[i]=new IntreeVertex(a.vertices[i], Integer.MAX_VALUE);
	}
	this.edgesOutTree=new Edge[a.edgecount];
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


public Edge requestEdge(DikjstraIntree intree)
{
	for(int i=0;i<this.edgesOutTree.length;i++)
	{
	Edge e=this.edgesOutTree[i];
	int fromIndex=intree.isVertexpresent(e.from);
	int toIndex=intree.isVertexpresent(e.to);
	if(e.processed==false&&fromIndex>=0&&toIndex<0)
	{
	System.out.println("Returning "+e.from.name+" and "+e.to.name);	
	e.processed=true;
	return e;
	}
	else if(fromIndex>=0&&toIndex>=0)
	{
		intree.updatePath(e, fromIndex, toIndex);
	}	
	}
return null;
}
 

}

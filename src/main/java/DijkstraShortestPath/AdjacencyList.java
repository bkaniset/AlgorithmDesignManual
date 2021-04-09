package DijkstraShortestPath;

public class AdjacencyList {

	Vertex[] vertices;
	EdgeList[] edges; 
	int edgecount;
	
  
public AdjacencyList(int numOfVertices, boolean isDirected)
{
	this.vertices=new Vertex[numOfVertices];
	this.edges=new EdgeList[numOfVertices];
    this.edgecount=0;
}

public void addVertices(Vertex v)
{
	for(int i=0;i<this.vertices.length;i++)
	{
		if(this.vertices[i]==null)
		{
			this.vertices[i]=v;
			this.edges[i]=new EdgeList(v);
			System.out.println("Vertex added at "+i+" in the vertex array and the edges from this vertex are stored at "+this.edges[i].from.name);
		    break;
		}
	}
}

public void insertEdge(Vertex a, Vertex b, int weight)
{
	for(int i=0;i<this.edges.length;i++)
	{
		if(this.edges[i].from.equals(a))
		{
			this.edges[i].insertEdge(b, weight);
			this.edgecount++;
			break;
		}
	}
}



public void printGraph()
{
	for(int i=0;i<this.edges.length;i++)
	{
		int j=0;
		while(this.edges[i]!=null&&j<this.edges[i].insertIndex)
		{
			if(this.edges[i].from!=null&&this.edges[i].to[j]!=null)
			{
			System.out.print(this.edges[i].from.name+"->"+this.edges[i].to[j].v.name+" ");
		}
			j++;
	}
		System.out.println();
}
}

public void PrintGraph(boolean egdeList)
{
 if(true)
 {
	 for(int i=0;i<this.edges.length;i++)
	 {
		 Vertex from=this.edges[i].from;
		 for(int j=0;j<this.edges[i].to.length;j++)
		 {   
			 if(this.edges[i].from!=null&&this.edges[i].to[j]!=null)
			 {
			 System.out.print(from.name+"->"+this.edges[i].to[j].v.name);
		 }
		 }
		 System.out.println();
	 }
 }
	
}

public int checkIfVertexExists(Vertex v)
{
int res=-1;

for(int i=0;i<this.vertices.length;i++)
{
 if(this.vertices[i].equals(v))
 {
	 res=i;
	 System.out.println("Vertex Exists at location "+res+" in the vertices Array");
	 return res;
 }
}
return res;
}

public void deleteEdge(Vertex startNode, Vertex endNode)
{
	System.out.println("Edge "+startNode.name+ " and "+endNode.name);
  
	for(int i=0;i<this.vertices.length;i++)
	{
		EdgeList e=this.edges[i];
		if(e.from.equals(startNode))
		{
		for(int j=0;j<e.insertIndex;j++)
		{
		 if(e.to[j]!=null&&e.to[j].v.equals(endNode))
		 {
			 e.to[j]=null;
			 
		 }
		}	
		}
		else if(e.from.equals(endNode))
		{
		for(int j=0;j<e.insertIndex;j++)
		{
		 if(e.to[j]!=null&&e.to[j].v.equals(startNode))
		 {
			 e.to[j]=null;
			 
		 }
		}	
		}
	}
}

public EdgeList returnEdgeList(Vertex v)
{
for(int i=0;i<this.edges.length;i++)
{
	if(this.edges[i].from.equals(v))
	{
		return this.edges[i];
	}
}
return null;

}

public void printEdges(Vertex v)
{
	for(int i=0;i<this.edges.length;i++)
	{
		if(this.edges[i].from.equals(v))
		{
			for(int j=0;j<this.edges[i].insertIndex;j++)
			{
				System.out.println("THis edge is from "+v.name+" to "+this.edges[i].to[j].v.name+" with weight"+this.edges[i].to[j].weight);
			}
		}
	}	
}
}

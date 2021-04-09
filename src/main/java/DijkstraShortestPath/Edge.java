package DijkstraShortestPath;

public class Edge {

Vertex from; 
Vertex to; 
boolean processed; 
int weight;

public Edge(Vertex from, Vertex to, int weight)
{
	this.from=from;
	this.to=to;
	this.weight=weight;
	this.processed=false;
}

public Edge()
{
	this.from=null;
	this.to=null;
	this.weight=0;
	this.processed=false;
	
}

}

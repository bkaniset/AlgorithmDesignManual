package DijkstraShortestPath;

public class IntreeVertex {

	Vertex v;
	Integer distance;
	
public IntreeVertex(Vertex v, Integer distance)
{
	this.v=v;
	this.distance=distance;
}
	
public IntreeVertex()
{
	this.v=null;
	this.distance=null;
}

}

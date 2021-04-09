package DijkstraShortestPath;


/* Has a bunch of vertices. 
 * Statring vertex has a distance of zero and the algorithm expands from there. 
 * We get the cheapest edge from outtree, and add it to the vertex. 
 *  
 */



public class DijkstraAlgorithm {
DikjstraIntree DT;
DikjstraOuttree DO; 


public DijkstraAlgorithm(AdjacencyList a)
{
this.DT=new DikjstraIntree(a);
this.DO=new DikjstraOuttree(a);	
}

public IntreeVertex[] dijkstraShortestPath(Vertex source)
{
	this.DT.setSource(source);
	int i=0;
	while(i<10&&!this.DT.isPathComplete())
	{   
		for(int j=0;j<this.DT.v.length;j++)
		{
			if(this.DT.v[j]!=null&&this.DT.v[j].v!=null&&this.DT.v[j].distance!=null)
			{
			System.out.println("results right now"+this.DT.v[j].v.name+" "+this.DT.v[j].distance.intValue());
		}
		}
		Edge e=this.DO.requestEdge(DT);	
		DT.insertPath(e);
		for(int j=0;j<this.DT.v.length;j++)
		{
			if(this.DT.v[j]!=null&&this.DT.v[j].v!=null&&this.DT.v[j].distance!=null)
			{
			System.out.println("results right now"+this.DT.v[j].v.name+" "+this.DT.v[j].distance.intValue());
		}
		}
	 i++;
	}
  return DT.v;
}




}

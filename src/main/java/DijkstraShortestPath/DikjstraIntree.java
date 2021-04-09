package DijkstraShortestPath;

import java.util.ArrayList;

public class DikjstraIntree {
IntreeVertex[] v;
int insertIndex;
ArrayList<Edge> dijkstraShotrestPathEdges;


public DikjstraIntree(AdjacencyList a)
{
	this.v=new IntreeVertex[a.vertices.length];
	this.insertIndex=0;
	for(int i=0;i<this.v.length;i++)
	{
		this.v[i]=new IntreeVertex();
	}
	this.dijkstraShotrestPathEdges=new ArrayList<Edge>();
}

public void setSource(Vertex v)
{   	
	this.v[0].v=v;
	this.v[0].distance=0;
	this.insertIndex++;
}

public int isVertexpresent(Vertex v)
{
	int res=-1;
	for(int i=0;i<this.v.length;i++)
	{
		if(this.v[i]!=null&&this.v[i].v!=null&&this.v[i].v.equals(v))
		{
			res=i;
			System.out.println("Vertex persent");
			return res;
		}
	}
	if(res<0)
	{
		System.out.println("Vertex not persent");
	}
return res;	
}


public boolean isPathComplete()
{
	for(int i=0;i<this.v.length;i++)
	{
      if(this.v[i].v==null) 	
      {
    	  return false;
      }
	}		
	return true;	
}

public void insertPath(Edge e)
{
 
  int from=isVertexpresent(e.from);	
   if(from>=0)
   {  
	   System.out.println();
	   this.v[insertIndex].v=e.to;
	   this.v[insertIndex].distance=new Integer(e.weight+ this.v[from].distance.intValue());
	   System.out.println("Path found from source to "+this.v[insertIndex].v.name+" of distance "+this.v[insertIndex].distance);
       this.insertIndex++;
   }  
   this.dijkstraShotrestPathEdges.add(e);
}

public void updatePath(Edge e, int FromIndex, int toIndex)
{
	boolean edgeexists=false;
	for(Edge E: this.dijkstraShotrestPathEdges)
	{
		if(E.equals(e))
		{
			edgeexists=true;
		}		
	}
	if(!edgeexists)
	{
		if(this.v[FromIndex].distance+e.weight<this.v[toIndex].distance)
		{
			this.v[toIndex].distance=this.v[FromIndex].distance+e.weight;
		}
	 deleteEdge( e, toIndex);
	}
	 
}

public void deleteEdge(Edge e, int toIndex)
{
	
}



public int returnDistance(Vertex v)
{
	int index=isVertexpresent(v);
	if(index>0)
	{
		return this.v[index].distance;
	}
	else
	{
		return -1;
	}
}

}

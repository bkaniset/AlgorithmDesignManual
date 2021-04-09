package FloydWorshall;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.zip.Inflater;

public class AdjacencyMatrix {

	Integer[][] graph;
    HashMap<Vertex, Integer> h;
    int tracker;
    int vertexNumber;
	
	
public AdjacencyMatrix(int vertexNumber)
{
	this.graph=new Integer[vertexNumber][vertexNumber];	
	this.h=new HashMap<Vertex, Integer>();	    
	this.tracker=0;
	this.vertexNumber=vertexNumber;
	for(int i=0;i<vertexNumber;i++)
	{
		for(int j=0;j<vertexNumber;j++)
		{
			this.graph[i][j]=new Integer(100);
		}
	}
}

public void addVertex(Vertex a)
{
	this.h.put(a, this.tracker);
	System.out.println("Vertex added with tracker "+a.name+" "+this.tracker);
	this.tracker++;
}

public void insertEdge(Vertex a, Vertex b, int weight)
{
	Integer distance=new Integer(weight);
    int fromIndex=this.h.get(a);
    int toIndex=this.h.get(b);
    graph[fromIndex][toIndex]=distance;
    System.out.println("Edge inserted at "+fromIndex+" and "+toIndex);  
}

public void displayMatrix()
{
	try {
		String infinitySymbol = new String(String.valueOf(Character.toString('\u221E')).getBytes("UTF-8"), "UTF-8");
	
	for(int i=0;i<this.h.size();i++)
	{
		for(int j=0;j<this.h.size();j++)
		{
			if(this.graph[i][j].intValue()==100)
			{
			System.out.print(infinitySymbol);
			}
			else
			{
				System.out.print(this.graph[i][j]+",");	
			}
						
		}
		
		System.out.println();
	}
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public int returnVertexIndex(Vertex v)
{
	return this.h.get(v);
}


}

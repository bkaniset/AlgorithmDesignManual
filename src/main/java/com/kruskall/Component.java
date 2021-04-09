package com.kruskall;

public class Component {
	Edge[] e;
	Vertex[] v;
	int edgeinsertindex;
    int vertexinsertIndex;
    
	public Component()
	{
		this.e=new Edge[2];
		this.v=new Vertex[2];
		this.edgeinsertindex=0;
		this.vertexinsertIndex=0;
		this.e[0]=new Edge();
		this.e[1]=new Edge();
		this.v[0]=new Vertex();
		this.v[1]=new Vertex();
	}

	public void insertEdge(Edge a)
	{
		if(this.edgeinsertindex<this.e.length)
		{
		this.e[this.edgeinsertindex]=a;
		this.insertVertex(a.from);
		this.insertVertex(a.to);
		this.edgeinsertindex++;
		}
		else
		{
			this.e=amortize();
			insertEdge(a);
		}
	}

	public Edge[] amortize()
	{
		Edge[] arr=new Edge[this.e.length+2];
		for(int i=0;i<this.e.length+2;i++)
		{
			if(i<this.edgeinsertindex)
			{
				arr[i]=this.e[i];
			}
			else
			{
				arr[i]=new Edge();
			}
		}
		return arr;
	}
	
	public Vertex[] amortizeVertices()
	{
		Vertex[] arr=new Vertex[this.v.length+2];
		for(int i=0;i<this.e.length+2;i++)
		{
			if(i<this.vertexinsertIndex)
			{
				arr[i]=this.v[i];
			}
			else
			{
				arr[i]=new Vertex();
			}
		}
		return arr;
	}
	
	public void insertVertex(Vertex v)
	{
		if(!this.checkIfVertexExists(v))
		{
		if(this.vertexinsertIndex<this.v.length)
		{
		this.v[this.vertexinsertIndex]=v;		
		this.vertexinsertIndex++;
		}
		else
		{
			this.v=amortizeVertices();
			insertVertex(v);
		}
	}
	}
	
	public boolean checkForCycle(Edge e)
	{
		if(this.checkIfVertexExists(e.to)&&this.checkIfVertexExists(e.from))
		{
			return true;
		}		
		return false;
	}

	public boolean checkIfVertexExists(Vertex v)
	{
		for(int i=0;i<this.vertexinsertIndex;i++)
		{
			if(this.v[i].equals(v))
			{
				return true;
			}
		}
		return false;
	}
	
	public void mergeComponent(Component c)
	{
		System.out.println("Components are merged");
		for(int i=0;i<c.edgeinsertindex;i++)
		{
			System.out.println("Edge "+c.e[i].from.name+" and "+c.e[i].to.name+" ins being inserted");
			this.insertEdge(c.e[i]);
		}
		
	}
	
}

package com.kruskall;

public class DisjointSet {
	Edge[] e;
	DisjointSetVertex v; 
	
	int edgeinsertindex;

	public DisjointSet()
	{
		this.e=new Edge[2];
		this.v=new DisjointSetVertex();		
		this.edgeinsertindex=0;
		this.e[0]=new Edge();
		this.e[1]=new Edge();
	}
	
	public void insertEdge(Edge a)
	{
		if(this.edgeinsertindex<this.e.length)
		{
		this.e[this.edgeinsertindex]=a;
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
	
	
}

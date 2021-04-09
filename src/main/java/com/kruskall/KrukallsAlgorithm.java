package com.kruskall;

public class KrukallsAlgorithm {

AdjacencyList a;
UnionFind u;
OutTree o;

public KrukallsAlgorithm(AdjacencyList a)
{
	this.a=a;
	this.o=new OutTree(a);
    this.u=new UnionFind();
}

public Edge[] KruskallMST()
{
	
	int edgeChecker=0;
	int vertexCount=this.a.vertices.length;
		
	while(edgeChecker<=8&&(!this.u.treeComplete(vertexCount))&&o.edgesOutTree[edgeChecker]!=null)
	{
		System.out.println(this.u.treeComplete(vertexCount));
	 Edge e=o.edgesOutTree[edgeChecker];
	 System.out.println("checking "+e.from.name+" and "+e.to.name);
	 this.u.insertEdge(e); 	
	 edgeChecker++;
	}
    return this.u.c[0].e;    
}

	
}

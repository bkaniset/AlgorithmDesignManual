package com.WeightedGraphs.Prims;


/*
 * 
 * 
*/

public class MSTDemonstration {

	public static void main(String[] args) {
		
		AdjacencyList al=new AdjacencyList(7, false);
		System.out.println(al.vertices.length);
		System.out.println(al.vertices);
		System.out.println(al.edges.length);
		System.out.println(al.edges);
		Vertex a=new Vertex("a");
		Vertex b=new Vertex("b");
		Vertex c=new Vertex("c");
		Vertex d=new Vertex("d");
		Vertex e=new Vertex("e");
		Vertex f=new Vertex("f");	
		Vertex g=new Vertex("g");
		al.addVertices(a);
		al.addVertices(b);
		al.addVertices(c);
		al.addVertices(d);
		al.addVertices(e);
		al.addVertices(f);
		al.addVertices(g);		
		al.insertEdge(a, b, 10);	
		al.insertEdge(a, f, 15);
		al.insertEdge(a, g, 16);
		al.insertEdge(b, f, 20);
		al.insertEdge(b, c, 17);
		al.insertEdge(c, d, 9);
		al.insertEdge(d, e, 6);
		al.insertEdge(e, f, 23);
	
			
         OutTree o=new OutTree(al);
         o.printEdges();
         
         PrimsMinimumSpanningTrees pmst=new PrimsMinimumSpanningTrees(al);
         pmst.PrintPrimsMST(a); 

         
	     
	}
}

/*


*/
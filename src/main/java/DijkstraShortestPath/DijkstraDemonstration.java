package DijkstraShortestPath;



public class DijkstraDemonstration {

	public static void main(String[] args) {
		AdjacencyList al=new AdjacencyList(8, false);
		
		Vertex a=new Vertex("a");
		Vertex b=new Vertex("b");
		Vertex c=new Vertex("c");
		Vertex d=new Vertex("d");
		Vertex e=new Vertex("e");
		Vertex f=new Vertex("f");	
		Vertex g=new Vertex("g");
		Vertex h=new Vertex("h");
		al.addVertices(a);
		al.addVertices(b);
		al.addVertices(c);
		al.addVertices(d);
		al.addVertices(e);
		al.addVertices(f);
		al.addVertices(g);	
		al.addVertices(h);	
		al.insertEdge(a, b, 10);
		al.insertEdge(b, a, 10);
		al.insertEdge(a, f, 15);
		al.insertEdge(f, a, 15);
		al.insertEdge(a, g, 16);
		al.insertEdge(g, a, 16);
		al.insertEdge(b, f, 20);
		al.insertEdge(f, b, 20);
		al.insertEdge(b, c, 17);
		al.insertEdge(c, b, 17);
		al.insertEdge(c, d, 9);
		al.insertEdge(d, c, 9);
		al.insertEdge(d, e, 6);
		al.insertEdge(e, d, 6);
		al.insertEdge(e, f, 23);
		al.insertEdge(f, e, 23);
		al.insertEdge(g, h, 43);
		al.insertEdge(h, g, 43);
		al.insertEdge(f, h, 11);
		al.insertEdge(h, f, 11);
		al.insertEdge(f, e, 23);
		al.insertEdge(e, f, 23);
		System.out.println(al.vertices.length);
		System.out.println(al.edges.length);		
		DijkstraAlgorithm dsp=new DijkstraAlgorithm(al); 
	    IntreeVertex[] v=dsp.dijkstraShortestPath(a);
	    
	    for(int i=0;i<v.length;i++)
	    {
	      System.out.println("Shortest Path from source to "+v[i].v.name+" is of length "+v[i].distance);
	    	
	    }
	}

}

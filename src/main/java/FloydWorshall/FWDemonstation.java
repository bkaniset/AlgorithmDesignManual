package FloydWorshall;


public class FWDemonstation {

	public static void main(String[] args) {
	
		AdjacencyMatrix am=new AdjacencyMatrix(8);
		Vertex a=new Vertex("a");
		Vertex b=new Vertex("b");
		Vertex c=new Vertex("c");
		Vertex d=new Vertex("d");
		Vertex e=new Vertex("e");
		Vertex f=new Vertex("f");	
		Vertex g=new Vertex("g");
		Vertex h=new Vertex("h");
		am.addVertex(a);
		am.addVertex(b);
		am.addVertex(c);
		am.addVertex(d);
		am.addVertex(e);
		am.addVertex(f);
		am.addVertex(g);	
		am.addVertex(h);	
		am.insertEdge(a, b, 10);
		am.insertEdge(b, a, 10);
		am.insertEdge(a, f, 15);
		am.insertEdge(f, a, 15);
		am.insertEdge(a, g, 16);
		am.insertEdge(g, a, 16);
		am.insertEdge(b, f, 20);
		am.insertEdge(f, b, 20);
		am.insertEdge(b, c, 17);
		am.insertEdge(c, b, 17);
		am.insertEdge(c, d, 9);
		am.insertEdge(d, c, 9);
		am.insertEdge(d, e, 6);
		am.insertEdge(e, d, 6);
		am.insertEdge(e, f, 23);
		am.insertEdge(f, e, 23);
		am.insertEdge(g, h, 43);
		am.insertEdge(h, g, 43);
		am.insertEdge(f, h, 11);
		am.insertEdge(h, f, 11);
		am.insertEdge(f, e, 23);
		am.insertEdge(e, f, 23);
	    am.displayMatrix();
	    
	    FloydWorshallAlgorithm fwa=new FloydWorshallAlgorithm(am);
	    fwa.shortestPathPairs();
	    System.out.println("Shortest Paths");
	    fwa.displayMatrix();
	
	
	}
	
}

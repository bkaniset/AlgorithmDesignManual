package ExerciseDataStructures;

public class DepthFirstSearchDemonstation {

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
		al.insertEdge(a, b);	
		al.insertEdge(a, f);
		al.insertEdge(b, a);
		al.insertEdge(b, f);
		al.insertEdge(b, c);
		al.insertEdge(c, b);
		al.insertEdge(c, d);
		al.insertEdge(d, c);
		al.insertEdge(d, e);
		al.insertEdge(e, d);
		al.insertEdge(e, f);
		al.insertEdge(f, a);
		al.insertEdge(f, b);
		al.insertEdge(f, e);	
		al.insertEdge(a, g);
		al.insertEdge(g, a);
		
		 DepthFirstSearch dfs=new DepthFirstSearch(al);
		 dfs.depthFirstSearch(a);
	
	}

}

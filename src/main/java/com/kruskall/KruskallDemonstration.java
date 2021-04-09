package com.kruskall;



public class KruskallDemonstration {

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
		al.insertEdge(a, f, 15);
		al.insertEdge(a, g, 16);
		al.insertEdge(b, f, 20);
		al.insertEdge(b, c, 17);
		al.insertEdge(c, d, 9);
		al.insertEdge(d, e, 6);
		al.insertEdge(e, f, 23);
		al.insertEdge(g, h, 43); 
		al.insertEdge(f, h, 11);
		KrukallsAlgorithm kamst=new KrukallsAlgorithm(al);
		
        Edge[] res=kamst.KruskallMST();
        System.out.println(res.length+" is the result");
        int weightmst=0;
        for(int i=0;i<res.length;i++)
        {
        	if(res[i].from!=null&&res[i].to!=null)
        	{        		
        		System.out.println(res[i].from.name+" "+res[i].to.name);
        		weightmst=weightmst+res[i].weight;
        	}        	
        }
        System.out.println(weightmst);

}
}

package com.kruskall;

public class Edge {

Vertex from; 
Vertex to; 
boolean directed; 
int weight;

public Edge(Vertex from, Vertex to, int weight)
{
	this.from=from;
	this.to=to;
	this.weight=weight;
}

public Edge()
{
	this.from=null;
	this.to=null;
	this.weight=0;
	
}

}

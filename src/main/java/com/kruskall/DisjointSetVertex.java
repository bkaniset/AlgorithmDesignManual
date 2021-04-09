package com.kruskall;

public class DisjointSetVertex {

Vertex v;
Vertex parent;
int rank;
int size;

public DisjointSetVertex()
{
	this.v=null;
	this.parent=null;
	this.rank=0;
	this.size=1;
}


}

package com.WeightedGraphs.Prims;

public class QueueVertex {

Vertex vertex; 
Vertex Parent; 	
boolean isProcessed; 
boolean isDiscovered;
Timer t;


public QueueVertex()
{
this.vertex=null;
this.Parent=null;
this.isDiscovered=false;
this.isProcessed=false;
this.t=new Timer();
}

public QueueVertex(Vertex v)
{
	this.vertex=v;
	this.Parent=null;
	this.isDiscovered=false;
	this.isProcessed=false;
}

public QueueVertex(Vertex a , Vertex b)
{
	this.vertex=a;
	this.Parent=b;
	this.isDiscovered=false;
	this.isProcessed=false;
}

public void insertTime(int i)
{
	this.t.insertTime(i);
}

}

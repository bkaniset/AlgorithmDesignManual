package com.depthfirstsearch;

public class EdgeList {

Vertex from; 
EdgeEnding[] to;
int insertIndex;

public EdgeList(Vertex from)
{
	this.from=from; 
	this.insertIndex=0;
	this.to=new EdgeEnding[2];	 
    this.to[0]=new EdgeEnding();
    this.to[1]=new EdgeEnding();
}



public EdgeEnding[] amortize()
{
	EdgeEnding[] toprime=new EdgeEnding[2*this.to.length];
	for(int i=0;i<2*this.to.length;i++)
	{
	  if(i<this.to.length)
	  {
		toprime[i]=this.to[i];
	  }
	  else
	  {
		  toprime[i]=new EdgeEnding();
	  }
	}
	
	return toprime;
}

public void insertEdge(Vertex b)
{
	if(this.insertIndex==this.to.length-1)
	{
		this.to=this.amortize();
		
		this.to[this.insertIndex]=new EdgeEnding(b);
		this.insertIndex++;
	}
	else
	{
		this.to[this.insertIndex]=new EdgeEnding(b);
		this.insertIndex++;
	}	
}
}

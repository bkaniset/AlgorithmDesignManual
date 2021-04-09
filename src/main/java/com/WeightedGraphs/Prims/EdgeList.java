package com.WeightedGraphs.Prims;

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



public void insertEdge(Vertex b, int weight)
{
	if(this.insertIndex==this.to.length-1)
	{
		this.to=this.amortize();		
		this.to[this.insertIndex]=new EdgeEnding(b, weight);
		quickSort(to, 0, insertIndex);
		this.insertIndex++;
	}
	else
	{
		this.to[this.insertIndex]=new EdgeEnding(b, weight);
		quickSort(to, 0, insertIndex);
		this.insertIndex++;
	}	
}


public void quickSort(EdgeEnding[] to, int low, int high)
{
	if(low<high)
	{
		int pi= partition(to, low , high);
		quickSort(to, low, pi-1);
		quickSort(to, pi+1, high);
	}
}

public int partition(EdgeEnding[] to, int low, int high)
{
	int i=low-1;
	int pivot=to[high].weight;
	for(int j=low;j<high;j++)
	{
		if(to[j].weight<pivot)
		{
			i++;
			EdgeEnding e=to[j];
			to[i]=to[j];
			to[j]=e;
		}
	}
	EdgeEnding temp=to[i+1];
	to[i+1]=to[high];
	to[high]=temp;
	return i+1;
}
}

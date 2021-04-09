package ExerciseDataStructures;

public class Stack {

QueueVertex[] q;	
int poptracker;  /* backtracking becomes important to check for edges when we are in a completely discovered territory*/ 	
int insertIndex;
int clock;

public Stack(AdjacencyList a)
{
	this.q=new QueueVertex[a.vertices.length];
	for(int i=0;i<a.vertices.length;i++)
	{
		this.q[i]=new QueueVertex();
	}
	this.insertIndex=0;
	this.poptracker=-1;
	this.clock=0;
}

public void push(Vertex v1, Vertex v2)
{
	System.out.println(this.insertIndex+" "+this.q.length);
	this.q[insertIndex].vertex=v1;
	this.q[insertIndex].Parent=v2;
	this.q[insertIndex].isDiscovered=true;
	this.q[insertIndex].isProcessed=false;
	this.q[insertIndex].insertTime(clock);
	System.out.println(this.q[insertIndex].vertex.name+ " isbeing pushed onto the stack");
	
	this.poptracker=this.insertIndex-1;	
	this.q[insertIndex].insertTime(clock);	
	System.out.println(this.q[insertIndex].returnTime()+" is the clock");
	this.insertIndex++;
	this.clock++;
}

public void push(Vertex v1)
{
	this.q[insertIndex].vertex=v1;
	this.q[insertIndex].Parent=null;
	this.q[insertIndex].isDiscovered=true;
	this.q[insertIndex].isProcessed=false;
	this.poptracker=this.insertIndex-1;
	this.q[insertIndex].insertTime(clock);	
	System.out.println(this.q[insertIndex].returnTime()+" is the clock");
	this.insertIndex++;
	this.clock++;
}

public boolean isThisVertexStacked(Vertex v)
{ 
  boolean res=false;	
  for(int i=0;i<this.insertIndex;i++)
  {
	  if(this.q[i].vertex!=null&&this.q[i].vertex.equals(v))
	  {
		  System.out.println("Vertex is stacked");
		  return true;
	  }  
  }
  if(!res)
  {
	  System.out.println("Vertex is not stacked");
  }
  return res;
}

public EdgeList getEdgeList(Vertex v, AdjacencyList a)
{
	for(int i=0;i<a.edges.length;i++)
	{
	    if(a.edges[i].from.equals(v))
	    {
	    	return a.edges[i];
	    }
	}	
	return null;
}

public boolean isStackFilled()
{
	boolean res=false;
	int isProcessedcounter=0;
	for(int i=0;i<this.insertIndex;i++)
	{
		if(q[i].isProcessed==true)
		{
		   isProcessedcounter++;
		}
	}
	if(isProcessedcounter==this.q.length)
	{
		System.out.println("Stack is filled");
		res= true;
	}
	else
	{
		System.out.println("Stack is not filled");
	}
 return res;
}



public Vertex pop(int discoveryCount)
{
	Vertex v=null;
if(discoveryCount>0)
{
	v=this.q[poptracker].vertex;
	this.q[poptracker].insertTime(clock);
	this.clock++;
	System.out.println("Moving Forward in the stack");
}
else
{
	System.out.println(this.poptracker+" value of poptracker");
	if(this.poptracker>=0)
	{	
	this.q[poptracker].isProcessed=true;
	this.q[poptracker].insertTime(clock);	
	System.out.println(this.q[poptracker].returnTime()+" is the clock");
	System.out.println("BackTracking and Marking "+this.q[poptracker].vertex.name+" as processed as there are no new edges");
	this.poptracker--;
	this.clock++;
	if(this.poptracker>=0)
	{
	v=this.q[poptracker].vertex;
	}
	}
}
return v;
}

}


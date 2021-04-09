package ExerciseDataStructures;

public class Queue {
	
QueueVertex[] queuevertex;
int insertIndex;
int popIndex;

public Queue(AdjacencyList a)
{
	this.queuevertex=new QueueVertex[a.vertices.length];
	for(int i=0;i<a.vertices.length;i++)
	{
		this.queuevertex[i]=new QueueVertex();
	}
	this.insertIndex=0;
	this.popIndex=0;
}
	


public boolean isThisVertexEnqueued(Vertex v)
{
	boolean res=false;
	for(int i=0;i<this.insertIndex;i++)
	{
		if(this.queuevertex[i].vertex!=null&&this.queuevertex[i].vertex.equals(v))
		{
			System.out.println("Vertex "+this.queuevertex[i].vertex.name+ " is enqueued");
		   return true;
		}
	}	
	if(!res)
	{System.out.println("Vertex "+v.name+ " is not enqueued");	 	
	}
return false;		
}

public void push(Vertex v, Vertex parent)
{
	
	this.queuevertex[insertIndex].vertex=v;
	this.queuevertex[insertIndex].isDiscovered=true;
	this.queuevertex[insertIndex].isProcessed=false;
	this.queuevertex[insertIndex].Parent=parent;
	System.out.println(this.queuevertex[insertIndex].vertex.name+" is discovered and being pushed onto the stack with a parent "+this.queuevertex[insertIndex].Parent.name);
	insertIndex++;
}

public void push(Vertex v)
{
	this.queuevertex[insertIndex].vertex=v;
	this.queuevertex[insertIndex].isDiscovered=true;
	this.queuevertex[insertIndex].isProcessed=false;
	this.queuevertex[insertIndex].Parent=null;
	System.out.println(this.queuevertex[insertIndex].vertex.name+" pushed onto the stack");
	insertIndex++;
}

public QueueVertex queueHead()
{   	 
   return this.queuevertex[popIndex];
}

public void moveHead()
{
	this.popIndex++;
}

public void markProcessed()
{
this.queuevertex[popIndex].isProcessed=true;
System.out.println(this.queuevertex[popIndex].vertex.name+ " is marked processed");
}

public Vertex pop()
{
	moveHead();
	if(this.popIndex<this.queuevertex.length)
	{
	return this.queuevertex[popIndex].vertex;
    }
	else
	{
		return null;
	}
}


public boolean isQueueEmpty()
{
	 boolean res=true;
	 for(int i=0;i<this.queuevertex.length;i++)
	  {
		 if(this.queuevertex[i].isProcessed==false)
		 {
				 System.out.println(this.queuevertex[i].vertex.name+" is next to be processed");
				 return false;	 
			 
			 
		 }
	 }
	 if(res)
	 {
		 System.out.println("Queue is empty");
	 }
   return res;
}


}

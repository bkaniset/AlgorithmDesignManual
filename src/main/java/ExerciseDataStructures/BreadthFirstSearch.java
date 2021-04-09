package ExerciseDataStructures;

public class BreadthFirstSearch {

AdjacencyList a; 	
Queue q; 

public BreadthFirstSearch(AdjacencyList a)
{
	this.a=a;
	this.q=new Queue(a);
}


public QueueVertex[] breadthFirstSearch(Vertex startNode)
{
	int jumpingoffPoint=a.checkIfVertexExists(startNode);
   if(jumpingoffPoint<0)
   {
	   System.out.println("Vertex doesnt exist in the graph");
	   return null;
   }
   else
   { 
	   if(!(q.isThisVertexEnqueued(startNode)))
	   {   
	   q.push(startNode);
	 
	   }
	   while(!q.isQueueEmpty())
	   {
          for(int i=0;i<a.vertices.length;i++)
          {
        	  if(a.edges[i]!=null)
        	  {
        	  if(a.edges[i].from.equals(startNode))
        	  {
        		  
        		  for(int j=0;j<a.edges[i].to.length;j++)
        		  {
        			    
        			  if(a.edges[i].to[j].v!=null&&!(q.isThisVertexEnqueued(a.edges[i].to[j].v)))
        			  {
        		       
        				  q.push(a.edges[i].to[j].v, startNode);
        			  }
        	      }
        	  }  
        	  }  
          }
          q.markProcessed();
          startNode=q.pop();
	   }
   }
   return this.q.queuevertex;

}



public void shortestPath(Vertex v1, Vertex v2)
{
	
/*  get the BFS stack from v1.  
 *  
 */
QueueVertex[] bfspath=this.breadthFirstSearch(v1);
QueueVertex end=null;
int i=bfspath.length-1;
while(i>0&end==null)	
{	
	if(bfspath[i].vertex.equals(v2))
	 {
		 end=bfspath[i];
	 }
	i--;
}
System.out.print("Starting from "+end.vertex.name + "-> ");
while(i>=0)
{
	if(end.Parent.equals(bfspath[i].vertex)) 	
  {
	if(i==0)
	{
	System.out.print(bfspath[i].vertex.name+" is the shortest path"); 
	
	}
	else
	{
	 System.out.print(bfspath[i].vertex.name+" ->");
	 end=bfspath[i];
	}
  }
	i--;	
}
}
}
	

	


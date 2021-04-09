package ExerciseDataStructures;

public class DepthFirstSearch {

AdjacencyList a;	
Stack s;	


public DepthFirstSearch(AdjacencyList a)
{
	this.a=a;
	this.s=new Stack(a);
}

/* Algorithm: 
 * 1) add start node to the stack.  
 * 2) get next vertex from the adjacencylist. 
 * 3) get the edgelist of that vertex. 
 * 4) repeat step 3.  
 * If- we reach a point where there are no new vertices to be discovered, and stack is not filled. 
 * backtrack through the edgelist array. 
 */

public void depthFirstSearch(Vertex startNode)
{
   int jumpingOffPoint=a.checkIfVertexExists(startNode);
   if(jumpingOffPoint<0)
   {
	   System.out.println("Vertex is not in the graph");
	   return;
   }
   else
   {
	   
	  if(!s.isThisVertexStacked(startNode))
	  {
		  s.push(startNode);
	  }
	  while(!s.isStackFilled())
	  { 
		  
		int discoveryCount=0;
		
		outer :for(int i=0;i<this.a.edges.length;i++)	    
		{	 
			if(startNode.equals(this.a.edges[i].from))
			{
				EdgeList e=this.a.edges[i];
			    inner :for(int j=0;j<e.insertIndex;j++)
				{
					if((e.to[j].v!=null)&&(!(s.isThisVertexStacked(e.to[j].v))))
					{
						s.push(e.to[j].v, startNode);
						discoveryCount++;
	            		System.out.println(e.to[j].v.name+ " is stacked with parent "+ startNode.name);
	            		break inner; 
					}
				}
				break outer;
			}
		
		}
		startNode=s.pop(discoveryCount);
	  }	   
   }


}



}

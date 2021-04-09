package com.kdTress.Test;

/* This class exposes the following functionality. 
 * 1) Insert point p into the tree.  Completed. 
 * 2) Find minimum in dimension D- Code is wrong. 
 * 3) Delete- To be done.   
 * 4) Search- Similar to insert.  
 * 5) Nearest neighbors at distance "d" is range search or range search for a range r- Working on this.
 * 6) Print kdTree- Similar to BST.  
 *  
 */


public class KdTrees {

Node root; 	
	
class Node 
{
	int[] x; 
	int cd;
	Node left;
	Node right;
	
public Node(int a, int b)
{
	this.x=new int[2];
	this.x[0]=a;
	this.x[1]=b;    
	this.cd=0;
	this.left=null;
	this.right=null;
}
}

/* Below function would not work in Java. Rethink and implement. 
 *  We only have two dimensions, so at each level, we need to change the comparative dimension. 
 *  
 * 
 */

public void insertIntoTree(Node n)
{
	int cd=0;
	if(this.root==null)
	{
		this.root=n;
		this.root.cd=cd;
		System.out.println("Root inserted "+this.root.x[0]+" and "+this.root.x[1]+" compare dimension "+this.root.cd);
	}
	else
	{
		Node treenode=this.root;
		while(treenode!=null)
		{
			
		   if(treenode.x[cd%2]<n.x[cd%2])
		    {
			if(treenode.right!=null)
			{
				cd++;
				treenode=treenode.right;			
			}
			else
			{
				cd++;
				n.cd=cd%2;
				treenode.right=n;
				System.out.println(n.x[0]+" and "+n.x[1]+" is inserted as a right node to "+treenode.x[0]+" and "+treenode.x[1]+" and compare dimension is "+n.cd);
				break;
			}
		}
		else
		{   
		    if(treenode.left!=null)
		    {
		    	cd++;
		    	treenode=treenode.left;		    	
		    }
		    else
		    {
		    	cd++;
		    	n.cd=cd%2;
		    	treenode.left=n;
		    	System.out.println(n.x[0]+" and "+n.x[1]+" is inserted as a left node to "+treenode.x[0]+" and "+treenode.x[1]+"and compare dimenson is "+n.cd);
		    	break;
		    }			  
		}	
		}		
	}	
}

/* It is expected that the node n is root node. 
 * This function can also be customized to run on any node, but 
 * we need to extend this kdtree class to; 
 * A. compare dimension(cd) to be a member of class node, to be assigned during insertion. 
 * 
 */

public Node findMinimum(Node n, int dimension)
{
	if(n==null)
	{
		return null;
	}
	else
	{      
		if(dimension==n.cd)
		{
			System.out.println("Same dimension comparision");
			if(n.left==null)
			{
				System.out.println("Current node is the least");
				return n;
			}
			else
			{
				
				return findMinimum(n.left, dimension);
			}
		}
		else 
		{
			
		 return minNode(findMinimum(n.left, dimension), findMinimum(n.right, dimension), n ,  dimension);
		}		
	}	
}


public Node searchInTree(Node n)
{
   if(this.root==n)
   {
	   System.out.println("Hail caesar");
	   return this.root;
   }
   else
   {
	   Node treenode=this.root;
	   while(treenode!=null)
	   {
		   if(treenode.x[0]==n.x[0]&&treenode.x[1]==n.x[1])
		   {
			   
			   System.out.println("I am your lord thy god, YHWH, the god of israel");
			   return treenode;
		   }
		   else if(treenode.x[treenode.cd]>n.x[treenode.cd])
		   {
			   if(treenode.left!=null)
			   {
				   treenode=treenode.left;
			   }
			   else
			   {
				   
				   System.out.println("Node Doesnt exist");
			       break;
			   }
		   }
		   else
		   {
			   if(treenode.right!=null)
			   {
				   treenode=treenode.right;
			   }
			   else
			   {
				   System.out.println("Node Doesnt exist");
				   break;
			   }
			   
		   }
		   
	   }
   }
	
	
return null;	
}






/* We need to figure out the minimum of three integers 
 * and return it. 
 */


public Node minNode(Node A, Node B, Node C, int dimension)
{   
	if(B==null&&C==null)
	{
		return A;
	}
	else if(A==null&&C==null)
	{
		return B;
	}
	else if(A==null&&B==null)
	{
		return C;
	}
	else if(A==null)
	{
		if(B.x[dimension]<C.x[dimension])
		{
			return B;
		}
		else
		{
			return C;
		}
	}
	else if(B==null)
	{
		if(A.x[dimension]<C.x[dimension])
		{
			return A;
		}
		else
		{
			return C;
		}
	}
	else if(C==null)
	{
		if(B.x[dimension]<A.x[dimension])
		{
			return B;
		}
		else
		{
			return A;
		}
	}
	else
	{
	int a=A.x[dimension];
	int b=B.x[dimension];
	int c=C.x[dimension];
    Node res=null;
    if(a<b)
    {
    	res=A;
    }
    else
    {
    	res=B;
    }
    if(res.x[dimension]<c)
    {
    	return res;
    }
    else
    {
    	return C;
    }
	}
	}

/* Distance d is euclidean distance. Works similar to search but has a few caveats. 
 * 1) Need to check for exit cases.  
 * 2) Visualization would help. 
 * https://opendsa-server.cs.vt.edu/ODSA/Books/CS3/html/KDtree.html
 * It is understood that treeNode is the root initially. 
 * 
 */


public void rangeSearch(Node treeNode, Node n, float distance)
{
if(treeNode==null)
{
	System.out.println("tree is empty");
	return ;
}
else
{
	if(returnDistance(treeNode, n)<distance)
	{
		System.out.println("point "+treeNode.x[0]+" and "+treeNode.x[1]+" is in range");
		rangeSearch(treeNode.left, n, distance);
		rangeSearch(treeNode.right, n, distance);
	}
	else if(Math.abs(treeNode.x[treeNode.cd]-n.x[treeNode.cd])<distance)
	{
		System.out.println("point "+treeNode.x[0]+" and "+treeNode.x[1]+" is NOT in range");
		rangeSearch(treeNode.left, n, distance);
		rangeSearch(treeNode.right, n, distance);	
	}
	else if(treeNode.x[treeNode.cd]>n.x[treeNode.cd])
	{
		System.out.println("point "+treeNode.x[0]+" and "+treeNode.x[1]+" is NOT in range");
		rangeSearch(treeNode.left, n, distance);
	}
	else if(treeNode.x[treeNode.cd]<n.x[treeNode.cd])
	{
		System.out.println("point "+treeNode.x[0]+" and "+treeNode.x[1]+" is NOT in range");
		rangeSearch(treeNode.right, n, distance);
	}
}
	
	
	
}

/* Similar to deletion in BST, but. 
 * N needs to be replaced by its discriminator's lowest in its right subtree 
 * or its discriminator's highest in left subtree. 
 *
 */


public void deleteNode(Node n)
{
 Node deletable=searchInTree(n);
  if(deletable.right==null&&deletable.left==null)
  {
	  deletable=null;	  
	  return;
  }
  else if(deletable.right!=null&&deletable.left==null)
  {
	  Node temp=findMinimum(deletable.right, deletable.cd);
	  deletable=temp;
	  deleteNode(findMinimum(deletable.right, deletable.cd));
  }
  
}

 /* This function sets Node A to null. 
  * Use Only after search.  
  */

public void replace(Node n)
{
	if(this.root==n)
	{
		this.root=null;
	}
	else 
	{
		Node treenode=this.root;
		while(treenode!=null)
		{
			if(treenode.x[0]==n.x[0]&&treenode.x[1]==n.x[1])
			   {
				   
				   System.out.println("Node set to null");
				   treenode=null;
			   }
			   else if(treenode.x[treenode.cd]>n.x[treenode.cd])
			   {
				   if(treenode.left!=null)
				   {
					   treenode=treenode.left;
				   }
				   else
				   {
					   
					   System.out.println("Node Doesnt exist");
				       break;
				   }
			   }
			   else
			   {
				   if(treenode.right!=null)
				   {
					   treenode=treenode.right;
				   }
				   else
				   {
					   System.out.println("Node Doesnt exist");
					   break;
				   }
				   
			   }
			
		}
	}	
}


public float returnDistance(Node a, Node b)
{
	float xaxis= a.x[0]-b.x[0];
	float yaxis=a.x[1]-b.x[1];
	return (float) Math.sqrt(xaxis*xaxis+yaxis*yaxis);
}

public void printKdtree(Node n)
{
    if(n.left!=null)
    {
	printKdtree(n.left);
    }
	if(n!=null)
	{
	System.out.println(n.x[0]+" and "+n.x[1]);
	}
	if(n.right!=null)
	{
	printKdtree(n.right);
    }
}


public Node findMaximum(Node n, int dimension)
{	
   if(n==null)
   {
	   System.out.println("tree is empty");
	   return null;
   }
   else
   {
	   
	   if(n.cd==dimension)
	   {
		   if(n.right==null)
		   {
			   return n;
		   }
		   else
		   {
			   return findMaximum(n.right, dimension);
		   }  		   
	   }
	   else
	   {
		   return findMax(findMaximum(n.left, dimension), findMaximum(n.right, dimension), n, dimension);
	   }
   }	
}

public Node findMax(Node A, Node B, Node C, int dimension)
{
	if(A==null&&B==null)
	{
		return C;
	}
	else if(B==null&&C==null)
	{
		return A;
	}
	else if(A==null&&C==null)
	{
		return C;
	}
	else if(A==null)
	{
		if(B.x[dimension]>C.x[dimension])
		{
			return B;
		}
		else
		{
			return C;
		}
	}
	else if(B==null)
	{
		if(A.x[dimension]>C.x[dimension])
		{
			return A;
		}
		else
		{
			return C;
		}
	}
	else if(C==null)
	{
		if(A.x[dimension]>B.x[dimension])
		{
			return A;
		}
		else
		{
			return B;
		}
	}
	else
	{
	   int a=A.x[dimension];
	   int b=B.x[dimension];
	   int c=C.x[dimension];
	   Node res=null;
	  
	   if(a>b)
	   {
		   res=A;
	   }
	   else
	   {
		   res=B;
	   }
	   if(res.x[dimension]>c)
	   {
		   return res;
	   }
	   else
	   {
		   return C;
	   }		  
	}
}


}
	
	
	
	


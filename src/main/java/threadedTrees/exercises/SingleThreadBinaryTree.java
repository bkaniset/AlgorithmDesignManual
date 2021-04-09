package threadedTrees.exercises;

public class SingleThreadBinaryTree {
Node root; 

public class Node
{
	int data; 
	Node right, left, parent;
	boolean isrightChild;

public Node()
{
	this.data=(Integer) null;
	this.right=this.left=this.parent=null;
	this.isrightChild=false;
}

public Node(int i)
{
	this.data=i;
	this.right=this.left=this.parent=null;
	this.isrightChild=false;
}
}
/*
 *  Insert Into tree 
 *   Go through the tree. 
 *   go left or right depending on the check. 
 *   Pay special attention to isrightChild.   
 */

public void insertIntoTree(Node n)
{
	if(this.root==null)
	{
		this.root=n;
		this.root.isrightChild=false;
		System.out.println("Root Node inserted");
	}
	Node current=this.root;
	while(current!=null)
	{
		 if(n.data<current.data)
		 {
			 if(current.left!=null)
			 {
				 current=current.left;
			 }
			 else
			 {
				 System.out.println("Node inserted as left node");
				 current.left=n;
				 n.isrightChild=false;
				 n.right=current;
				 n.left=null;
				 break;
			 }
		 }
		 else
		 {
			 if(current.isrightChild!=false)
			 {
				 current=current.right;
			 }
			 else
			 {
				  /*  Two conditions to be satisified here 
				   *  1) Maximum element where is rightchild is false, but there is no inorder successor. 
				   *  2) 
				   */
				 System.out.println("Node inserted as right node");
				 Node temp=current.right;
				 current.right=n;
				 current.isrightChild=true;
				 n.right=temp;
				 n.isrightChild=false;
			    break;
			 }
		 }
	}	
}

/* 
 *  use isrightChild to work with this.
 * 
 */

public boolean searchInTree(Node n)
{
	return true;
}

public void deleteInTree(Node n)
{
	
}

public Node findSuccessor(Node n)
{
	Node res=null;
	if(n.right!=null)
	{
		res= findMinimum(n);
	}
	else
	{
		Node p=n.parent; 
		System.out.println(p.isrightChild+" "+n.data);
		while(n==p.right)
		{
			if(p.parent==null)
			{
				System.out.println("Node is current maximum");
				return null;
			}
			p=p.parent;
			n=p;
		
		}
		return p;
	}
	return res;
}

public Node findMinimum(Node n)
{
	if(n.left!=null)
	{
		n=n.left;
	}
	return n;
}

public void inorderTraversal()
{
	
	Node n=this.findMinimum();
   	
   while(n!=null)
   {
	   System.out.print(n.data+" ");
	   if(n.isrightChild==true)
	   {
		   n=findMinimum(n.right);
	   }
	   else
	   {
		   n=n.right;
	   }
   }
}

public Node findMinimum()
{
	Node n=this.root;
	while(n.left!=null)
	{
		n=n.left;
	}
	return n;	
}

}











	
	
	
	
	
	


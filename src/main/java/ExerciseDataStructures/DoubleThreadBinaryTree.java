package ExerciseDataStructures;

/* In this implementation of a double threaded binary tree;   
 * node.left points to 
 * a) A child element when present, or. 
 * b) A inorder predecessor when child is not present. 
 * this logic is operated using isLeftChild boolean variable. 
 * isLeftChild is true with node.left is its left child and false if; 
 * 1) The element has no in order predecessor(Minimum element in the tree). 
 * 2) node.left points to its in order predecessor. 
 * 
 * node.right points to
 * a) A child element when present. 
 * b) An inorder successor when child is not present. 
 * this logic is operated using isRightChild boolean variable. 
 * isRightChild is true when node.right points is its right child and false if; 
 * 1) The element has no in order successor(Maximum element in the tree). 
 * 2) node.right points to the in order successor. 
 * 
 * Three operations have been defined here. 
 * 1) insert. 
 * 2) In order traversal.   
 * 3) post order traversal. 
 * 
 *  Do this after the java project 
 *  
 *  
 */




public class DoubleThreadBinaryTree {
	
Node root; 	
	
public DoubleThreadBinaryTree(Node n)
{
	this.root=n;
}

public DoubleThreadBinaryTree()
{
	this.root=null;
}

class Node 
{
	
int data; 
Node left; 
Node right; 
boolean isRightChild;
boolean isLeftChild; 

public Node(int i)
{
	this.data=i;
	this.left=null;
    this.right=null;
    this.isLeftChild=false;
    this.isRightChild=false;
}
public Node()
{
	this.data=(Integer) null;
	this.left=null;
    this.right=null;
    this.isLeftChild=false;
    this.isRightChild=false;
}
}
	
public void insertIntoTree(Node n)
{
	if(this.root==null)
	{
		this.root=n;
		System.out.println("Root node inserted");
	}
	else
	{
		Node current=this.root;
		
		while(current!=null)
		{
			if(n.data<current.data)
			{
				if(current.isLeftChild==true)
				{
					current=current.left;
				}
				else
				{
					Node temp=current.left;
					current.left=n;
					n.left=temp;
					n.isLeftChild=false;
					current.isLeftChild=true;
					n.isRightChild=false;
					n.right=current;
					System.out.println(n.data+" has been inserted as a left child of "+current.data);
				   break;
				}
			}
			else
			{
				if(current.isRightChild==true)
				{
					current=current.right;
				}
				else
				{
					Node temp=current.right;
					current.right=n;
					current.isRightChild=true;
					n.right=temp;
					n.isRightChild=false;
					n.isLeftChild=false;
					n.left=current;
					System.out.println(n.data+" has been inserted as a right child of "+current.data);
					break;
				}
			}
		}
	}
}


/* Traverse the tree from min to max*/

public void inOrderTraversal()
{
	Node n=this.findMinimum();
    while(n.right!=null)
    {
    	System.out.print(n.data+" ");
    	if(n.isRightChild==true)
    	{
    		n=findMinimum(n.right);
    	}
    	else
    	{
    		n=n.right;
    	}
    	
    }
	

}

/* Traverse the tree from max to min, decreasing order*/

public void postOrderTraversal()
{
	
}

public Node findMinimum()
{
	Node n=this.root;
	while(n.left!=null)
	{
		n=n.left;
	}
	System.out.println(n.data);
	return n;
}

public Node findMinimum(Node n)
{
	while(n.left!=null)
	{
		n=n.left;
	}
	return n;
}


public Node findMaximum()
{
	Node n=this.root; 
	while(n.right!=null)
	{
		n=n.right;
	}
	return n;
}


}

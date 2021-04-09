package ExerciseDataStructures;

/* Implement all functions in the dictionary using a single linked list. 
 * 1) Insert- done. 
 * 2) Search- done.  
 * 3) Delete- to do. 
 * 4) Maximum- Done.  
 * 5) Minimum- Done.  
 * 6) Successor of a Node-  Done.   
 * 7) Predecessor of a Node-  Done.  
 * 8) Print Tree- Done. 
 * 9) Compare two Binary Trees. Done, need to do with traversal. 
 * 10) Turn a binary tree into a linked List.
 * 11) Treverse the binary tree and return the ith element.  
 */


public class BinaryTree {

	Node root; 
	int size;
	
	public BinaryTree()
	{
		this.root=null;
		System.out.println("Tree created");
	}
	
	public BinaryTree(Node node)
	{
		root=node;
		size++;
	}
	
	public class Node
	{
		int data;
		Node parent;
		Node right;
		Node left;
	
	public Node()
	{
		this.data=(Integer) null;
		this.parent=null;
		this.left=null;
		this.right=null;
	}
	
	public Node(int i)
	{
		this.data=i;
		this.parent=null;
		this.left=null;
		this.right=null;
	}
	}
	
	public void insertIntoTree(Node n)
	{
		if(this.root==null)
		{
			this.root=n;
			System.out.println("root node inserted");
			size++;
		}
		else
		{
		Node node=this.root;			
		while(node!=null)
		{
			if(n.data<node.data)
			{
				if(node.left!=null)
				{
					node=node.left;
				}
				else
				{
					node.left=n;
					n.parent=node;
					n.left=null;
					n.right=null;
					System.out.println(n.data+"Node inserted as left child of "+n.parent.data);
					size++;
					break;
				}
				
			}
			else 
			{
				if(node.right!=null)
				{
				   node=node.right;	
				}
				else
				{
					node.right=n;
					n.parent=node;
					n.left=null;
					n.right=null;
					System.out.println(n.data+"Node inserted as right child of "+n.parent.data);
					size++;
					break;
				}
			}

		}
		}
	}

public Node findMinimum()
{
	Node node=this.root;
	while(node.left!=null)
	{
		node=node.left;
	}
	return node;
}

public Node findMaximum()
{
	Node node=this.root;
	while(node.right!=null)
	{
		node=node.right;
	}
	return node;
}

public void printTree(Node n)
{
	if(n!=null)
	{
    printTree(n.left);
    System.out.print(" "+n.data);
	printTree(n.right);
	}
}

public boolean searchInList(Node n)
{
	boolean isPresent=false;
	if(this.root==null)
	{
		return false;
	}
	else
	{ 
		Node checker=this.root;
		while(checker!=null)
		{
			if(n.data==checker.data)
			{
				isPresent=true;
				return isPresent;
			}
			else if(n.data<checker.data)
			{
				checker=checker.left;
			}
			else
			{
				checker=checker.right;
			}
	
		}
	}
return isPresent;
}

public Node findMinimum(Node n)
{
	while(n.left!=null)
	{
		n=n.left;
	}
	return n;
}

public Node findMaximum(Node n)
{
	while(n.right!=null)
	{
		n=n.right;
	}
	return n;
}


public Node findSuccessor(Node n)
{
	if(n.equals(this.findMaximum()))
	{
		return null;
	}
	if(n.right!=null)
    {
    	return findMinimum(n.right);
    }
    else
    {	
    	Node p=n.parent;
    	while(n==p.right)
    	{
    		n=p;
    		p=p.parent;
    	}
    	return p; 	    
    }
	
}

public Node findPredecessor(Node n)
{
	if(n.equals(this.findMinimum()))
	{
		return null;
	}
	if(n.left!=null)
	{
		return findMaximum(n.left);
	}
	else
	{
		Node p=n.parent;
		while(n==p.left)
		{
			n=p;
			p=p.parent;
		}
	 return p;
	}
}

public boolean checkEquality(BinaryTree bt2)
{
	boolean res=true;
	if(this.size!=bt2.size)
	{
		return false;
	}
	Node bt1_node=this.findMinimum();
	Node bt2_node=bt2.findMinimum();
	while(!(bt1_node.equals(bt2_node)))
	{
		res=false;
		System.out.println(bt1_node.data+"is differenet than"+bt2_node.data);
		return res;
	}
	return res;
}

/*
 *  Need to think about this. 
 */
public boolean checkEqualityWithTraversal(BinaryTree bt2)
{
	return false; 
}


/*
 *  This function creates a list out of a tree. 
 *   
 * 
 * 
 */

public void printTreeUsingMinimumAndSuccessor()
{
	Node n=this.findMinimum();
	while(n!=null)
	{
		System.out.println(n.data);
		n=this.findSuccessor(n);
	}
}


public SingleLinkedList returnListFromTree(SingleLinkedList l)
{
  Node n=this.findMinimum();
 
	while(n!=null)
	{                                                        /* Create a List Node from the tree node */
	l.insertList(n.data);	                                                  /* Find the successor of the tree node  */
	n=this.findSuccessor(n);	                                                  /* Add the successor of the tree node to the list */  
	if(n==null)
	{
		break;
	}
	                                                             /* loop propogation */ 
	}
	return l;
}


public void returnNthNumber(int n)
{
	
int[] stack=new int[10];
int[] keyStore=new int[10];
int insertIndex=0;
int poptracker=0; 



}

public void amortizer(int[] arr, int insertindex)
{
int[] new_arr=new int[2*arr.length];	
for()

}


}

/* n=this.findSuccessor(n);
		SingleLinkedList.Node successor=l.new Node(this.findSuccessor(n).data);	
		listnode.next=successor;
		 
 * 
 * 
 * Node n=this.findMinimum();
 * SLL.Node n2=null;
 * while(n!=null)
 * {
 *  SLL.Node new_node=l.new Node(n.successor.data);
 *  n2.next= new_node;
 *  
 * }
 */


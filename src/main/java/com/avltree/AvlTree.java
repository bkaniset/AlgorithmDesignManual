package com.avltree;

/* AVL tree is a self balancing binary search tree. 
 * we add an additional data point to the binary search tree as height,  
 * and based on the height, we run the self balancing code, as denoted in 
 * the function reorganize. 
 */

public class AvlTree {

Node root; 	
	
class Node
{
	String str;
	Node left; 
	Node right; 
	Node Parent; 
    int balanceFactor; 
    
    
public Node(String str)
{
   this.str=str;
   this.left=null;
   this.right=null;
   this.Parent=null;
   this.balanceFactor=0;
}

public Node()
{
	this.str=null;
	   this.left=null;
	   this.right=null;
	   this.Parent=null;
	   this.balanceFactor=0;	
}
	
}

public AvlTree(String str)
{
	this.root=new Node(str);
	
}

public AvlTree()
{
	this.root=null;
}

public void insertIntoTree(String str)
{
	
 if(this.root==null)
 {
	 this.root=new Node(str);
	 System.out.println("root inserted");
 }
 else
 {
	Node n=this.root;
	 
		while(n!=null)
		{
			if(str.compareTo(n.str)<0)
			{
				if(n.left!=null)
				{
					n=n.left;
				}
				else
				{
					Node new_node=new Node(str);
					n.left=new_node;
					new_node.Parent=n;
					new_node.balanceFactor=0;
					System.out.println(str+" inserted as a left child to "+n.str);
					while(n!=null)
					{
						n.balanceFactor=setBalanceFactor(n);
						System.out.println(n.balanceFactor);
						if(n.balanceFactor<-1||n.balanceFactor>1)
						{
							reOrganize(n, new_node);
							n=n;
						}
						else
						{
						n=n.Parent;
						}
					}
					break;
				}
			}
			else
			{
				if(n.right!=null)
				{
					n=n.right;
				}
				else
				{
					Node new_node=new Node(str);
					n.right=new_node;
					new_node.Parent=n;
					new_node.balanceFactor=0;
					System.out.println(str+" inserted as a right child to "+n.str);
					while(n!=null)
					{
						n.balanceFactor=setBalanceFactor(n);
						if(n.balanceFactor<-1||n.balanceFactor>1)
						{
							reOrganize(n ,new_node);
							n=n;
						}
						else
						{
						n=n.Parent;
						}
						
					}
					break;
				}
			}
			
		}
         
		/*  We need code for reorganize here. 
		 * 
		 */ 
 }
}
	
/* this function contains code for reorganizing after every insertion. 
 * Handle these four cases;  
 * 1) Left Left
 * 2) Left Right
 * 3) Right Right. 
 * 4) Right Left. 
 * The function needs to decide which of the above 4 cases to perform depending on 
 * the balance factor. 
 * It is defined as height of left subtree-height of the right subtree at a node.
 */


public int setBalanceFactor(Node n)
{	
int h_left=0; 
int h_right=0; 
if(n.right==null)
{
	h_right=0;
}
else if(n.right!=null)
{
	System.out.println("evaulating right node");
	h_right=Math.abs(n.right.balanceFactor)+1;
	
}
if(n.left==null)
{
	h_left=0;
}
else if(n.left!=null)
{
	System.out.println("evaulating left node");
	h_left=n.left.balanceFactor+1;
}
return h_left-h_right;
}


/* node is where balance factor is either <-1 or >1 and n2 is the newly inserted node. 
 * Case 1: left left  n1.left==n2.parent&&n2.parent.left==n2 Right rotate. 
 * Case 2: left right n1.left=n2.parent&&n2parent.right==n2 
 * Case 3: Right left n1.right=n2.parent&&n2.parent.left=n2 
 * Case 4: Right Right n1.right==n2.parent&&n2.parent.right==n2  left rotate
 */

public void reOrganize(Node node, Node new_node)
{

	
	
	
	
	
}

public void rightRotation(Node n)
{
	Node temp1=n; 
	Node temp2=n.left;
	Node temp3=n.left.right; 
	n=temp2;
	n.right=temp2;
	n.right.left=temp3;	
}

public void leftRotation(Node n)
{
Node temp1 = n;
Node temp2 = n.right;
Node temp3 = n.right.left;	
n=temp2;
n.left=temp1;
n.left.right=temp3;	
}
}

package BinaryTreeNthItem;

public class BinaryTree {
	
Node root;
Node minimum;
Node[] PushandPopstack;
Node[] Processstack;
int pushandPopIndex;
int processIndex; 

public BinaryTree()
{
	this.root=null;
	this.minimum=null;
	this.PushandPopstack=new Node[10];
	this.Processstack=new Node[10];
	for(int i=0;i<10;i++)
	{
		this.Processstack[i]=new Node();
		this.PushandPopstack[i]=new Node();
	}
	this.pushandPopIndex=0;
	this.processIndex=0;
}

public Node[] amortize(Node[] arr, int index)
{
	Node[] new_arr=new Node[2*arr.length];
    
    for(int i=0;i<2*arr.length;i++)
    {
    	if(i<index)
    	{
    		new_arr[i]=arr[i];
    	}
    	else
    	{
    		new_arr[i]=new Node();
    	}
    }
return new_arr;
}



class Node
{
int data;
Node parent;
Node left;
Node right;

public Node(int data)
{
	this.data=data;
	this.parent=null;
	this.left=null;
	this.right=null;
}

public Node()
{
	this.data=-1;
	this.parent=null;
	this.left=null;
	this.right=null;
}
}

public void insert(Node n)
{
	if(this.root==null)
	{
		this.root=n;
	    this.minimum=n;	
	}
	else
	{
	  Node node=this.root;			
		while(node!=null)
		{
			if(node.data<n.data)
			{
				if(node.right!=null)
				{
					node=node.right;
				}
				else
				{
					node.right=n;
					n.parent=node;
				}
			}
			else
			{
				if(node.left!=null)
				{
					node=node.left;
				}
				else
				{
					node.left=n;
					n.parent=node;
				}				
			}
		}
		if(node.data<this.minimum.data)
		{
			this.minimum=node;
		}
	}
}

/* This is a function to return the first I numbers in sorted order from a binary tree. 
 * We have a pointer to the minimum node of the tree, and we do a DFS from there. 
 * After this, 
 * If we just need i'th number, we would not need two stacks, one would be fine. 
 * 
 * A Lot of refinement is required on this. Work on this please. 
 */

public Node findIthNumber(int k)
{
	Node n=this.minimum;
	int insertcount=0;
	push(n);
	while(!isStackEmpty())
	{	
	if(n.right==null&&n.left==null)
	{
	push(n.parent);		
	break;
	}
	else if(n.left!=null&&(!isElementStacked(n.left)))
	{
		push(n.left);
	}
	else if(isElementStacked(n.left)&&n.right!=null&&isElementStacked(n.right))
	{
		push(n.left);
	}
	else if(n.left==null&&n.right==null&&isElementStacked(n.parent))
	{
		k--;
	}
	n=pop();     
}
}

public boolean isStackEmpty()
{
if(this.pushandPopIndex!=0)
{
	return true;
}
return false;		
}


/* Below two functions are misguided. 
 * Push- should push to both stacks. 
 * pop-should remove from the first stack but still keep it on the second stack. 
 * 
 */



public boolean isElementStacked(Node n)
{
	for(int i=0;i<this.processIndex;i++)
	{
		if(this.Processstack[this.processIndex]==n)
		{
			return true;
		}
	}
	return false;
}

/* we need to understand when to push a Node on to 
 * 1) push and pop stack 
 * 2) process stack. 
 * 
 */

public void push(Node n)
{
	
}

public void pushtoStack()
{
	
}



public Node pop()
{
	Node n=this.PushandPopstack[this.pushandPopIndex];
    this.pushandPopIndex--;
    return n;
}

public Node findMinimum(Node n)
{
	if(n.left==null)
	{
		return n;
	}
	else
	{
		while(n!=null)
		{
			n=n.left;
		}
		return n;
	}
}

public Node findMinimum()
{
	return this.minimum;
}

}

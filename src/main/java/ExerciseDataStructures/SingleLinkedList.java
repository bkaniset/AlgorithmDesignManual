package ExerciseDataStructures;

/* Implement all functions in the dictionary using a single linked list. 
 * 1) Insert- Done.  
 * 2) Search- Done.  
 * 3) Delete- Done. 
 * 4) Maximum- Done. 
 * 5) Minimum- Done.    
 * 6) Successor of a Node-  Done. 
 * 7) Predecessor of a Node-  Done. 
 * 8) Reverse a List iterative- ok. 
 * 9) Reverse a list recursive- Needs more looking up. 
 * 10) Print List- Done. 
 */



public class SingleLinkedList {

Node head1;


public SingleLinkedList(Node curr) {
	this.head1=curr;
}

public SingleLinkedList()
{
	this.head1=null;
}

public SingleLinkedList(int i)
{
	this.head1.data=(Integer) i;
	this.head1.next=null;
}


class Node
{
	Integer data; 
    Node next;

public Node(int i)
{
this.data=(Integer)i; 	
this.next=null;
}


public Node(int i, Node node)
{
this.data=(Integer)i; 	
this.next=node;
}
public Node()
{
	this.data=null;
	this.next=null;
}
}


public void insertList(int i)
{
	if(this.head1==null)
	{
        this.head1=new Node(i);
        System.out.println("First Node Inserted");
	}
	else
	{
	Node node= this.head1;	
	Node new_node=new Node(i);
	while(node.next!=null)
	{
		node=node.next;
	}
    node.next=new_node;
    System.out.println("Node Inserted");
}
}
	

public boolean searchList(int i)
{
    boolean isPresent=false;
    Node node= this.head1;
    while(node!=null)
	{
		if(node.data==i)
		{
			isPresent=true;
			System.out.println("Element is present in the List");
			break;
		}
		else
		{   
			node=node.next;
		}
	}
    if(!isPresent)
    {
    	System.out.println("Element is not present");
    }
	
	return isPresent;
}

public void printList()
{
System.out.println("----------Printing List---------");	
Node node= this.head1;
while(node!=null)
{
	System.out.print(" "+node.data);
    node=node.next;
}
}

public void deleteFromList(int i)
{
Node node = this.head1;
 while(node.next!=null)
 {
	 if(node.next.data==i)
	 {
		 node.next=node.next.next;
	 }
	 else
	 {
		 node=node.next;
	 }
 }
	
}

public int minimumInList()
{
	Node node = this.head1;
	int min=node.data; 
	while(node!=null)
	{
		if(min>node.data)
		{
			min=node.data;
			node=node.next;
		}
		else
		{
			node=node.next;
		}
	}
	return min;
}

public int maximumInList()
{
	Node node = this.head1;
	int max=node.data; 
	while(node!=null)
	{
		if(max<node.data)
		{
			max=node.data;
			node=node.next;
		}
		else
		{
			node=node.next;
		}
	}
	return max;
}

/*
 *   /*  4 9 11 5 32 89 7 2  8
 *   
 *  4-5= -1. 
 *  9-5= 4  
 *  32-5= 27  
 *  
 * 
 */

public Node findSuccessorCV(int i)
{
	boolean isPresent=this.searchList(i);
	Node node=this.head1;
	int min=0;
	Node successor=null;
	if(isPresent)
	{
	while(node!=null)
	{
		if(min==0&&node.data>i)
		{
			min=node.data-i;
			successor=node;
			node=node.next;
		}
		else
		{
		if(node.data>i&&min>node.data-i)
		{
			min=node.data-i;
			successor=node;
			node=node.next;
		}
		else
		{
			node=node.next;
		}
		}
		}
	}
	return successor;
}

/* for successor and predecessor comparisions, please use less than and greater than ! 
 * for successor, Object>Element
 * for predecessor, Object<Element. 
 * 
 *  9 19  18 6 13 15 7 24 3 27 5 
 * 
 */

public Node findPredecessor(int i)
{
  boolean isPresent=this.searchList(i);
  Node node=this.head1;
  Node predecessor=null;
  int min=0;
  if(isPresent)
  {
  while(node!=null)
  {
	  if(min==0&&node.data<i)
	  {
		  min=i-node.data;
		  predecessor=node;
		  node=node.next;
	  }
	  else
	  {
		  if(node.data<i&&min>i-node.data)
		  {
			min=node.data-i;
			predecessor=node;
			node=node.next;
		  }
		  else
		  {
			  node=node.next;
		  }
	  }
  }
  }
  return predecessor;
}

public SingleLinkedList reverseListiterative()
{
 	Node prev=null; 
 	Node curr=this.head1; 
 	Node next=null;
	
 	while(curr!=null)
 	{
 		next=curr.next;
 		curr.next=prev;
 		prev=curr;
 		curr=next;
 	}
	return new SingleLinkedList(prev);
}

public SingleLinkedList reverseListrecursive()
{
 System.out.println("recursive way to reverse a list");
	
	
	
	
	
	return this;
}

}


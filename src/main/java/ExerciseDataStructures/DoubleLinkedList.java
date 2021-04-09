package ExerciseDataStructures;

import ExerciseDataStructures.DoubleLinkedList.Node;

/* Implement all functions in the dictionary using a single linked list. 
 * 1) Insert- Done.  
 * 2) Search- Done. 
 * 3) Delete- Done. 
 * 4) Maximum- Done. 
 * 5) Minimum- Done. 
 * 6) Successor of a Node-  Done.  
 * 7) Predecessor of a Node-  Done. 
 * 8) Print List-  
 */



public class DoubleLinkedList {

	Node head; 
	
	public DoubleLinkedList(Node node)
	{
		this.head=node;
	}
	
	public DoubleLinkedList() {
		this.head=null;
	}

	class Node
	{
		int data;
		Node prev;
		Node next;
	
	public Node()
	{
		this.data=(Integer) null;
		this.prev=null;
		this.next=null;
	}
	public Node(int i)
	{
		this.data=i;
		this.prev=null;
		this.next=null;
	}
	
	}
	
	public void insertIntoList(int i)
	{
		if(this.head==null)
		{
			this.head=new Node(i);
		}
		else
		{
			Node node=this.head;
		while(node.next!=null)
		{
			node=node.next;
		}

		Node new_node=new Node(i);
		node.next=new_node;
		new_node.prev=node;
		}
		System.out.println("Node inserted");		
	}
	
	public boolean searchInlist(int i)
	{
		boolean isPresent=false;
		Node node=this.head;
		while(node!=null)
		{
			if(node.data==i)
			{
				isPresent=true;
				return isPresent;
			}
			else
			{
				node=node.next;
			}
		}
		return isPresent;
	}
	
	public void deletefromList(int i)
	{
		boolean isPresent=this.searchInlist(i);
		Node node=this.head;
		if(isPresent)
		{
			while(node!=null)
			{
				
				if(node.data==i)
				{
					node.prev.next=node.next;
					node.next.prev=node.prev;
					node=null;
				}
				else
				{
					node=node.next;
				}
			}
		}
	
	}
	
	public int findMaximum()
	{
		int max=this.head.data;
		Node node=this.head;
		while(node!=null)
		{
			if(node.data>max)
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
	
	public int findMinimum()
	{
		int min=this.head.data;
		Node node=this.head;
		while(node!=null)
		{
			if(node.data<min)
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
	
	public Node findSuccessor(int i)
	{
		Node node=this.head;
		int diff=0; 
		Node successor=null;
		if(this.searchInlist(i))
		{
		while(node!=null)
		{
			if(diff==0&&node.data>i)
			{
				diff=node.data-i;
				successor=node;
				node=node.next;
			}
			else
			{
				if(node.data>i&&diff>node.data-i)
				{
					diff=node.data-i;
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
	
	public Node findpredecessor(int i)
	{
		Node node=this.head;
		int diff=0;
		Node predecessor=null;
		if(this.searchInlist(i))
		{
			while(node!=null)
			{
				if(diff==0&&node.data<i)
				{
					diff=i-node.data;
					predecessor=node;
					node=node.next;
				}
				else
				{
					if(node.data<i&&diff>i-node.data)
					{
						diff=i-node.data;
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
	
	public void printList()
	{
		Node node=this.head;
		System.out.print("-----Printing List------");
		System.out.println();
		while(node!=null)
		{
			System.out.print(" "+node.data);
			node=node.next;
		}
	}
	
}

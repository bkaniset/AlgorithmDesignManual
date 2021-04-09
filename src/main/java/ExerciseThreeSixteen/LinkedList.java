package ExerciseThreeSixteen;

/* This is for Steven Skeina's Exercise 3-16. 
 * 
 */


public class LinkedList {

 Node head;   /* Head of the list */
 static int size;
 
static class Node
 {
	 String data; 
	 Node next;
	 int location; 
	 static int size;
 
	 public Node(String data)
	 {
		 this.data=data;
	      this.next=null;
	 }
 
	 public Node()
	 {
		 this.data=null;
		 this.next=null;
	 }
 }
 
 /* Linked List insertion */ 
 
 public void insertIntoList(String str)
 {
	 if(this.head==null)
	 {
		this.head=new Node(str);
		this.head.location=0;
	 }
	 else {
		 
	 Node node=this.head;
	 
	 while(node.next!=null)
	{
		node=node.next;
	} 
	 node.next=new Node(str);
	 node.next.location=node.location+1;
	 size++;
	 System.out.println("node inserted at location"+node.next.location);
	 
	 }
}
 
 
public Node middleNode()
{
  int middlecount=-1;
	if(size%2==0)
  {
	  middlecount=size/2;
  }
	else
	{
		middlecount=size/2+1;
	}
	Node node=this.head;
    while(!(node.location==middlecount))
    {
    	node=node.next;
    }
return node;	
}

 
/*LinkedList search. return boolean */
 
 public boolean searchInList(String Str) {
	 Node node=this.head;
	 boolean ispresent=false;
	 while(node!=null)
	 {
		if(node.data.equalsIgnoreCase(Str))
		{
			ispresent=true;
			System.out.println("The string is present");
			break;
		}
		else
		{	
		node=node.next;
		}
	}
	 if(!ispresent)
	 {
		 System.out.println("String is not present");
	 }
  return ispresent;
 }
}

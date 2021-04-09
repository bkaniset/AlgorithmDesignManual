package ExerciseDataStructures;

/* Using a String cannot cope with the apparent idiocy of the  
 * storing a key value pair. 
 * It has to be a node. 
 * Necessary modifications are being made to enable the rehash functionality. 
 * ListEntry-ListEntry of Nodes. 
 * Nodes- Key value pair.  
 */




public class LinkedListStr {

ListEntry head;	
ListEntry next;
	
public LinkedListStr()
{
 this.head=null;
 this.size=0;
}

public LinkedListStr(ListEntry l)
{
	this.head=l; 
	this.size++;
}

public void insertIntoList(ListEntry l)
{
	if(this.head==null)
	{
		this.head=l;
		System.out.println("Node "+this.head.name.key+" and "+this.head.name.value);
		size++;
	}
	else
	{	
	ListEntry lead=this.head;
	while(lead!=null)
	{
		lead=lead.next;
	}
	lead.next=l;
	size++;
	}
	}

public void printList()
{
	ListEntry lead=this.head;
	while(lead!=null)
	{
		System.out.print("key is "+this.head.name.key+" and value is "+this.head.name.value);
	    lead=lead.next;
	}	
}

}

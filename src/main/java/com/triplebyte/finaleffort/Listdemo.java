package com.triplebyte.finaleffort;

public class Listdemo {

Integer i; 
Listdemo next ; 


public Listdemo(int i)
{
	this.i=new Integer(i);
	this.next=null;
}

public  void printList(Listdemo ld)
{
   
	while(ld!=null)		
       {
		System.out.println(ld.i);
		ld=ld.next;
	} 
}


/* Search in the list recursive*/ 

public  void searchlistrec(Listdemo ld, Integer i)
{
if(ld.next==null&&ld.i==null) 
{
	System.out.println("List is empty");
}
if(ld.i.equals(i)) 
{
	System.out.println("Present");
}
else {
	searchlistrec(ld.next, i);
}
}

/*search in the list iterative */	

public  void searchlistiter(Listdemo ld, Integer i)
{
while(ld!=null)
{
	if(ld.i.equals(i))
	{
		System.out.println("Present");
		break;
	}
	else
	{
		ld=ld.next;
	}
}
}

/* Insertion Into List */

public  void insertlist(Listdemo ld, Integer i)
{
while(ld.next!=null)
{
	ld=ld.next;
}
ld.next=new Listdemo(i);
}

/* insert into list at first position*/

public  Listdemo insertlistfirst(Listdemo ld, Integer i)
{
Listdemo l=new Listdemo(i);
l.next=ld;	
return l;
}


/* Deletion from List */ 

public void deletelist(Listdemo ld, Integer i)
{
System.out.println("I am here ");
while(ld.next!=null) 
{	
if(ld.next.i.equals(i))
{ 
	if(ld.next.next==null)
	{
		ld.next=null;
	}
	else {
	ld.next=ld.next.next;
	}
}
}
}

public Listdemo reverseList(Listdemo ls)


{
 Listdemo prev=null;
 Listdemo curr=ls;
 Listdemo next=null;  
		 while(curr!=null)
		 {

			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			if(curr!=null)
			{
			System.out.println(curr.i+" is current and previous is"+prev.i);
		 }
		 }
ls=prev;	
System.out.println(ls.i+"is the new head");
return ls;	
}

/*
 * Solution for exercise 3-23. 
 * 
 */


public void reverseListrec(Listdemo ls)
{
	Listdemo prev=null; 
	Listdemo next=null;
	Listdemo curr=null; 
     
     


}
}

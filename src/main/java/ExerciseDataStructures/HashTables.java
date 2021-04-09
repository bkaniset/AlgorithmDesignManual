package ExerciseDataStructures;

import java.math.BigInteger;

import ExerciseDataStructures.LinkedListStr.*;
import ExerciseDataStructures.ListEntry.Node;


/*   After implementing a simple hashtable, we know the basic elements of it. 
 *   It is very good. I understand the basic elements of the hash table and the hash function itself. 
 *   complete below exercises;  
 *   1) Hashtable as an array of linked lists. Done
 *   2) implement a collison resolution function using load factor-  To be done.   
 *   3) add a key value pair- Done.  
 *   4) update a key value pair- to be done.  
 *   5) key exists function- Not yet done.  
 *   6) key set - To be done.  
 *   
 */



public class HashTables {

public LinkedListStr[] arr;
public char[] char_arr=new char[26];
float loadFactor;
int tableBase;

public HashTables(int tableBase)
{
	this.arr=new LinkedListStr[tableBase];
	initilizer(tableBase);
	characterInitilizer();
	this.tableBase=tableBase;
}

public void initilizer(int tableBase)
{	
for(int i=0;i<tableBase;i++)
{
this.arr[i]=new LinkedListStr();
}
System.out.println("An Array of LinkedLists is created");
}

public void initilizer(int tableBase, LinkedListStr[] arr)
{	
arr=new LinkedListStr[tableBase];
for(int i=0;i<tableBase;i++)
{	
arr[i]=new LinkedListStr();
}
System.out.println("An Array of LinkedLists is created");
}


public void characterInitilizer()
{
int k=0;
for(char c='a';c<='z';c++)
{
	char_arr[k]=c;
	k++;
}
System.out.println("A Character reference Array is created");

}
	
	
public int returnAlphabet(char c)
{
    int res=0;
	for(char i: char_arr)
	{
		 if(i==c)
		 {
			 res= i+1;
		 }
	}
	return res;
}
 
 
public int computehash(String str)
{
	
    String key=str;
	Long l=new Long(0);
	for(int i=0;i<key.length();i++)
	{
		l=Math.addExact(l.longValue(), Math.multiplyExact(new Long((long)returnAlphabet(key.charAt(i))),new Long((long) Math.pow(26,key.length()-i))));
	}
	System.out.println(l);
	int res=(int) Math.floorMod(l, new Long(tableBase));	
	return res;	
}

/* we need to use a single linked list for strings, 
 * Which is under implementation.  
 */

public void add(Node n)
{
  int index=computehash(n.key);
  LinkedListStr list=this.returnList(index);
  addToList(list, new ListEntry(n.key, n.value));
}

public void add(String key,String value)
{
	add((new ListEntry(key,value)).name);
}

public void get(String key)
{
  int index=computehash(key);
  LinkedListStr list=arr[index];
  list.printList();
}

public LinkedListStr returnList(int index)
{
	return this.arr[index];
}

public void addToList(LinkedListStr list, ListEntry l)
{
	list.insertIntoList(l);
}

public void calculateLoadFactor()
{
  int cumilative_size=0;
  for(int i=0;i<this.arr.length;i++)
  {
	  cumilative_size=cumilative_size+this.arr[i].size();
  }
	loadFactor=cumilative_size/this.arr.length;
}



/* Need a little research for the rehash function.  
 * Completed the research, working on modification.  
 */

public void reHash()
{
   this.tableBase=2*this.tableBase;
   LinkedListStr[] new_arr=new LinkedListStr[this.tableBase];
   initilizer(this.tableBase, new_arr);   
   for(int i=0;i<this.arr.length;i++)
   {
	   LinkedListStr l=this.arr[i];
	   ListEntry n=l.head;
	    while(n!=null)
	    {
	    Node p=n.name;
	    int index=computehash(p.key);
	    System.out.println(n.name.key);
	    addToList(new_arr[index], n);
	    if(n.next==null)
	    {
	    	n=null;
	    }
	    else
	    {
	    n=n.next;	
	    }
	    }	   
   }
   this.arr=new_arr;
}
}


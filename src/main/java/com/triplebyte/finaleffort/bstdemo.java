package com.triplebyte.finaleffort;

public class bstdemo {

	Integer i; 
	bstdemo bst_parent;
	bstdemo bst_left; 
	bstdemo bst_right;
	 
	public bstdemo(int i)
	{
		this.i=i;
		this.bst_parent=null;
		this.bst_left=null;
		this.bst_right=null;
		System.out.println("root node created with key value of "+this.i);
	}
	
	public bstdemo()
	{
		System.out.println("node created.");
	}
	
	
public bstdemo searchInTree(bstdemo bst, int i)
{
	bstdemo ispresent=null;
	if(bst.i==i)
	{
		ispresent =bst;
		return ispresent;
	}
	else if(i>bst.i)
	{
		System.out.println("Going to the right subtree");
	  return searchInTree(bst.bst_right, i);
		
	}
	else if(i<bst.i)
	{
		System.out.println("Going to the left subtree");
		return searchInTree(bst.bst_left, i);
	}
	return ispresent;	
}

/* 1) Assume that you always have given a tree with root node. 
 */
	
public void insertIntoTree(bstdemo bst, int i)
{

     if(i<bst.i)
	{
    	 if(bst.bst_left!=null)
    	 {
	 insertIntoTree(bst.bst_left, i);	
	}
     else
     {   
    	 bstdemo bst_new=new bstdemo();
    	 bst.bst_left=bst_new;
    	 bst_new.i=i;
    	 bst_new.bst_parent=bst; 
    	 bst_new.bst_left=null;
    	 bst_new.bst_right=null;
         System.out.println("element inserted in the left side of node "+bst_new.bst_parent.i+" with a value of "+bst_new.i);
     }
	}
     else if(i>bst.i)
     {
    	 if(bst.bst_right!=null)
    	 {
       insertIntoTree(bst.bst_right, i);	 
     }
     else
     {
    	 bstdemo bst_new=new bstdemo();
    	 bst_new.i=i;
    	 bst.bst_right=bst_new;
    	 bst_new.bst_parent=bst;
    	 bst_new.bst_left=null;
    	 bst_new.bst_right=null;
         System.out.println("element inserted to the right of "+bst_new.bst_parent.i+" with a value of "+bst_new.i);
         
     }
    }
     
	
}

/* 1) Go to the left most element. Print that. 
 * 2) Print its parent. 
 * 3) go to the right, print the left most element. 
 * 
 */

public void printBst(bstdemo bst)
{
	if(bst!=null)
	{
		printBst(bst.bst_left);
		System.out.print(bst.i+" ");
		printBst(bst.bst_right);
	}
	
}

public bstdemo findMinimum(bstdemo bst)
{
  while(bst.bst_left!=null)
  {
	  bst=bst.bst_left;
  }
	return bst;
}

public int findMaximum(bstdemo bst)
{
	while(bst.bst_right!=null)
	{
		bst=bst.bst_right;
	}
	return bst.i;
	
}

public void deleteFromtree(bstdemo bst, int i)
{

bstdemo element=bst.searchInTree(bst, i);	
	
if(element!=null)
{
  if(element.bst_left==null&element.bst_right==null)
  {
	  if(element.bst_parent.bst_left==element)
	  {
		  element.bst_parent.bst_left=null;
	  }
	  else
	  {
		  element.bst_parent.bst_right=null;
	  }
	  element=null;
	  System.out.println("Element without children was deleted");
  }
  else if(element.bst_left!=null&element.bst_right==null)
  {
	  element.bst_parent=element;
	  element.bst_left=null;
	  System.out.println("Element with left child was deleted");
  }
  else if(element.bst_left==null&element.bst_right!=null)
  {
	  bstdemo parent=element.bst_parent;
	  element=element.bst_right;
	  element.bst_parent=parent;
	  element.bst_right=null;
	  System.out.println("Element with right child was deleted"); 
  }
  else
  {
	 bstdemo replaceable=findMinimum(element.bst_right);
	 element=replaceable;
     replaceable=null; 
     System.out.println("Element with both children was deleted");
  }  
	
}
}



}

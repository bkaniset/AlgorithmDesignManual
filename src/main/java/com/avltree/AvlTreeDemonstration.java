package com.avltree;

public class AvlTreeDemonstration {

	public static void main(String[] args) {
		
		AvlTree at=new AvlTree();
        at.insertIntoTree("Jack");
        System.out.println(at.root.balanceFactor);
        at.insertIntoTree("Kyle");
        System.out.println(at.root.balanceFactor);
        at.insertIntoTree("abcd");
      
     
	
	}
}


/*
 
   System.out.println(at.root.right.balanceFactor);
        System.out.println(at.root.balanceFactor);
        System.out.println(at.root.balanceFactor);
        at.insertIntoTree("plutarch");
   System.out.println(at.root.right.balanceFactor);
        at.insertIntoTree("sylla");
        at.insertIntoTree("caesar");
        at.insertIntoTree("ale");
        at.insertIntoTree("Marius");
        at.insertIntoTree("hannibal");
        at.insertIntoTree("Mithradates");


*/
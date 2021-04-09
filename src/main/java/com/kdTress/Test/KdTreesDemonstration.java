package com.kdTress.Test;

import com.kdTress.Test.KdTrees.Node;

public class KdTreesDemonstration {

	public static void main(String[] args) {
		
	KdTrees kdt=new KdTrees();	
    Node n1=kdt.new Node(30,40);
    Node n2=kdt.new Node(5,25);
    Node n3=kdt.new Node(10,12);
    Node n4=kdt.new Node(70,70);
    Node n5=kdt.new Node(50,30);
    Node n6=kdt.new Node(35,45);
    kdt.insertIntoTree(n1);
    kdt.insertIntoTree(n2);
    kdt.insertIntoTree(n3);
    kdt.insertIntoTree(n4);
    kdt.insertIntoTree(n5);
    kdt.insertIntoTree(n6);
    Node n7=kdt.new Node(10,12); 
    Node n9=kdt.new Node(30, 30);
     kdt.searchInTree(kdt.new Node(10,12));
	Node n10=kdt.new Node(32,42);
	kdt.insertIntoTree(n10);
	Node n11=kdt.new Node(35,80);
	kdt.insertIntoTree(n11);
	kdt.rangeSearch(n1, n9, 15);
	kdt.searchInTree(kdt.new Node(35,45));
	kdt.searchInTree(kdt.new Node(-5,-5));
	kdt.deleteNode(n3);
	kdt.printKdtree(n1); 
	}
}



package ExerciseDataStructures;

import ExerciseDataStructures.BinaryTree.Node;

public class BinaryTreeDemonstration {

	public static void main(String[] args) {
		
	   BinaryTree bt=new BinaryTree();
	   Node n=bt.new Node(16);
	   bt.insertIntoTree(n);
       Node n2=bt.new Node(8);
       bt.insertIntoTree(n2);
       Node n3=bt.new Node(12);
       bt.insertIntoTree(n3);
       Node n4=bt.new Node(5);
       bt.insertIntoTree(n4);
       Node n5=bt.new Node(25);
       bt.insertIntoTree(n5);
       Node n6=bt.new Node(21);

       bt.insertIntoTree(n6);
       Node n7=bt.new Node(28);
       Node n8=bt.new Node(2);
	   bt.insertIntoTree(n7);
       bt.insertIntoTree(n8);
	   Node n9=bt.new Node(22);
	   Node n10=bt.new Node(27);
	   bt.insertIntoTree(n9);
       bt.insertIntoTree(n10);

     
       
          
       bt.printTree(n);
       System.out.println();
       SingleLinkedList l=new SingleLinkedList();
       bt.returnListFromTree(l);
       l.printList();
	}



/* System.out.println(bt.root.data);
  ;
	   System.out.println();
	   System.out.println(bt.findSuccessor(n3).data);
	   System.out.println(bt.findSuccessor(n9).data);
	   System.out.println(bt.findPredecessor(n6).data);
	   System.out.println(bt.findPredecessor(n9).data);
	   bt.printTree(n);
       System.out.println();
	   System.out.println(bt.searchInList(n7));
	   System.out.println(bt.findMaximum().data);
	   System.out.println(bt.findMinimum().data);
           
 * 
 * 
 * 
 */






}

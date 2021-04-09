package ExerciseDataStructures;

import threadedTrees.exercises.SingleThreadBinaryTree.Node;

public class DoubleThreadedBinaryTreeDemonstration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
	 DoubleThreadBinaryTree bt=new DoubleThreadBinaryTree();	
	
	 ExerciseDataStructures.DoubleThreadBinaryTree.Node n=bt.new Node(16);
		bt.insertIntoTree(n);
		System.out.println(n.isRightChild+" "+n.right);
	    ExerciseDataStructures.DoubleThreadBinaryTree.Node n2=bt.new Node(8);
	    bt.insertIntoTree(n2);
	    System.out.println(n.isLeftChild);   
	    System.out.println(n2.isRightChild+" "+n2.right.data);   
	    
	    ExerciseDataStructures.DoubleThreadBinaryTree.Node n3=bt.new Node(12);
	    bt.insertIntoTree(n3);
	    System.out.println(n2.isRightChild+" "+n2.right.data);   
	    ExerciseDataStructures.DoubleThreadBinaryTree.Node n4=bt.new Node(5);
	    bt.insertIntoTree(n4);
	    System.out.println(n2.isLeftChild+" "+n2.left.data);   
	    System.out.println(n4.isRightChild+" "+n4.right.data);   
	    
	 
	 
	}

}

/*  ExerciseDataStructures.DoubleThreadBinaryTree.Node n4=bt.new Node(5);
	    bt.insertIntoTree(n4);
	    ExerciseDataStructures.DoubleThreadBinaryTree.Node n5=bt.new Node(25);
	    bt.insertIntoTree(n5);
	    ExerciseDataStructures.DoubleThreadBinaryTree.Node n6=bt.new Node(21);
	    bt.insertIntoTree(n6);
	    ExerciseDataStructures.DoubleThreadBinaryTree.Node n7=bt.new Node(28);
	    ExerciseDataStructures.DoubleThreadBinaryTree.Node n8=bt.new Node(2);
		bt.insertIntoTree(n7);
	    bt.insertIntoTree(n8);
		ExerciseDataStructures.DoubleThreadBinaryTree.Node n9=bt.new Node(22);
		ExerciseDataStructures.DoubleThreadBinaryTree.Node n10=bt.new Node(27);
		bt.insertIntoTree(n9);
	    bt.insertIntoTree(n10);
	 
 * 
 * 
 * 
 * 
 * 
 */

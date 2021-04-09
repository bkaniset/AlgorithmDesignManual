package threadedTrees.exercises;

import threadedTrees.exercises.SingleThreadBinaryTree.Node;

public class SingleThreadedBinaryTreeDemonstration {

public static void main(String... args)	
	
{
	SingleThreadBinaryTree bt=new SingleThreadBinaryTree();
    
	Node n=bt.new Node(16);
	bt.insertIntoTree(n);
    threadedTrees.exercises.SingleThreadBinaryTree.Node n2=bt.new Node(8);
    bt.insertIntoTree(n2);
    threadedTrees.exercises.SingleThreadBinaryTree.Node n3=bt.new Node(12);
    bt.insertIntoTree(n3);
    threadedTrees.exercises.SingleThreadBinaryTree.Node n4=bt.new Node(5);
    bt.insertIntoTree(n4);
    threadedTrees.exercises.SingleThreadBinaryTree.Node n5=bt.new Node(25);
    bt.insertIntoTree(n5);
    threadedTrees.exercises.SingleThreadBinaryTree.Node n6=bt.new Node(21);
    bt.insertIntoTree(n6);
    threadedTrees.exercises.SingleThreadBinaryTree.Node n7=bt.new Node(28);
    threadedTrees.exercises.SingleThreadBinaryTree.Node n8=bt.new Node(2);
	   bt.insertIntoTree(n7);
    bt.insertIntoTree(n8);
	   threadedTrees.exercises.SingleThreadBinaryTree.Node n9=bt.new Node(22);
	   threadedTrees.exercises.SingleThreadBinaryTree.Node n10=bt.new Node(27);
	   bt.insertIntoTree(n9);
    bt.insertIntoTree(n10);
    bt.inorderTraversal();

}	
}

package BPlusTrees;


/* if you initialize a B+ tree, you should do so with a dimension. 
 * 
 * A. Either a right child, if present or null. 
 * B. Either a left child, if present or null.
 * 
 * 
 *  In this design, 
 *  A. A BPT tree is a group of BPT NOdes. 
 *  B. Each BPT node is an array of nodes. 
 *  C. Each node has d elements, and 2*d+1 pointers. 
 * 
 *  Functionality is provided for; 
 *  A. Insert into Tree. 
 *  B. Delete from Tree. 
 *  C. Search from Tree. 
 * 
 */

public class BPT {


public class InternalNode extends Node 
{
int maxDegree;
int minDegree; 
int degree; 
InternalNode leftSibling; 
InternalNode rightSibling; 
Integer[] keys; 
Node[] childPointers;
}

public class LeafNode extends Node
{
	int maxNumberofPairs;
	int minNumberofPairs;
    int numPairs;
    LeafNode leftSibling;
    LeafNode rightSibling; 
    DictionaryPair[] disctionary; 
}

class Node
{
InternalNode parent;
}



public void bPlusTreeinsert(int i)
{
	
}
	
public void bPlusTreeDelete(int i)
{
	
}

public boolean bPlusTreeSearch(int i)
{
	return false;
}


}

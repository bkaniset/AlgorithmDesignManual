package ExerciseDataStructures;

public class HeapTreeDemonstration {

	public static void main(String[] args) {
		
		HeapTree h=new HeapTree(64);
        System.out.println(h.insert_index);
        h.insertIntoHeap(8);
        h.printTree();
        h.insertIntoHeap(19);
        h.printTree();
        h.insertIntoHeap(1);
        h.printTree();
        h.insertIntoHeap(5);
        h.printTree();
        h.insertIntoHeap(16);
        h.printTree();
        h.insertIntoHeap(43);
        h.printTree();
        h.insertIntoHeap(73);
        h.printTree();
        h.insertIntoHeap(49);
        h.printTree();
        h.insertIntoHeap(37);
        h.printTree();
        h.insertIntoHeap(24);
        h.printTree();
        h.insertIntoHeap(13);
        h.printTree();
        h.insertIntoHeap(0);
        h.printTree();
                
        	
        
	}
	

}



/* 8 19 1 5 16 43 73 49 37 24 13 */

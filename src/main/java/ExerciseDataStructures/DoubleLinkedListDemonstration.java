package ExerciseDataStructures;

public class DoubleLinkedListDemonstration {

	public static void main(String...args)
	{
		
		DoubleLinkedList l=new DoubleLinkedList();
		 l.insertIntoList(4);
		 l.insertIntoList(8);
		 l.insertIntoList(9);
		 l.insertIntoList(2);
		 l.insertIntoList(23);
		 l.insertIntoList(56);
		 System.out.println(l.searchInlist(2));
		 System.out.println(l.searchInlist(59));
		 l.printList();
		    System.out.println();
		    l.deletefromList(2);
		    System.out.println();
		    l.printList();
		    System.out.println();
		    System.out.println("Max in list is "+l.findMaximum()+" min in List is "+l.findMinimum());
		    l.insertIntoList(2);
		    System.out.println("Max in list is "+l.findMaximum()+" min in List is "+l.findMinimum());
		 
		    l.insertIntoList(63);
		    System.out.println("Max in list is "+l.findMaximum()+" min in List is "+l.findMinimum());
		    
		    System.out.println("Sucessor"+l.findSuccessor(23).data);
		    l.insertIntoList(29);
		    System.out.println("Sucessor"+l.findSuccessor(23).data);
		    l.printList();
		    System.out.println("Predecessor"+l.findpredecessor(9).data);
		    l.insertIntoList(7);
		    l.printList();
		    System.out.println();
		    System.out.println("Predecessor"+l.findpredecessor(7).data);
		    System.out.println("Predecessor"+l.findpredecessor(8).data);
		    l.printList();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

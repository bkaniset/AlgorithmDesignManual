package ExerciseDataStructures;

public class SingleLinkedListdemonstration {

public static void main(String... args)
{
	SingleLinkedList l=new SingleLinkedList(5);
    l.insertList(4);
    l.insertList(8);
    l.insertList(9);
    l.insertList(2);
    l.insertList(23);
    l.insertList(56);
    
    System.out.println(l.searchList(2));
    System.out.println(l.searchList(59));
    l.printList();
    System.out.println();
    l.deleteFromList(2);
    System.out.println();
    l.printList();
    System.out.println();
    System.out.println("Max in list is "+l.maximumInList()+" min in List is "+l.minimumInList());
    l.insertList(2);
    System.out.println("Max in list is "+l.maximumInList()+" min in List is "+l.minimumInList());
    l.insertList(63);
    System.out.println("Max in list is "+l.maximumInList()+" min in List is "+l.minimumInList());
    System.out.println(l.findSuccessorCV(23).data);
    l.insertList(29);
    System.out.println(l.findSuccessorCV(23).data);
    l.printList();
    System.out.println(l.findPredecessor(9).data);
    l.insertList(7);
    l.printList();
    System.out.println();
    System.out.println(l.findPredecessor(7).data);
    System.out.println(l.findPredecessor(8).data);
    l.printList();
    l.reverseListiterative().printList();
}
}

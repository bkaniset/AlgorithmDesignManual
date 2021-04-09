package ExerciseDataStructures;

public class ArrayDemonstration {

	public static void main(String[] args) {
	
		Array arr=new Array();
     arr.insertIntoArray(5);
     arr.insertIntoArray(13);
     arr.insertIntoArray(2);
     arr.insertIntoArray(23);
     arr.insertIntoArray(28);
     arr.insertIntoArray(64);
     arr.insertIntoArray(55);
     arr.insertIntoArray(92);
	 arr.insertIntoArray(103);
	 System.out.println();
	 System.out.println(arr.returnMax()); 
	 System.out.println(arr.returnMin());
	 System.out.println("Printing predecesor");
	 System.out.println(arr.returnPredecessorRV(28));
	 arr.insertIntoArray(26);
	 System.out.println("Printing predecesor");
	 System.out.println(arr.returnPredecessorRV(28));
	 System.out.println(arr.returnSuccessorRV(28));
	 arr.insertIntoArray(37);
	 System.out.println(arr.returnSuccessorRV(28));
	 
     }

}





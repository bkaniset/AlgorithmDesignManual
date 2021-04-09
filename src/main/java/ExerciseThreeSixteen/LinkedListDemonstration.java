package ExerciseThreeSixteen;

import java.io.*;

public class LinkedListDemonstration {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Initializing");
		FileReader fr=new FileReader(new File("C:/Users/nm804517/OneDrive - Sprint/Desktop/Writing/goal.txt"));		
	    BufferedReader br=new BufferedReader(fr); 
        LinkedList ls=new LinkedList();
        System.out.println(ls+" Is created with "+ls.head);
	    while(br.readLine()!=null)
	    { 
	    	System.out.println("Reading");
	    	String[] arr_str=br.readLine().split("(?=[,. ])|\\\\s+");	    	
	    	for(String s: arr_str)
	    	{   
	    		System.out.println("Inspecting String "+s);
	    		if(!ls.searchInList(s))         
	    		{
	    		ls.insertIntoList(s);	              
	    		System.out.println("The word "+s+" has been added to the dictionary");
	    		}	    		
 	    	}
	    	
	    }
	    System.out.println(ls.size);
	    System.out.println(ls.middleNode().data+" is the middle node"+ls.middleNode().location);
	}

}

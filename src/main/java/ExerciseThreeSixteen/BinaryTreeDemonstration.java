package ExerciseThreeSixteen;

import java.io.*;

public class BinaryTreeDemonstration {

public static void main(String... args) throws IOException
{
	
FileReader fr=new FileReader(new File("C:/Users/nm804517/OneDrive - Sprint/Desktop/Writing/goal.txt"));
BufferedReader br=new BufferedReader(fr); 
Binarytree bt=new Binarytree();
System.out.println("Tree has been created");

while(br.readLine()!=null)
{
	System.out.println("Reading Line one");
	String[] insertable_line=br.readLine().split("(?=[,. ])|\\\\s+");
    for(String s: insertable_line)
    {
    	if(!Binarytree.searchInTree(bt.root, s))
    	{
    		System.out.println("Inserting into the tree");
    		bt.insertIntoTree(bt.root, s);
    	}
    }

}

bt.printTree(bt.root);

}
}

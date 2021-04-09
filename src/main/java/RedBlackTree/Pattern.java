package RedBlackTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Pattern {

	public static void main(String[] args) {
		
     try {
		FileWriter text = new FileWriter("C:/Users/nm804517/OneDrive - Sprint/Desktop/Print.txt");
		int x=0;
		while(x==0)
		{
			text.write(" ");
		}
	    text.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
     
     
	}
 
	
 public static void printPattern(int n)
 {
	 for(int i=0;i<n;i++)
	 {
		 if(i%2==0)
		 {
			 for(int j=0;j<n;j++)
			 {
				 if(j%2==0)
				 {
					 System.out.print(' ');
				 }
				 else
				 {
					 System.out.print('#');
				 }
			 }
		 }
		 else
		 {
			 for(int k=0;k<n;k++)
			 {
				 if(k%2==0)
				 {
					 System.out.print('#');
				 }
				 else
				 {
					 System.out.print(' ');
				 }
			 }
		 }
	  System.out.println();
	 }
 }
	
}

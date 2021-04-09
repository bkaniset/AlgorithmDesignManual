package ExerciseThreeTwoThree;

public class ReversePrinter {

public static void main(String args[])
{
	String str="My Name is chris";
	int space_pointer=str.length();
	for(int i=str.length()-1;i>=0;i--)
	{
		int end_pointer=-1;
		if(str.charAt(i)==' ')
		{   
			end_pointer=space_pointer;
			
			space_pointer=i;
			System.out.print(str.substring(space_pointer, end_pointer));
			
		}
	}
	System.out.print(" "+str.substring(0,space_pointer));
	
}
	
	
}

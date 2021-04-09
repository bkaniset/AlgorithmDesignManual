package com.triplebyte.finaleffort;

public class ExerciseThreeOne {

	public static void main(String[] args) {
		System.out.println(parenthesisChecker("((())())()"));
		System.out.println(parenthesisChecker(")()("));
		System.out.println(parenthesisChecker("())"));
	}

	
public static boolean parenthesisChecker(String str)
{   
	boolean res=false;
	int par_count=0;
	int i=0;
	while(i<str.length())
	{
		if(str.charAt(i)=='(')
		{
		par_count++;	
		}
		else if(str.charAt(i)==')')
		{
			par_count--;			
		}		
		if(par_count<0)
		{
			System.out.println("Offending character is at "+i);
			return false;
		}
		i++;
	}
	if(par_count==0)
	{
		res=true;
	}
	return res;
}

/*  Sameexercise using stacks. 
 * These arent integer stacks, these are character stacks 
 * 
 */

}

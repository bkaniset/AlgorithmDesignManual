package com.triplebyte.finaleffort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] arr=amoritize(); 
     int i=0;
     while(i<50)
     {
     try
     {
      arr[i]=i;
     }
     catch (ArrayIndexOutOfBoundsException aioob)
     {
    	amoritize(); 
     }
     i++;
     }  
    }
 public static int[] amoritize()
 {
	 int k=1;
	 int[] arr_new=new int[arr.length*2];
	 for(int i=0;i<arr.length;i++ )
	 {
		 arr_new[i]=arr[i]; 
	 }	 
 return arr_new;
 }
}

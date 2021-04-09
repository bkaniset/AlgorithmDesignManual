package com.triplebyte.finaleffort;

import java.util.ArrayList;

/* Solution for the exercise 3-10 in steven skiena's Algorithm design Manual.  
* 
*/

public class ExcerciseThreeten {

public static void main(String... args)
{
	
Weight[] W=new Weight[]{new Weight(0.23d), new Weight(0.59d), new Weight(0.83d), new Weight(0.654d)};

System.out.println(calculator(W));
}

/* 1) Look for the smallest element higher than w. log n.  
 * 2) Delete that from the tree, and reduce its weight. O(1).  
 * 3) reinsert. log n. 
 * 
 */
	
public static int calculator(Weight[] W)
{
	ArrayList<Bins> b=new ArrayList<Bins>();
	
for(Weight w: W )
{    
	 if(b.size()==0)
	 {   
		 Bins first=new Bins();
		 first.remaining_weight=first.remaining_weight-w.weight;
		 b.add(first);
		 System.out.println("First Weight of "+w.weight+"added. remaining weight of bin "+first.remaining_weight);
	 }
	 else {
     boolean found_bin=false;
     Bins curr_bin=b.get(0);
	for(Bins bin: b)
	{
		System.out.println(bin.remaining_weight+" and "+w.weight);
		if(w.weight>bin.remaining_weight)
		{
			System.out.print("Wont fit in this bin");
		}
		else
		{
			if(bin.remaining_weight<=curr_bin.remaining_weight)
			{
				System.out.print("Will fit in this bin "); 
				curr_bin=bin;
				found_bin=true;
			}
		}			
	}
	if(found_bin)
	{
		curr_bin.remaining_weight=curr_bin.remaining_weight-w.weight;
		System.out.print(" Added to existing bin");
	}
	else
	{
		
		Bins newly_added= new Bins();
		newly_added.remaining_weight=1-w.weight;
		b.add(newly_added);
	   System.out.print(" Added new bin");
  	}
System.out.println();	
}
}

return b.size();
}
}

/*     
 *  0.7  
 *  0.9 
 *  0.4  
 * 
 * Weight 0.5 
 * 
 */




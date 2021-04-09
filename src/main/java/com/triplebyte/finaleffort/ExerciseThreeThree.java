package com.triplebyte.finaleffort;

public class ExerciseThreeThree {

	public static void main(String[] args) {
		
		
	}

}

/*   Amortized strategy shows that using small arrays at the begining, 
 *  we can grow an array dynamically. Deletion;  
 *   
 *   1) After adding the k th element, if an array grows to size n. 
 *    If then the Kth element is deleted, then the array skrinks. reset the size to half. 
 *    Similar to growth, this strategy can also be accomplished in linear time. However, 
 *    Problems occur when, 
 *    
 *     Array is at a size k, 
 *     insert element p, Array grows in size. k movements,  
 *     delete one element, Array skrinks in size, again k movements, 
 *     insert one element p1,   
 *     
 * 
 * In case gives us a bad amortization cost as we need to move elements at each insert and delete combination at the last element. 
 * 
 * For each element inserted at the last position, we need to do k movements,  
 * For each element deleted after recent doubling, we need to do k movements, 
 * 
 * for an array to reach n elements, we need to do 2*n movements.
 * 
 * For an deletion after reaching a size n, we need to do n/2 movements. 
 * 
 * For an array of size n; 
 * n/2 deletions=       n/2   
 * After n/4 deletions= n/4 after 
 * 
 * From the formula of GP 2n deletions.  
 *  
 *   Worst cost would be when there is a seuence of addtions and deletions between doubling. 
 * 
 * b) One strategy, is to keep a seperate array of deleted elements. 
 * 
 * Search would take O(N) time, and if the element is present, we add it to the array of deleted elements. 
 * When doubling, we remove these elements from the main array while copying. 
 * we need to Shrink only when the deleted array becomes half of the original array. 
 * 
 * 
 * 3-4) Hash function where they are divided by 1 and a hash table of size n;  
 *  
 * insert = k goes at kth place. 
 * 
 * 3-5 
 * 
 * n nodes; 
 * 
 * a) data= 4n bytes. 
 *    pointers =12n bytes. 
 * overhead fraction = 0.25. 
 * b) 
 * leaf nodes are n; 
 * one level above = n/2 leaf nodes. 
 *  data= 4n 
 * pointers= 4*n*(1/2+1/4+............1)= 4*2n=8n. 
 * overhead  fraction = 0.5. 
 * 
 * 
 */




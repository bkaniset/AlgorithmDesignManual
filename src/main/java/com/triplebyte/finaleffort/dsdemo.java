package com.triplebyte.finaleffort;

public class dsdemo {

	public static void main(String[] args) {
	
		/* test Code for Lists. 
		Listdemo ld1 = new Listdemo(0);
		Listdemo ld2 = new Listdemo(1);
		Listdemo ld3 = new Listdemo(2);
		Listdemo ld4 = new Listdemo(3);
		Listdemo ld5 = new Listdemo(4);
		Listdemo ld6 = new Listdemo(5);
	
		ld1.next=ld2;
		ld2.next=ld3;
		ld3.next=ld4;
		ld4.next=ld5;
		ld5.next=ld6;
        
     printList(ld1);
     searchlistrec(ld1, 4);
     searchlistiter(ld1, 9);
     insertlist(ld1, 7);
     printList(ld1);   
     Listdemo l=insertlistfirst(ld1, 8);
     printList(l);
     System.out.println("-----------------------");
     deletelist(l, 2);
     printList(l);    
     
     Test code for stack and queue. 
	saq.stackPush(arr, 7);
	saq.stackPrint(arr);
	saq.stackPush(arr, 9);
    saq.stackPrint(arr); 
    saq.stackPush(arr, 17);
    saq.stackPrint(arr); 
    saq.stackPush(arr, 11);
    saq.stackPrint(arr); 
    saq.stackPush(arr, 13);
    saq.stackPrint(arr); 
    saq.stackPush(arr, 15);
    saq.stackPrint(arr); 
    int i=saq.stackPop(arr);
    System.out.println(i+" has been removed from the stack");
    saq.stackPrint(arr); 
      
	int[] arr=new int[5];
	stackandqueuedemo saq=new stackandqueuedemo();
	saq.queuePut(arr, 5);
	saq.queuePut(arr, 6);
	saq.queuePut(arr, 7);
	saq.queuePut(arr, 8);
	saq.queuePut(arr, 9);
	saq.stackOrQueuePrint(arr);
	saq.queueGet(arr);
	saq.stackOrQueuePrint(arr);
		
	bstdemo bst=new bstdemo(15);
	bst.insertIntoTree(bst, 12);
    bst.insertIntoTree(bst, 17);
    bst.insertIntoTree(bst, 9);
    bst.insertIntoTree(bst, 14);
    bst.insertIntoTree(bst, 16);
    bst.insertIntoTree(bst, 19);
    bst.printBst(bst);
    System.out.println();
    bst.insertIntoTree(bst, 10);
    bst.printBst(bst);
    System.out.println();
    bst.deleteFromtree(bst, 9);
    System.out.println();
    bst.printBst(bst);
	*/
	
		Listdemo ld1 = new Listdemo(0);
		Listdemo ld2 = new Listdemo(1);
		Listdemo ld3 = new Listdemo(2);
		Listdemo ld4 = new Listdemo(3);
		Listdemo ld5 = new Listdemo(4);
		Listdemo ld6 = new Listdemo(5);
	
		ld1.next=ld2;
		ld2.next=ld3;
		ld3.next=ld4;
		ld4.next=ld5;
		ld5.next=ld6;
        
     ld1.printList(ld1);
	 Listdemo reversed=ld1.reverseList(ld1);
	 ld1.printList(reversed);
	}
	
}

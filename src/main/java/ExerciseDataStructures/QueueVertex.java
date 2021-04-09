package ExerciseDataStructures;

public class QueueVertex {

Vertex vertex; 
Vertex Parent; 	
boolean isProcessed; 
boolean isDiscovered;
int[] time;
int timeInsertIndex;

public QueueVertex()
{
this.vertex=null;
this.Parent=null;
this.isDiscovered=false;
this.isProcessed=false;
this.time=new int[2];
this.timeInsertIndex=0;
}

public QueueVertex(Vertex v)
{
	this.vertex=v;
	this.Parent=null;
	this.isDiscovered=false;
	this.isProcessed=false;
}

public QueueVertex(Vertex a , Vertex b)
{
	this.vertex=a;
	this.Parent=b;
	this.isDiscovered=false;
	this.isProcessed=false;
}

public int[] amortize(int[] arr)
{	
	int n=arr.length;
	 int[] new_arr=new int[2*n];
	 System.out.println("Amortize");
	 for(int i=0;i<n;i++)
	 {
		 new_arr[i]=arr[i];
	 }
	 return new_arr;
	
}

public void insertTime(int timer)
{
	if(this.timeInsertIndex<this.time.length-1)
	{
		System.out.println(timeInsertIndex);
		this.time[timeInsertIndex]=timer;
		System.out.println("time inserted");
		timeInsertIndex++;	
		System.out.println(timeInsertIndex);
	}	
	else
	{
		int[] arr=this.time;
		this.time=amortize(arr);
		insertTime(timer);	
	}	

}

public int returnTime()
{
System.out.println(timeInsertIndex);	
return this.time[timeInsertIndex];

	
}

}

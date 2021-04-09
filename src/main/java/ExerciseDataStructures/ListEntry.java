package ExerciseDataStructures;

public class ListEntry {

Node name;


class Node 
{
String key; 
String value;

public Node(String key, String value)
{
	this.key=key;
	this.value=value;
}

}

public ListEntry(String key , String value)
{
 this.name=new Node(key, value);
}

public ListEntry()
{
	this.name=null;
}
	
}

package ExerciseDataStructures;

/*  This is a special object created for weighted graphs. 
 * 
 */


public class EdgeEnding {

Vertex v; 
boolean isDirected; 
int weight;
	
public EdgeEnding(Vertex v, boolean isDirected, int weight)
{
	this.v=v;
	this.isDirected=isDirected;
	this.weight=weight;
}

public EdgeEnding(Vertex v)
{
	this.v=v;
	this.isDirected=false;
	this.weight=0;
}

public EdgeEnding()
{
	this.v=null;
	this.isDirected=false;
	this.weight=0;
}

}

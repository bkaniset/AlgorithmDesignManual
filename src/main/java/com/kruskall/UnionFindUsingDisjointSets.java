package com.kruskall;

import java.util.HashMap;

public class UnionFindUsingDisjointSets {

DisjointSetVertex[] v;
HashMap<Vertex , Integer> hm;

public UnionFindUsingDisjointSets(AdjacencyList a)
{
   this.v=new DisjointSetVertex[a.vertices.length];	
   hm=new HashMap();
   for(int i=0;i<a.vertices.length;i++)
{
	this.v[i].v=a.vertices[i];
	this.v[i].parent=this.v[i].v;
    hm.put(a.vertices[i], new Integer(i));
}
}

/* This method should be recursive for all in the tree. 
 * Does it matter? No. 
 *  
 */

public int Union(Edge e)
{
	Vertex a=e.from;
	Vertex b=e.to;
    int primer=hm.get(b).intValue();
    this.v[primer].parent=a;
    this.v[hm.get(a).intValue()].rank++;
    this.v[hm.get(a).intValue()].size++;    
    return hm.get(a).intValue();
}

public Vertex find(Vertex v)
{  
if(this.v[hm.get(v)].equals(this.v[hm.get(v)].parent))
{
	return v;
}
else
{
 while(!this.v[hm.get(v)].equals(this.v[hm.get(v)].parent))
 {
    	 v=this.v[hm.get(v)].parent;
 }
 return v;
}		
}

public boolean ifCycleExists(Edge e)
{
	if(find(e.to).equals(find(e.to)))
	{
		return true;
	}
	else
	{
		return false;
	}	
}

public boolean checkIfTreeIsFull()
{

	
	
}
}

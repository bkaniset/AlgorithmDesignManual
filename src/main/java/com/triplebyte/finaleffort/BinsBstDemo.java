package com.triplebyte.finaleffort;

public class BinsBstDemo {

	public Bins root;
	
	
public Bins insertIntoBst(Bins b)
{
	if(this.root==null)
	{
		this.root=b;
		return this.root;
	}
	else if(b.remaining_weight<root.remaining_weight)
	{
		if(root.left!=null)
		{
			root=root.left;
			insertIntoBst()
		}
	}
}
	
	
	
}

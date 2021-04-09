package ExerciseThreeSixteen;

public class Binarytree {

public BinaryNode root;	

public Binarytree(String rootKey)
{
	this.root.key=rootKey;
	this.root.left=this.root.right=null;
}
public Binarytree()
{
	this.root=null;
}

static class BinaryNode
{
	String key;
	BinaryNode left, right;
	
	public BinaryNode(String key)
	{
		this.key=key;
		this.left=null;
		this.right=null;
	}
	
}

/* Insertion of strings into binary tree. 
 *  
 */

public void insertIntoTree(BinaryNode b, String str)
{
if(b==null)
{
	b=new BinaryNode(str);
}
else
{
	if(b.key.compareTo(str)<0)
	{
		if(b.left!=null)
		{
		insertIntoTree(b.left, str);
	    }
	    else
	    {
		BinaryNode b_new=new BinaryNode(str);
         b.left=b_new;
	    }
	}	
	else
	{
		if(b.right!=null)
		{
			insertIntoTree(b.right, str);
		}
		else
		{
			BinaryNode b_new=new BinaryNode(str);
			b.right=b_new;
		}
		
	}
	
}
		   		   
}
	
public void printTree(BinaryNode b)
{
	System.out.println("Intilizing to print");
	while(b!=null)
	{
		printTree(b.left);
		System.out.println(b.key);
		printTree(b.right);
	}
}


public static boolean searchInTree(BinaryNode b, String str)
{
if(b==null)
{
	return false;
}
if(b.key.equals(str))
{
	return true;
}
else
{
if(b.key.compareTo(str)<0)
{
 return	searchInTree(b.left, str);
}
else 
{
	return searchInTree(b.right, str);
}
	
}	
	
	
}	
}

	


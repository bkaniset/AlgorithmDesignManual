package FloydWorshall;

import java.io.UnsupportedEncodingException;

public class FloydWorshallAlgorithm {
	
AdjacencyMatrix solution;

public FloydWorshallAlgorithm(AdjacencyMatrix am)
{
this.solution=am;
}

public void shortestPathPairs()
{
int numberOfVertices=this.solution.vertexNumber;
for(int k=0;k<numberOfVertices;k++)
{
	for(int i=0;i<numberOfVertices;i++)
	{
		for(int j=0;j<numberOfVertices;j++)
		{
			if(i!=j&&j!=k&&this.solution.graph[i][k]+this.solution.graph[k][j]<this.solution.graph[i][j])
			{
				this.solution.graph[i][j]=this.solution.graph[i][k]+this.solution.graph[k][j];
			}	
		}
	}
}

}

public void displayMatrix()
{
	
	
	for(int i=0;i<this.solution.vertexNumber;i++)
	{
		for(int j=0;j<this.solution.vertexNumber;j++)
		{
						
		System.out.print(this.solution.graph[i][j]+",");	
								
		}
		
		System.out.println();
	}
}


}

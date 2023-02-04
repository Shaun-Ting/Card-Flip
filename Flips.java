// This file contains 4 functions to flip the row or columns

public class Flips {
	// Flips the first column to the second column, by using the second column to push the first column then pop it
	public static void LeftFlip(StackUsingLinkedlist <Integer> CardPile[][], int n, int m, int counter)
	{
			for(int x=0; x<n; x++)
			{
				while(CardPile[x][counter].peek() != 0)
			    {
					CardPile[x][counter+1].push((-1)*CardPile[x][counter].peek());
				    CardPile[x][counter].pop();
			    }
			}
	}
	
	// Flips the last column to the second last column, by using the second last column to push the last column then pop it 
	public static void RightFlip(StackUsingLinkedlist <Integer> CardPile[][], int n, int m, int counter)
	{
		for(int x = 0; x < n; x++)
		{
			while(CardPile[x][m-counter-1].peek() != 0)
		    {
				CardPile[x][m-counter-2].push((-1)*CardPile[x][m-counter-1].peek());
				CardPile[x][m-counter-1].pop();
		    }
		}
	}
	
	// Flips the first row to the second row, by using the second row to push the first row then pop it 
	public static void TopFlip(StackUsingLinkedlist <Integer> CardPile[][], int n, int m, int counter)
	{
		for(int y=0; y<m; y++)
			{
				while(CardPile[counter][y].peek() != 0)
			    {
					CardPile[counter+1][y].push((-1)*CardPile[counter][y].peek());
				    CardPile[counter][y].pop();
			    }
			}
	}
	
	// Flips the last row to the second last row, by using the second last row to push the last row then pop it 
	public static void BottomFlip(StackUsingLinkedlist <Integer> CardPile[][], int n, int m, int counter)
	{
		for(int y = 0; y < m; y++)
		{
			while (CardPile[n-counter-1][y].peek() != 0)
			{
				CardPile[n-counter-2][y].push((-1)*CardPile[n-counter-1][y].peek());
				CardPile[n-counter-1][y].pop();
			}
		}
	}
	
}

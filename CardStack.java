// This file contains two functions cardInteger and integerCard which changes the card from string to integer, vice versa
// It also has a main function which requests the user to input the row, column, cards, and orientation
// Using that information, it flips all the cards onto one stack and outputs all the face down cards in order

import java.util.Scanner;
public class CardStack 
{
	// Turns a string input to an integer by looking at each character and determining where it corresponds to between -52 and 52
	public static int cardInteger(String card)  
	{
		card = card.toUpperCase();
		int first = 0, second = 0, third = 0;
		char orientation = card.charAt(0);
		char suit= card.charAt(1);
		char value= card.charAt(2);
		
		// Orientation
		if (orientation == 'U')
			first = 1;
		else if(orientation == 'D')
			first = -1;
		
		// Suits
		if (suit == 'C')
			second=0;
		else if (suit == 'H')
			second=13;
		else if (suit == 'S')
			second=26;
		else if (suit == 'D')
			second=39;
		
		// Value 
		switch(value)
		{
		case 'A':
			third = 1;
			break;
		case '2':
			third = 2;
			break;
		case '3':
			third = 3;
			break;
		case '4':
			third = 4;
			break;
		case '5':
			third = 5;
			break;
		case '6':
			third = 6;
			break;
		case '7':
			third = 7;
			break;
		case '8':
			third = 8;
			break;
		case '9':
			third = 9;
			break;
		case 'T':
			third = 10;
			break;
		case 'J':
			third = 11;
			break;
		case 'Q':
			third = 12;
			break;
		case 'K':
			third = 13;
			break;
		default:
			third = 0;
			break;

		}
		return first*(second+third);
	}
	
	// Turns a integer input to an string by looking at position of the number and determining the character 
	public static String integerCard(int number)
	{
		String card = "AAA";
		String suit;
		String value = " ";
		number = -1*number;
		
		// Suits
		if (number <=13)
			suit = "C";
		else if (number <=26)
		{
			suit = "H";
			number = number - 13;
		}
			
		else if (number <= 39)
		{
			suit = "S";
			number = number - 26;
		}
		else 
		{
			suit = "D";
			number = number - 39;
		}
			
		
		// Value 
		switch(number)
		{
		case 1:
			value = "A";
			break;
		case 2:
			value = "2";
			break;
		case 3:
			value = "3";
			break;
		case 4:
			value = "4";
			break;
		case 5:
			value = "5";
			break;
		case 6:
			value = "6";
			break;
		case 7:
			value = "7";
			break;
		case 8:
			value = "8";
			break;
		case 9:
			value = "9";
			break;
		case 10:
			value = "T";
			break;
		case 11:
			value = "J";
			break;
		case 12:
			value = "Q";
			break;
		case 13:
			value = "K";
			break;
		
		default:
			break;

		}
		card = suit + value;
		return card;
	}
	
	public static void main(String []args)
	{ 
		int n = 1, m = 1; //n = rows, m = columns
		int oRow = -1, oCol = 0;
		String output[][] = new String[400][400];
		Scanner sc= new Scanner(System.in); 
		
		while(n != 0 && m !=0) // if user inputs "0 0" it terminates
		{	
			oRow++;  
			n= sc.nextInt(); 
			m=sc.nextInt();
			
			// Getting information about cards
			StackUsingLinkedlist <Integer> CardPile[][]= new StackUsingLinkedlist[n][m];
			
			for (int i = 0; i < n; i++) 
			{
				for(int j=0;j<m;j++) 
				{
					StackUsingLinkedlist <Integer> cardobj = new StackUsingLinkedlist();
					String card = sc.next(); 		
					CardPile[i][j] = cardobj;
					
					if (cardInteger(card) == 0) // if the string input is not valid, terminate
					{
						n = 0;
						m = 0;
						break;
					}
					CardPile[i][j].push(cardInteger(card)); 
				}			
			}
			
			int LCounter = 0;
			int RCounter = 0;
			int TCounter = 0;
			int BCounter = 0;
			
			Flips flip_obj = new Flips();
			if (n+m > 2) // if the matrix is not 1 by 1
			{
				String flip = sc.next(); 
				for (int i = 0; i<(n+m-2); i++) // assigns the correct function based on the character
				{
					flip = flip.toUpperCase();
					char flipValue = flip.charAt(i);
					switch(flipValue)
					{
						case 'L':
							flip_obj.LeftFlip(CardPile,n,m,LCounter);
							LCounter++;
							break;
						case 'R':
							flip_obj.RightFlip(CardPile,n,m,RCounter);
							RCounter++;
							break;
						case 'T':
							flip_obj.TopFlip(CardPile,n,m,TCounter);
							TCounter++;
							break;
						case 'B':
							flip_obj.BottomFlip(CardPile,n,m,BCounter);
							BCounter++;
							break;
						default:
							break;
					}			
				}
			}
			
			for (int i = 0; i < n; i++) // Check the whole array 
			{
			    for (int j = 0; j < m; j++) 
			    {
			    	while (CardPile[i][j].peek() != 0) // If this location in the linked list is not empty, run
			    	{
			    		if (CardPile[i][j].peek() < 0) // if the card is face down, keep it in the array "output"
			    		{
			    			output[oRow][oCol] = integerCard(CardPile[i][j].peek()); 
			    			CardPile[i][j].pop();
			    			oCol++;
			    		}
			    		else 
			    		{
			    			CardPile[i][j].pop();
			    		}
			    	}
			    }
			}
			
			//Results
			if (n !=0 & m!=0)
				System.out.print("Test " + (oRow+1) + ":");
			
			for (int b = oCol; b >= 0; b--) //output the face down cards, skipping null values
			{
				if (output[oRow][b] == null)
				{
					continue;
				}
				else
				{
					System.out.print(" ");
					System.out.print(output[oRow][b]);
				}	
			}
			System.out.println("");		
		}
		sc.close();
	}
}

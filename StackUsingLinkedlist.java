// This file creates a linked list using a stack
// It creates nodes and linked them to each other
// It has functions like push, isEmpty, peek and pop

class StackUsingLinkedlist <T> 
{
	private class Node 
	{
		int info; 
		Node next; // reference variable next
	}
	
	Node head;
	StackUsingLinkedlist() // Constructor without parameters
	{ 
		this.head = null; 
	}

	public void push(int x) // Adds a new element to the top of the stack
	{
		Node temp = new Node();
		temp.info = x;
		temp.next = head;
		head = temp;
	}

	public boolean isEmpty() 
	{ 
		return head == null; 
	}
	
	public int peek() // Return top value of stack 
	{
		if (!isEmpty()) // check for empty stack
		{
			return head.info;
		}
		
		else 
		{
			return 0;
		}
	}
	
	public void pop() // remove the top value of stack
	{
		if (head == null) // Check whether there is a value to remove
		{
			System.out.print("No Value in the stack");
			return;
		}
		head = (head).next; // point head to next link
	}
}


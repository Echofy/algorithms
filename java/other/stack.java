package ds.cla;

import java.io.*;

class Stack
{
	private int maxSize;
	private int [] stackArr;
	private int top;

	public Stack(int mx)
	{
		maxSize = mx;
		stackArr = new int[maxSize];
		top = -1;
	}

	public boolean isEmpty()
	{
		return (top == -1);
	}

	public boolean isFull()
	{
		return (top == maxSize-1);
	}

	public boolean push(int value)
	{
		if(isFull())
			return false;

		stackArr[++top] = value;
		return true;
	}

	public int pop()
	{
		if(isEmpty())
			return -999;

		return stackArr[top--];
	}

	public int peek()
	{
		if(isEmpty())
			return -999;

		return stackArr[top];
	}
} // end class stackArr


class StackApp
{
	public static void main(String [] args)
	{
		Stack theStack = new Stack(20);
		int value;

		theStack.push(10);
		theStack.push(30);
		theStack.push(20);
		theStack.push(56);
		theStack.push(19);
		theStack.push(31);
		theStack.push(8);

		while(!theStack.isEmpty())
		{
			value = theStack.pop();
			System.out.print(value + " ");
		}

	} // end main

} // end class StackApp
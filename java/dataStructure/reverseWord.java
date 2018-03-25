// reverse a word using stack

//package datastruc.aid;
import java.io.*;

class Reverse
{
	public static void main(String [] args) throws IOException
	{
		Stack theStack = new Stack (20);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a string: ");
		String str = br.readLine();

		for(int i = 0; i < str.length(); i++)
			theStack.push(str.charAt(i));

		System.out.print("output the reverse string: ");
		for(int i = 0; i < str.length(); i++)
			System.out.print((char)theStack.pop());
	} // end main

} // end class Reverse
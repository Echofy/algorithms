// 括号（大、中、小括号）匹配问题

package other.cla;

import java.io.*;

class Checker {
	private String input;

	public Checker(String _input) {
		input = _input;
	}

	// 检查括号是否匹配
	public boolean delicheck() {
		int len = input.length();
		Stack theStack = new Stack(len);
		char ch, chx;
		int i;

		for(i = 0; i < len; i++) {
			ch = input.charAt(i);
			switch(ch) {
				case '(':
				case '[':
				case '{':
				theStack.push(ch);
				break;

				case ')':
				case ']':
				case '}':
				if(!theStack.isEmpty()) {
					chx = (char)theStack.pop();
					if((chx == '(' && ch != ')') || (chx == '[' && ch != ']') || (chx == '{' && ch != '}')) {
						System.out.print("deli Error happen in " + i);
						return false;
					}					
				}

				else {
					System.out.println("missing left delimiters!");
					return false;
				}
				break;

				default:
				break;
			} // end switch
		} // end for

		if(!theStack.isEmpty()) {
			System.out.println("missing right delimiters!");
			return false;
		}
		else {
			System.out.print("this string is correct!");
			return true;
		}
	} // end func delicheck
} // end class checker

// 测试类
class delimetersApp {
	public static void main(String [] args) throws IOException {
		System.out.print("Enter string: ");
		String str = getString();

		Checker theCheck = new Checker(str);
		theCheck.delicheck();		
	} // end main

	public static String getString() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		return str;
	}
} // end class delimetersApp
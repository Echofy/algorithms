package datastru.cla;

import java.io.*;

// 栈

class Stack {
	private int maxSize;
	private int [] stackArr;
	private int top;

	public Stack(int mx) {
		maxSize = mx;
		stackArr = new int[maxSize];
		top = -1;
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return (top == -1);
	}

	// 判断栈是否已满
	public boolean isFull() {
		return (top == maxSize-1);
	}

	// 入栈
	public boolean push(int value) {
		if(isFull())
			return false;

		stackArr[++top] = value;
		return true;
	}

	// 出栈
	public int pop() {
		if(isEmpty())
			return -999;

		return stackArr[top--];
	}

	// 访问
	public int peek() {
		if(isEmpty())
			return -999;

		return stackArr[top];
	}
} // end class stackArr

// 测试类
class StackApp {
	public static void main(String [] args) {
		Stack theStack = new Stack(20);
		int value;

		theStack.push(10);
		theStack.push(30);
		theStack.push(20);
		theStack.push(56);
		theStack.push(19);
		theStack.push(31);
		theStack.push(8);

		while(!theStack.isEmpty()) {
			value = theStack.pop();
			System.out.print(value + " ");
		}
	} // end main
} // end class StackApp
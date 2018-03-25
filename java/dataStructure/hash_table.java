package datastru.cla;

import java.io.*;
import java.util.*;
import java.lang.Integer;
import java.lang.Math.*;

// create a hash table using linear proto and relative operation

// create class hash array
class HashArray {
	public int iData;

	public HashArray(int ii) {
		iData = ii;
	}
}// end class HashArray

// create class hash table
class HashTable  {
	private HashArray [] hashArray;
	private int size;
	private HashArray nonItem;

	public HashTable(int _size) {
		size = _size;
		hashArray = new HashArray[size];
		nonItem = new HashArray(-1);
	}

	// 哈希函数
	public int hashFunc(int key) {
		return key % size;
	}

	// 按顺序显示哈希表中的元素
	public void display() {
		System.out.print("hash table: ");
		for(int i = 0; i < size; i++)
			if(hashArray[i] != null)
				System.out.print(hashArray[i].iData + " ");
			else
				System.out.print("** ");
		System.out.println();
	}

	// 插入
	public boolean insert(int key) {
		int hashVal = hashFunc(key);
		int count = 0;

		while(hashArray[hashVal] != null && hashArray[hashVal].iData != -1) {
			hashVal ++;
			hashVal %= size;
			count ++;
			if(count == size){
				System.out.println("Hash table is full!");
				return false;
			}	
		}
		HashArray keyhash = new HashArray(key);
		hashArray[hashVal] = keyhash;
		return true;
	}

	// 查找
	public HashArray find(int key) {
		int hashVal = hashFunc(key);

		while(hashArray[hashVal] != null) {	
			if(hashArray[hashVal].iData == key)
				return hashArray[hashVal];
			
			hashVal ++;
			hashVal %= size;
		}
		return null;
	}

	// 删除
	public HashArray delete(int key) {
		int hashVal = hashFunc(key);

		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].iData == key) {
				hashArray[hashVal].iData = -1;
				return hashArray[hashVal];
			}
			hashVal ++;
			hashVal %= size;
		}
		return null;
	}
}// end class HashTable


// 测试类
class HashApp {
	public static void main(String [] args) throws IOException {
		int size, n, keyPerCell, key;
		boolean inresult;
		keyPerCell = 10;

		putText("Enter size of hash array: " );
		size = getInt();
		putText("Enter initial size of hash table: ");
		n = getInt();
		HashTable thehash = new HashTable(size);

		for(int i = 0; i < n; i++) {
			key = (int)(Math.random() * keyPerCell * size);
			thehash.insert(key);
		}

		while(true) {
			putText("Enter operations of show, insert, delete, find:  ");

			char ord = getChar();

			switch (ord) {
				case 's':
				thehash.display();
				break;

				case 'i':
				putText("Enter the key you want to insert: ");
				key = getInt();
				thehash.insert(key);
				break;

				case 'd':
				putText("Enter the key you want to delete: ");
				key = getInt();
				HashArray result = thehash.delete(key);
				if(result != null)
					putText("Delete key!" + '\n');
				else
					putText("Not delete key!" + '\n');
				break;

				case 'f':
				putText("Enter the key you want to find: ");
				key = getInt();
				result = thehash.find(key);
				if(result != null)
					putText("Found key!" + '\n');
				else
					putText("Not find key!" + '\n');
				break;

				default:
				putText("invalid entry!" + '\n');
			}
		}
	} // end main

	// 显示字符串
	public static void putText(String str) {
		System.out.print(str);
		System.out.flush();
	}

	// 从键盘获取字符串
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		return str;
	}

	// 从键盘获取字符
	public static char getChar() throws IOException {
		String str = getString();
		return str.charAt(0);
	}

	// 从键盘获取整型数
	public static int getInt() throws IOException {
		String str = getString();
		return Integer.parseInt(str);
	}
} // end class HashApp
package ans.cla;

import java.util.*;

class reConstructTest
{
	public static void main(String [] args)
	{
		int [] pre = {1,2,4,3,5,6};
		int [] in = {4,2,1,5,3,6};
		Node root = reConstructBinaryTree(pre, in);

		BinaryTree bt = new BinaryTree(0);

		//bt.insert(10);

		bt.cpTree(root);

		bt.levelTravel();

	} // end main

	public static Node reConstructBinaryTree(int [] pre,int [] in) {
        
        if(pre.length == 1) {
            Node root = new Node(pre[0]);
            return root;
        }

        if(pre.length == 0) 
        	return null;
            
        int i;
        for(i = 0; i < in.length; i++)
            if(in[i] == pre[0])
                break;
        
        int [] inLeft = new int[i];
        int [] preLeft = new int[i];
        int [] inRight = new int[in.length-i-1];	
        int [] preRight = new int[in.length-i-1];
        
        for(int j = 0; j < i; j++) {
            inLeft[j] = in[j];
            preLeft[j] = pre[j+1];
        }
        
        for(int j = 0; j < in.length-i-1; j++) {
            inRight[j] =  in[j+i+1];
            preRight[j] = pre[j+i+1];
        }
            
        Node root = new Node(pre[0]);
        root.left = reConstructBinaryTree(preLeft, inLeft);
        root.right = reConstructBinaryTree(preRight, inRight);
        
        return root;
    }

} // end class test
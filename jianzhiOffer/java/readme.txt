ReconstructBinaryTree.java: reconstruct binary tree given inorder and preorder sequence.

idea: 

	let's think about binary tree's inorder and preorder suquence, for example:

	                                1
	                    2       				3   
                4				5		6				7
            8		9	                                 	10

    level travel: 1 2 3 4 5 6 7 8 9 10    

    inorder travel: 8 4 9 2 5 1 6 3 7 10   (in[])
    preorder travel: 1 2 4 8 9 5 3 6 7 10  (pre[])

    we can find that:

    	1. root = pre[0]
    	2. when we find the root, we can use root to seperate inorder sequence to two part, namely left and right sub-tree;
    	3. and we know that pre[1] is the root of pre[0]'s left tree, and pre[2] is the root of pre[1]'s root, 


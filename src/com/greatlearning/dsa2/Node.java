package com.greatlearning.dsa2;

//Class of the node

public class Node {
	
	int value;
	Node left, right;
	
	/* Function that allocates a new node with the given data
	 * and Null left and right pointers */
	
	Node(int data)
	{
		value = data;
		left = null;
		right = null;
	}
}

class Main {
	
	public static Node node;
	static Node previousNode = null;
	static Node headNode = null;
	
	//Function to convert the binary search tree into skewed tree in ascending order
	
	static void BSTToSkewedTree(Node root, int order) {
		
		//Base case
		
		if(root == null)
		{
			return;
		}
		
		//Condition to check the order in which skewed tree to be maintained
		
		if(order>0)
		{
			BSTToSkewedTree(root.right, order);
		}
		else
		{
			BSTToSkewedTree(root.left, order);
		}
		
		Node rightNode = root.right;
		Node leftNode = root.left;
		
		//Condition to check if the root node of the skewed tree is not defined
		
		if(headNode == null)
		{
			headNode = root;
			root.left = null;
			previousNode = root;
		}
		else
		{
			previousNode.right = root;
			root.left = null;
			previousNode = root;
		}
		
		//Recurse for the left / right subtree
		
		if(order>0)
		{
			BSTToSkewedTree(leftNode, order);
		}
		else
		{
			BSTToSkewedTree(rightNode, order);
		}
	}
	
	//Function to traverse the right skewed using recursion
	
	static void TraverseRightSkewed(Node root) {
		
		if(root==null)
		{
			return;
		}
		System.out.println(root.value + " ");
		TraverseRightSkewed(root.right);
	}
	
	//Driver Code
	
	@SuppressWarnings("static-access")
	public static void main (String[] args)
	{
		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);
		
		//Order of skewed tree for ascending order can be defined as 0
		//In case if we want to try for descending order then order to be defined as 1
		
		int order = 0;
		BSTToSkewedTree(node,order);
		TraverseRightSkewed(headNode);
	}
}


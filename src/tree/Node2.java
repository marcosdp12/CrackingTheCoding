package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node2 {
	
	int info;
	Node2 right;
	Node2 left;

	public Node2(int _info, Node2 _left, Node2 _right) {
		info = _info;
		right = _right;
		left = _left;
	}
	
	public String traverse(Node2 tree){
		if(tree == null) return null;
		String out = "";
		Queue<Node2> toVisit = new LinkedList <Node2>();//como instanciar lista
		toVisit.add(tree);
		while(toVisit.isEmpty()==false){
			Node2 curr = toVisit.remove();
			out = out + " " + curr.info;
			if(curr.left != null) toVisit.add(curr.left);
			if(curr.right != null) toVisit.add(curr.right);
		}
		return out;
	}
	
	/* Given a tree, write a function to convert it into a circular doubly linked list from 
	 * left to right by only modifying the existing pointers.
	 */
	public void changeTreeToDoubleLinkedList(Node2 tree){
		Stack <Node2> stack = new Stack <Node2> (); 
		stack = OrdCentralEmPilha(tree, stack);
		
		Node2 first = stack.pop();
		Node2 runner = first;
		Node2 actual = null;
		
		while (!stack.isEmpty()){
			actual = stack.pop();
			actual.right = runner;
			runner.left = actual;
			runner = actual;
		}
		if(actual!= null){
			first.right = actual;
			actual.left  = first;
		}
	}
	
	private Stack <Node2> OrdCentralEmPilha(Node2 n, Stack <Node2> stack){
		if(n.left == null && n.right == null){
			stack.push(n);
			return stack;
		}
		else {
			if(n.left!=null)
				stack = OrdCentralEmPilha(n.left, stack);
			stack.push(n);
			if(n.right!=null)
				stack = OrdCentralEmPilha(n.right,stack);
			return stack;
		}
	}
	
	public static void main(String[] args){
		Node2 n2 = new Node2(2, new Node2(4,null,null), new Node2(5,null,null));
		Node2 n3 = new Node2(3, new Node2(6,null,null), new Node2(7,null,null));
		Node2 n1 = new Node2(1,n2,n3);
		
		//System.out.println(n1.traverse(n1));
		
		n1.changeTreeToDoubleLinkedList(n1);
		Node2 node;
		for(node = n1; node.right != n1; node = node.right){
			System.out.print(node.info + " ");
		}
		System.out.print(node.info + " ");
	}

}

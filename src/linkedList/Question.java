package linkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Question {

	public Question() {
		
	}
	/*Given a linked list, write a function that prints the nodes od the list in reverse order.*/
	static public void printReversedListMyWay(Node L){
		if(L == null) return;
		Stack <Integer> stack = new Stack <Integer> ();
		
		for(Node runner = L; runner!=null; runner = runner.next){
			stack.push(runner.getId());
		}
		while(!stack.isEmpty()) System.out.println(stack.pop());
	}
	
	static public void printReversedList(Node n){
		if(n == null) return;
		printReversedList(n.next);
		System.out.println(n.getId());
	}
	
	/* Write code to remove duplicates from an unsorted linked list. */
	static void removeDuplicates(Node head){
		while(head!=null){
			Node actual = head;
			while(actual.getNext()!=null){
				if(actual.getNext().getId()!=head.getId()){
					actual = actual.next;
				}
				else actual.next = actual.getNext().getNext();
			}
			head = head.getNext();
		}
	}
	
	static void removeDup(Node list){
		if(list == null) return;
		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(list.getId());
		Node runner = list.next;
		Node previous = list;
		while(runner!=null){
			if(numbers.contains(runner.getId())){
				previous.next = runner.next;
				runner = previous.next;
			}
			else{
				numbers.add(runner.getId());
				runner = runner.next;
				previous = previous.next;
			}			
		}
	}
	
	/* Divide a given Linked List in two */
	static public Node divide(Node list){
		if(list == null) return null;
		Node runner = list.next;
		
		while(runner!=null){
			runner = runner.next;
			if(runner==null) break;
			runner = runner.next;
			list = list.next;	
		}
		Node toReturn = list.next;
		list.next = null;
		return toReturn;
	
	}
	
	public static Node divideMyWay(Node L){
		Node p = L;
		Node q = L;
		
		if(p.next == null||p == null)
			return null;
		
		if(p.next.next==null){
			q = q.next;
			p.next = null;
			return q;
		}
		else p = p.next.next;
		
		while(p.next!=null && p.next.next!=null){
			p = p.next.next;
			q = q.next;
		}
		q = q.next;

		Node List = q.next;
		q.next = null;
		return List;
		
	}
	
	/*Given a linked list, write a function to determine whether the list is a palindrome*/
	static public boolean isPalindromeMyWay(Node list){
		if(list == null) return false;
		
		Stack <Node> stack = new Stack<Node>(); //como instanciar Stack
		stack.push(list);
		int num = 1;
		
		Node runner = list.next;
		
		while(runner!=null){
			num++;
			runner = runner.next;
			if(runner==null) break;
			num++;
			runner = runner.next;
			list = list.next;	
			stack.push(list);
		}
		
		if(num%2!=0) stack.pop();
		
		while(!stack.isEmpty()){
			list = list.next;
			if(list.getId() != stack.pop().getId())
				return false;
		}
		return true;
	}
	
	static public boolean isPalindrome(Node n){
		Node curr = n;
		Node runner = n;
		Stack<Integer> stack = new Stack <Integer>(); //como instanciar uma pilha
		
		while(runner != null && runner.next!=null){
			stack.push(curr.getId());
			curr = curr.next;
			runner = runner.next.next;
		}
		if(runner!=null) curr = curr.next;
		while(curr!=null){
			if(stack.pop().intValue() != curr.getId()) return false;
			curr = curr.next;
		}
		return true;		
	}
	
	/*Given a number, write a function to rotate the bits (ie circular shift).
	 * eg. rotate(0xFFFF0000,8) = 0x00FFFF00
	 */
	public int rotate(int x, int N){
		return (x >> N | x << (32-N));
	}
}

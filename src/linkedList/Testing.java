package linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {
	
	@Test
	public void testingRemoveDuplicates() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		Node n4 = new Node(1);
		Node n5 = new Node(1);
		Node n6 = new Node(4);
		
		n5.next = n6;
		n4.next = n5;
		n3.next = n4;
		n2.next = n3;
		n1.next = n2;
		
		
		Question.removeDuplicates(n1);
		assertEquals(" 1 2 4", n1.printListFromThisNode());
		//System.out.println(n1.printListFromThisNode());
	}
	
	@Test
	public void testingDivide() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		
		n2.next = n3;
		n1.next = n2;	
		
		Node list2 = Question.divide(n1);
		
		//System.out.println(n1.printListFromThisNode());
		//System.out.println(list2.printListFromThisNode());
		
		//System.out.println(n1.printListFromThisNode());
	}
	
	@Test
	public void testins_isPalindrome() {
		Node n1 = new Node(1);
		
		assertEquals(true, Question.isPalindrome(n1));
	}

}

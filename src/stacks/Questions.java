package stacks;

import java.util.Stack;

public class Questions {
	/*Given a stack, sort the elements in the stack using no more than one additional stack.*/
	public static Stack<Integer> sortingStackMyWay(Stack<Integer> s1){
		if(s1 == null||s1.isEmpty()) return s1;
		Stack <Integer> s2 = new Stack <Integer> ();
		int temp;
		while(!s1.isEmpty()){
			temp = (int) s1.pop();
			while(!s2.isEmpty() && temp > s2.peek()){
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		return s2;
	}
	
	/*Given a stack, reverse the items in the stack without using any additional datastructures.*/
	public static Stack <Integer> reverse(Stack<Integer> stack){
		if(stack.isEmpty()) return stack;
		int temp = stack.pop();
		stack = reverse(stack);
		insertAtBottom(stack, temp);
		return stack;
	}
	
	private static void insertAtBottom(Stack<Integer> stack, int x){
		if(stack.isEmpty()){ 
			stack.push(x);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack,x);
		stack.push(temp);
	}
	
	public static boolean isValid(String s) {
        if(s.equals("")||s == null) return false;
        Stack <Character> stack = new Stack <Character>();
        
        for(int j = 0; j < s.length(); j++){
            Character temp = new Character(s.charAt(j));
            if(temp.equals('(')||temp.equals('{')||temp.equals('['))
                stack.push(temp);
            else if(!stack.isEmpty()){
                if(temp.equals(')'))
                    if(!stack.pop().equals('(')) 
                    	return true;
                else if (temp.equals(']'))
                    if(!stack.pop().equals('['))
                    	return false;
                else if (temp.equals('}'))
                    if(!stack.pop().equals('{'))
                    	return true;
            }
            //else return false;
        }
        if(stack.isEmpty())
            return true; 
		return false;
	}
	
	
	public static void main(String[] args) {
		/*Stack <Integer> A = new Stack <Integer>();
		A.push(5);
		A.push(1);
		A.push(3);
		A.push(9);
		A.push(2);*
		
		//A = Questions.sortingStackMyWay(A);
		A = Questions.reverse(A);
		while(!A.isEmpty()){
			System.out.print(A.pop() + " ");
		}*/
		System.out.print(Questions.isValid("({})"));
	}

}

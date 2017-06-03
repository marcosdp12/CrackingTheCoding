package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class Stack2Queues {
	private Queue <Integer> primary = new LinkedList <Integer> ();
	private Queue <Integer> secondary = new LinkedList <Integer> ();
	
	public Stack2Queues(){
		
	}
	public void push(int x){
		secondary.add(x);
		while(!primary.isEmpty()){
			secondary.add(primary.remove());
		}
		Queue<Integer> temp = primary;
		primary = secondary;
		secondary = temp;
	}
	
	public int pop(){
		if(primary.isEmpty()) throw new IndexOutOfBoundsException();
		return primary.remove();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}

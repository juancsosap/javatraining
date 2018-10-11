package P12_Collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class E08_ArrayDeque {

	public static void main(String[] args) {
		
		// ------ FIFO ------
		
		Deque<String> queue = new ArrayDeque<>(); 
		
		queue.add("One");
		queue.add("Two");
		queue.add("Three");
		queue.add("Four");
		queue.add("Five");
		
		while(!queue.isEmpty()) {
			String value =  queue.remove();
			System.err.print(value + "  ");
		}
		
		System.out.println();
		
		// ------ FILO ------
		
		Deque<String> stack = new ArrayDeque<>(); 
		
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		stack.push("Four");
		stack.push("Five");
		
		while(!stack.isEmpty()) {
			String value =  stack.pop();
			System.err.print(value + "  ");
		}
		
	}

}

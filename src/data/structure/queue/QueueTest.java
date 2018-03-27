package data.structure.queue;

import java.util.Random;

public class QueueTest {

	public static void main(String[] args) {
		System.out.println("****************** Max Heap *****************");
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for(int i=0; i<10; i++) {
			maxHeap.insert(random.nextInt(100));
		}
		
		System.out.println(maxHeap);
		
		for(int i=0; i<10; i++) {
			System.out.println(maxHeap.getMax() + " " +maxHeap.delMax());
		}
		
		System.out.println("****************** Max Heap *****************");
		
		MinHeap<Integer> minHeap = new MinHeap<>();
		for(int i=0; i<10; i++) {
			minHeap.insert(random.nextInt(100));
		}
		
		System.out.println(minHeap);
		
		for(int i=0; i<10; i++) {
			System.out.println(minHeap.getMin() + " " +minHeap.delMin() + " , Current Size - " + minHeap.size());
		}
		
		System.out.println("***************** Stack (Array backed) ****************");
		
		Stack<Character> stack = new Stack<>();
		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');
		
		System.out.println(stack.peek());
		
		stack.pop();
		stack.pop();
		
		stack.push('E');
		stack.push('F');
		
		System.out.println(stack.size());
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

		
		stack.push('A');
		stack.push('B');
		stack.push('C');
		stack.push('D');
		stack.push('E');
		stack.push('F');
		stack.push('H');
		stack.push('I');
		stack.push('J');
		stack.push('K');
		stack.push('L');
		stack.push('M');
		
		System.out.println(stack);
		
		System.out.println("***************** Stack DLL backed ****************");
		StackDLL<Character> stackDLL = new StackDLL<>();
		stackDLL.push('A');
		stackDLL.push('B');
		stackDLL.push('C');
		stackDLL.push('D');
		
		System.out.println(stackDLL.peek());
		
		stackDLL.pop();
		stackDLL.pop();
		
		stackDLL.push('E');
		stackDLL.push('F');
		
		System.out.println(stackDLL.size());
		
		stackDLL.pop();
		stackDLL.pop();
		stackDLL.pop();
		stackDLL.pop();

		
		stackDLL.push('A');
		stackDLL.push('B');
		stackDLL.push('C');
		stackDLL.push('D');
		stackDLL.push('E');
		stackDLL.push('F');
		stackDLL.push('H');
		stackDLL.push('I');
		stackDLL.push('J');
		stackDLL.push('K');
		stackDLL.push('L');
		stackDLL.push('M');
		
		System.out.println(stackDLL);
		
		System.out.println("******************* Stack SLL backed ***********************");
		
		StackSLL<Character> stackSLL = new StackSLL<>();
		stackSLL.push('A');
		stackSLL.push('B');
		stackSLL.push('C');
		stackSLL.push('D');
		
		System.out.println(stackSLL.peek());
		
		stackSLL.pop();
		stackSLL.pop();
		
		stackSLL.push('E');
		stackSLL.push('F');
		
		System.out.println(stackSLL.size());
		
		stackSLL.pop();
		stackSLL.pop();
		stackSLL.pop();
		stackSLL.pop();

		
		stackSLL.push('A');
		stackSLL.push('B');
		stackSLL.push('C');
		stackSLL.push('D');
		stackSLL.push('E');
		stackSLL.push('F');
		stackSLL.push('H');
		stackSLL.push('I');
		stackSLL.push('J');
		stackSLL.push('K');
		stackSLL.push('L');
		stackSLL.push('M');
		
		System.out.println(stackSLL);
	}
	
}

package data.structure.queue;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

	@Test
	public void testStackArrayBased() {
		System.out.println("***************** Stack (Array backed) ****************");

		Stack<Character> stack = new Stack<>(10, Comparator.<Character>naturalOrder());
		stack.push('D');
		stack.push('C');
		stack.push('B');
		stack.push('A');

		System.out.println("Peek - " + stack.peek());
		System.out.println("Min - " + stack.min());

		
		System.out.println("Popped - " + stack.pop());
		System.out.println("Min - " + stack.min());
		
		
		System.out.println("Popped - " + stack.pop());
		System.out.println("Min - " + stack.min());

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
	}

	@Test
	public void testStackDLLBased() {
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
	}

	@Test
	public void testStackSLLBased() {
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
	
	@Test
	public void testQueueArrayBased() {
		IQueue<Integer> q = new ArrayBasedQueue<>(10);
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		System.out.println(q);
		System.out.println("Dequed - " +q.deQueue());
		System.out.println("Dequed - " +q.deQueue());
		System.out.println("Dequed - " +q.deQueue());
		System.out.println(q);
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		System.out.println(q);
		System.out.println("Dequed - " +q.deQueue());
		System.out.println("Dequed - " +q.deQueue());
		System.out.println("Dequed - " +q.deQueue());
		try {
			System.out.println("Dequed - " +q.deQueue());
			Assert.assertTrue(false);
		} catch(Exception e) {
			Assert.assertTrue(true);
		}
	}

}

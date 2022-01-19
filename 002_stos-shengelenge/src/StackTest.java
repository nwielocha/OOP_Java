import org.junit.*;

import static org.junit.Assert.assertEquals;

public class StackTest {

	@Test
	public void testPopAfterPush() {
		Stack stack = new Stack();
		stack.push(10);
		int result = stack.pop();

		assertEquals("pop after push", 0, result);
	}

	@Test
	public void testPeekAfterPush() {
		Stack stack = new Stack();
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(5);

		int result = stack.peek();

		assertEquals("peek after push", 5, result);
	}

	@Test
	public void testEmptyPop() {
		Stack stack = new Stack();
		int result = stack.pop();

		assertEquals("empty pop", 0, result);
	}

	@Test
	public void testEmptyPeek() {
		Stack stack = new Stack();
		int result = stack.peek();

		assertEquals("empty peek", 0, result);
	}
	/*
	@Test
	public void testPush30ElementsAndPop30Elements() {
		Stack stack = new Stack();
	}
*/

}

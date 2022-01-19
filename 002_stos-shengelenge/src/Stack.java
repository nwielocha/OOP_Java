public class Stack {
	private int [] elements = new int[10];
	private int top = 0;

	public boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}

	public void push(int element) {
		top = top + 1;
		elements[top] = element;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("niedomiar");
		}
		else {
			top = top - 1;
			return elements[top];
		}

		return 0;
	}

	public int peek() {
		if (isEmpty())
			System.out.println("niedomiar");
		else
			return elements[top];

		return 0;
	}
}

public class Calculator {
	private int state = 0;
	private boolean error = false;
	private final int reset = 0;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		if (!error)
			this.state = state;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
		this.state = reset;
	}

	public void add(int value) {
		if (Integer.MAX_VALUE - state < value)
			setError(true);
		else
			state += value;
	}

	public void mult(int value) {
		state *= value;
	}

	public void sub(int value) {
		state -= value;
	}

	public void	div(int value) {
		if (value == 0)
			setError(true);
		else
			state /= value;
	}

}

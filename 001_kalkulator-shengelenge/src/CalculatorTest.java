import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

	@Test
	public void testAddOne() {
		// Arrange
		// sut = System Under Test
		Calculator sut = new Calculator();
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState());
	}

	@Test
	public void testErrorState_whenMoreThenMAX_VALUE() {
		Calculator sut = new Calculator();
		sut.add(Integer.MAX_VALUE);
		sut.add(1);
		assertTrue(" ", sut.isError());
	}

	@Test
	public void testMultOneByTwo() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState());
	}

	@Test
	public void testMultByZero() {
		Calculator sut = new Calculator();
		sut.mult(0);
		assertEquals("0*0 = 0", 0, sut.getState());
	}

	@Test
	public void testSubOne() {
		Calculator sut = new Calculator();
		sut.sub(1);
		assertEquals("0-1 = -1", -1, sut.getState());
	}

	@Test
	public void testDivZeroByOne() {
		Calculator sut = new Calculator();
		sut.setState(0);
		sut.div(1);
		assertEquals("0/1 = 0", 0, sut.getState());
	}

	@Test
	public void testDivOneByOne() {
		Calculator sut = new Calculator();
		sut.setState(1);
		sut.div(1);
		assertEquals("1/1 = 1", 1, sut.getState());
	}

	@Test
	public void testDivByZero() {
		Calculator sut = new Calculator();
		sut.setState(0);
		sut.div(0);
		assertTrue(" ", sut.isError());
	}

}

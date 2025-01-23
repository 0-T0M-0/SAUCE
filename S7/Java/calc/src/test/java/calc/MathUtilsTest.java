package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.MathUtils;

class MathUtilsTest {
	
	private MathUtils mathUtils;

    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }

	@Test
	void testAddOperator() {
		mathUtils.addValue(10);
        mathUtils.addOperator("+");
        mathUtils.addValue(5);
        mathUtils.calculateResult();
        assertEquals(15, mathUtils.getCurrentValue());
	}
	
	@Test
	void testSubstractOperator() {
		mathUtils.addValue(10);
        mathUtils.addOperator("-");
        mathUtils.addValue(5);
        mathUtils.calculateResult();
        assertEquals(5, mathUtils.getCurrentValue());
	}
	
	@Test
	void testMultiplyOperator() {
		mathUtils.addValue(10);
        mathUtils.addOperator("*");
        mathUtils.addValue(5);
        mathUtils.calculateResult();
        assertEquals(50, mathUtils.getCurrentValue());
	}
	
	@Test
	void testDivideOperator() {
		mathUtils.addValue(10);
        mathUtils.addOperator("/");
        mathUtils.addValue(5);
        mathUtils.calculateResult();
        assertEquals(2, mathUtils.getCurrentValue());
	}
	
	@Test
	void testModuloOperator() {
		mathUtils.addValue(10);
        mathUtils.addOperator("%");
        mathUtils.addValue(3);
        mathUtils.calculateResult();
        assertEquals(1, mathUtils.getCurrentValue());
	}
	
	@Test
	void testDivideBy0() {
		mathUtils.addValue(10);
        mathUtils.addOperator("/");
        mathUtils.addValue(0);
        assertEquals(.NaN, mathUtils.calculateResult());
	}

}

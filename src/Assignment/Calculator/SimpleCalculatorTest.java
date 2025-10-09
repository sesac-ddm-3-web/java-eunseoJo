package Assignment.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    @Test
    void add() {
        // Given
        SimpleCalculator calculator = new SimpleCalculator();
        int num1 = 5;
        int num2 = 3;
        // When
        int result = calculator.add(num1, num2);
        // Then
        assertEquals(8, result);
    }

    @Test
    void div() {
        // Given
        SimpleCalculator calculator = new SimpleCalculator();
        int num1 = 6;
        int num2 = 2;
        // When
        double result = calculator.div(num1, num2);
        // Then
        assertEquals(3, result);
    }
    @Test
    void div_zero(){
        // Given
        SimpleCalculator calculator = new SimpleCalculator();

        // when
        ArithmeticException e = Assertions.assertThrows(ArithmeticException.class, ()-> calculator.div(3, 0));

        // Then
        assertEquals("ZERO X", e.getMessage());
    }

    @Test
    void calculate() {
        // Given
        SimpleCalculator calculator = new SimpleCalculator();
        String expression = "1 + 2 * 3";

        // When
        double result = calculator.calculate(expression);

        // Then
        assertEquals(7, result);
    }
}
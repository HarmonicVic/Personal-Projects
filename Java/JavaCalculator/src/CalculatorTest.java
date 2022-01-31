import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*These are tests for the BasicCalculations class. */

public class CalculatorTest {
    BasicCalculations bc;

    @BeforeEach
    void setCalc(){
        bc = new BasicCalculations();
    }

    @Test
    void testSum(){
        assertEquals(20, bc.sumDoubles(30,-10));
    }

    @Test
    void testMultiply(){
        assertEquals(120, bc.multiplyDoubles(20, 6));
    }

    @Test
    void useSavedNumberWithNewSum(){
        double a = bc.multiplyDoubles(2, 2);
        assertEquals(5, bc.sumDoubles(a, 1));
    }

    @Test
    void testPower(){
        assertEquals(3125, bc.powerDoubles(4, 4));
    }

    @Test
    void testSquareRoot(){
        assertEquals(5, bc.squareRootDouble(25));
    }
}

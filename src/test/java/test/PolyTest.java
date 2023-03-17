package test;
import model.Division;
import model.Operations;
import model.Polynomial;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PolyTest {
    Polynomial p1 = new Polynomial("2x^5 + x^4 - 6x + 9");
    Polynomial p2 = new Polynomial("x^2 - 3x + 1");

    @Test
    @DisplayName("Addition Test")
    public void addTest() {
        assertEquals(Operations.resultString(Operations.addSubtractPoly(p1, p2, 1)), "2x^5 + x^4 + x^2 - 9x + 10");
    }

    @Test
    @DisplayName("Subtract Test")
    public void subtractTest() {
        assertEquals(Operations.resultString(Operations.addSubtractPoly(p1, p2, -1)), "2x^5 + x^4 - x^2 - 3x + 8");
    }

    @Test
    @DisplayName("Multiply Test")
    public void multiplyTest() {
        assertEquals(Operations.resultString(Operations.multiplyPoly(p1, p2)), "2x^7 - 5x^6 - x^5 + x^4 - 6x^3 + 27x^2 - 33x + 9");
    }

    @Test
    @DisplayName("Division Test")
    public void divisionTest() {
        Division result = Operations.dividePoly(p1, p2);
        assertEquals("Quotient: " + Operations.resultString(result.getQuotient()) + " Remainder: " + Operations.resultString(result.getRemainder()), "Quotient: " + "2x^3 + 7x^2 + 19x + 50" + " Remainder: " + "125x - 4");
    }

    @Test
    @DisplayName("Derivate Test")
    public void derivateTest() {
        assertEquals(Operations.resultString(Operations.derivatePoly(p1)), "10x^4 + 4x^3 - 6");
    }

    @Test
    @DisplayName("Integrate Test")
    public void integrateTest() {
        assertEquals(Operations.resultString(Operations.integratePoly(p1)), "0.33x^6 + 0.2x^5 - 3x^2 + 9x");
    }
}

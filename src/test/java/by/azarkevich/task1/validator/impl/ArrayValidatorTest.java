package by.azarkevich.task1.validator.impl;

import by.azarkevich.task1.exception.IntArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorTest {
    private final ArrayValidatorImpl service = new ArrayValidatorImpl();

    @Test
    void isElementValidStandart() throws IntArrayException {
        boolean expected = true;
        boolean actual = service.isElementValid("12");
        assertEquals(expected, actual);
    }

    @Test
    void isElementValidNegative() throws IntArrayException {
        boolean expected = true;
        boolean actual = service.isElementValid("-12");
        assertEquals(expected, actual);
    }

    @Test
    void isElementValidStandartNotRight() throws IntArrayException {
        boolean expected = false;
        boolean actual = service.isElementValid("_12");
        assertEquals(expected, actual);
    }

    @Test
    void isElementValidNegativeNotRight() throws IntArrayException {
        boolean expected = false;
        boolean actual = service.isElementValid("--12");
        assertEquals(expected, actual);
    }
}
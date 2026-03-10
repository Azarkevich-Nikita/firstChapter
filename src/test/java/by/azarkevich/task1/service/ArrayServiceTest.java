package by.azarkevich.task1.service;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.service.impl.ArrayServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayServiceTest {
    private final ArrayServiceImpl service = new ArrayServiceImpl();

    private final IntArray ARRAY = new IntArray(new int[]{3,1,5,2,4}, 1);

    private final IntArray NEGATIVE = new IntArray(new int[]{-5,-1,-3}, 1);

    private final IntArray SINGLE = new IntArray(new int[]{42}, 1);

    @Test
    void testMin() throws IntArrayException {
        int expected = 1;
        int actual = service.min(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void testMinNegative() throws IntArrayException {
        int expected = -5;
        int actual = service.min(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void testMinSingle() throws IntArrayException {
        int expected = 42;
        int actual = service.min(SINGLE);
        assertEquals(expected, actual);
    }

    @Test
    void testMax() throws IntArrayException {
        int expected = 5;
        int actual = service.max(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void testMaxNegative() throws IntArrayException {
        int expected = -1;
        int actual = service.max(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void testMaxSingle() throws IntArrayException {
        int expected = 42;
        int actual = service.max(SINGLE);
        assertEquals(expected, actual);
    }

    @Test
    void testSum() throws IntArrayException {
        int expected = 15;
        int actual = service.sum(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void testSumNegative() throws IntArrayException {
        int expected = -9;
        int actual = service.sum(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void testSumSingle() throws IntArrayException {
        int expected = 42;
        int actual = service.sum(SINGLE);
        assertEquals(expected, actual);
    }
}

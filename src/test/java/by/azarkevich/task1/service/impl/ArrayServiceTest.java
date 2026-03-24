package by.azarkevich.task1.service.impl;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {
    private final ArrayServiceImpl service = new ArrayServiceImpl();

    private final IntArray ARRAY = new IntArray(new int[]{3,1,5,2,4}, 1);

    private final IntArray NEGATIVE = new IntArray(new int[]{-5,-1,-3}, 1);

    private final IntArray SINGLE = new IntArray(new int[]{42}, 1);

    @Test
    void testMinStandart() throws IntArrayException {
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
    void maxStandart() throws IntArrayException{
        int expected = 5;
        int actual = service.max(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void maxNegative() throws IntArrayException{
        int expected = -1;
        int actual = service.max(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void maxSingle() throws IntArrayException{
        int expected = 42;
        int actual = service.max(SINGLE);
        assertEquals(expected, actual);
    }

    @Test
    void sumStandart() throws IntArrayException{
        int expected = 15;
        int actual = service.sum(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void sumNegative() throws IntArrayException{
        int expected = -9;
        int actual = service.sum(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void sumSingle() throws IntArrayException{
        int expected = 42;
        int actual = service.sum(SINGLE);
        assertEquals(expected, actual);
    }

    @Test
    void averageStandart() throws IntArrayException{
        int expected = 3;
        int actual = service.average(ARRAY);
        assertEquals(expected, actual);
    }

    @Test
    void averageNegative() throws IntArrayException{
        int expected = -3;
        int actual = service.average(NEGATIVE);
        assertEquals(expected, actual);
    }

    @Test
    void averageSingle() throws IntArrayException{
        int expected = 42;
        int actual = service.average(SINGLE);
        assertEquals(expected, actual);
    }
}
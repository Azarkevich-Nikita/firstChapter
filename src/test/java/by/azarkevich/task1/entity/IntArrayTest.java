package by.azarkevich.task1.entity;

import by.azarkevich.task1.exception.IntArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntArrayTest {
    private final IntArray service = new IntArray(new int[] {1,2,3,4,5,6 }, 1);

    @Test
    void getId() {
        long expected = 1;
        long actual = service.getId();
        assertEquals(expected, actual);
    }

    @Test
    void setId() {
        long expected = 2;
        service.setId(2);
        long actual = service.getId();
        assertEquals(expected, actual);
    }

    @Test
    void getArray() throws IntArrayException {
        IntArray testArray = new IntArray(new int[]{1,2,3,4,5,6}, 1);
        assert(service.equals(testArray));
    }

    @Test
    void setArray() throws IntArrayException {
        int[] expected = new int[] {1,2,3};
        IntArray testArray = new IntArray(new int[] {1,2,3}, 1);
        service.setArray(new int[] {1,2,3});
        assert(service.equals(testArray));
    }

    @Test
    void size() {
        int expected = 6;
        int actual = service.size();
        assertEquals(expected, actual);
    }

    @Test
    void get() throws IntArrayException {
        int expect = 1;
        int actual = service.get(0);
        assertEquals(expect, actual);
    }

    @Test
    void set() throws IntArrayException {
        int expect = 0;
        service.set(0, 0);
        int actual = service.get(0);
        assertEquals(expect, actual);
    }
}
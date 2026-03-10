package by.azarkevich.task1.factory;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;

public interface ArrayFactory {
    public IntArray createArray(int[] data, int id) throws IntArrayException;
}

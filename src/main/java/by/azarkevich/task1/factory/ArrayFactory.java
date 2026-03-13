package by.azarkevich.task1.factory;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;

import java.util.List;

public interface ArrayFactory {
    public IntArray createArray(List<String> data, int id) throws IntArrayException;
}

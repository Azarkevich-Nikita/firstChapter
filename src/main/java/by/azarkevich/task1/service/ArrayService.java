package by.azarkevich.task1.service;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;

public interface ArrayService {

    int min(IntArray array) throws IntArrayException;

    int max(IntArray array) throws IntArrayException;

    int sum(IntArray array)  throws IntArrayException;

    int average(IntArray array)  throws IntArrayException;

}

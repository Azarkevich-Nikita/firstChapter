package by.azarkevich.task1.service;

import by.azarkevich.task1.exception.IntArrayException;

public interface ArrayService {

    int min(int[] array) throws IntArrayException;
    int max(int[] array) throws IntArrayException;

    int sum(int[] array)  throws IntArrayException;
    int average(int[] array)  throws IntArrayException;

}

package by.azarkevich.task1.service;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;

public interface IntArraySort {
    void bubbleSort(IntArray array) throws IntArrayException;

    void selectionSort(IntArray array) throws IntArrayException;
}

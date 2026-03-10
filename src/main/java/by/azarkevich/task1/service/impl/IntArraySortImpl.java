package by.azarkevich.task1.service.impl;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.service.IntArraySort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArraySortImpl implements IntArraySort {

    private static final Logger logger = LogManager.getLogger(IntArraySortImpl.class);

    @Override
    public void bubbleSort(IntArray array) throws IntArrayException {
        logger.info("bubbleSort for IntArray array called");
        int tmp;
        for (int i = 0; i < array.size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    swapped = true;
                    tmp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, tmp);
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    @Override
    public void selectionSort(IntArray array) throws IntArrayException {
        logger.info("selectionSort for IntArray array called");
        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j -= 1;
            }
            array.set(j + 1, key);
        }
    }
}

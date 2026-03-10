package by.azarkevich.task1;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.factory.ArrayFactory;
import by.azarkevich.task1.factory.impl.ArrayFactoryImpl;
import by.azarkevich.task1.service.impl.ArrayServiceImpl;
import by.azarkevich.task1.service.impl.IntArraySortImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    static void main() throws IntArrayException {
        int[] data = {5, 2, 9, 1};

        ArrayFactoryImpl  arrayFactory = new ArrayFactoryImpl();

        IntArray array = arrayFactory.createArray(data, 1);

        ArrayServiceImpl service = new ArrayServiceImpl();

        logger.info("Min: " + service.min(array));
        logger.info("Max: " + service.max(array));
        logger.info("Sum: " + service.sum(array));

        IntArraySortImpl arraySort = new IntArraySortImpl();

        arraySort.bubbleSort(array);
    }
}

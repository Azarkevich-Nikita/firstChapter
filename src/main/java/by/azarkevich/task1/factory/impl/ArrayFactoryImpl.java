package by.azarkevich.task1.factory.impl;

import by.azarkevich.task1.Main;
import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactoryImpl implements ArrayFactory {

    private static final Logger logger = LogManager.getLogger(ArrayFactoryImpl.class);

    @Override
    public IntArray createArray(int[] data, int id) throws IntArrayException {
        logger.info("createIntArray for IntArray called");
        return new IntArray(data, id);
    }
}

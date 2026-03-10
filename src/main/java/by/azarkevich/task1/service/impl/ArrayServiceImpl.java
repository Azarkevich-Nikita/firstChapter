package by.azarkevich.task1.service.impl;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.service.ArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayServiceImpl implements ArrayService {

    private static final Logger logger = LogManager.getLogger(ArrayServiceImpl.class);

    @Override
    public int max(IntArray array) throws IntArrayException {
        logger.info("get max value from IntArray called");

        if(array == null || array.size() == 0){
            throw new IntArrayException("Now array is null or empty");
        }
        int maxValue = array.get(0);
        for(int i = 1; i < array.size(); i++){
            if(array.get(i) > maxValue){
                maxValue = array.get(i);
            }
        }
        return maxValue;
    }

    @Override
    public int min(IntArray array) throws IntArrayException {
        logger.info("get min value from IntArray called");

        if(array == null || array.size() == 0){
            throw new IntArrayException("Now array is null or empty");
        }
        int minValue = array.get(0);
        for(int i = 1; i < array.size(); i++){
            if(array.get(i) < minValue){
                minValue = array.get(i);
            }
        }
        return minValue;
    }

    @Override
    public int sum(IntArray array) throws IntArrayException {
        logger.info("get sum from IntArray called");

        if(array == null || array.size() == 0){
            throw new IntArrayException("Now array is null or empty");
        }

        int sum = 0;

        for(int i = 0; i < array.size(); i++){
            sum += array.get(i);
        }
        return sum;
    }

    @Override
    public int average(IntArray array) throws IntArrayException {
        return sum(array) / array.size();
    }
}

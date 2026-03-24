package by.azarkevich.task1.factory.impl;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.factory.ArrayFactory;
import by.azarkevich.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayFactoryImpl implements ArrayFactory {

    private static final Logger logger = LogManager.getLogger(ArrayFactoryImpl.class);

    @Override
    public IntArray createArray(List<String> data, int id) throws IntArrayException {
        logger.info("Creating array with id = " + id + " was called for " + data);

        ArrayValidatorImpl validation = new ArrayValidatorImpl();

        List<Integer> intArray = new ArrayList<>();
        for(int i = 0; i < data.size(); ++i){
            String[] stringArray = data.get(i).split(" ");
            for(String s : stringArray){
                if(validation.isElementValid(s)){
                    intArray.add(Integer.parseInt(s));
                }
            }
        }

        return new IntArray(intArray.stream().
                mapToInt(Integer::intValue).
                toArray(),
                id);
    }
}

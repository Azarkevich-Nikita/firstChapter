package by.azarkevich.task1;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.factory.impl.ArrayFactoryImpl;
import by.azarkevich.task1.reader.impl.CustomReaderFileImpl;
import by.azarkevich.task1.service.impl.ArrayServiceImpl;
import by.azarkevich.task1.service.impl.IntArraySortImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    static void main() throws IntArrayException {

        CustomReaderFileImpl reader = new CustomReaderFileImpl();

        List<String> data = reader.readLines("data/data.txt");

        ArrayFactoryImpl creator = new ArrayFactoryImpl();

        IntArray intArray = creator.createArray(data, 1);

        ArrayServiceImpl arrayService = new ArrayServiceImpl();

        System.out.println("Array:\n" + intArray);

        System.out.println("Sum of array = " + arrayService.sum(intArray));
        System.out.println("Min element of array = " + arrayService.min(intArray));
        System.out.println("Max element of array = " + arrayService.max(intArray));

        IntArraySortImpl sortArray = new IntArraySortImpl();
        sortArray.selectionSort(intArray);

        System.out.println(intArray);

    }

}

package by.azarkevich.task1.specification.impl;

import by.azarkevich.task1.entity.ArrayParameters;
import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.repository.Warehouse;
import by.azarkevich.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParameterSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger(ArrayParameterSpecification.class);
    private final ParameterType parameterType;
    private final ParameterOperation operation;
    private final int value;

    public ArrayParameterSpecification(ParameterType parameterType, ParameterOperation operation, int value) {
        this.parameterType = parameterType;
        this.operation = operation;
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(IntArray array) {
        logger.info("isSatisfiedBy() called for ArrayParameterSpecification");
        if (array == null) {
            logger.error("Array is null in specification");
            return false;
        }
        ArrayParameters parameters = Warehouse.getInstance().get(array.getId());
        if (parameters == null) {
            logger.error("Parameters not found in Warehouse for id {}", array.getId());
            return false;
        }
        int actualValue = getValue(parameters);
        return compare(actualValue);
    }

    private int getValue(ArrayParameters parameters) {
        return switch (parameterType) {
            case SUM -> parameters.getSum();
            case AVERAGE -> parameters.getAverage();
            case MAX -> parameters.getMax();
            case MIN -> parameters.getMin();
            case COUNT -> parameters.getCount();
        };
    }

    private boolean compare(int actualValue) {
        return switch (operation) {
            case GREATER -> actualValue > value;
            case LESS -> actualValue < value;
            case EQUAL -> actualValue == value;
        };
    }
}

package by.azarkevich.task1.validator;

import by.azarkevich.task1.exception.IntArrayException;

public interface ArrayValidator {
    public  boolean isElementValid(String line) throws IntArrayException;
}

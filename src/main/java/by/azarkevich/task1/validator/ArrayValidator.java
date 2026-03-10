package by.azarkevich.task1.validator;

import by.azarkevich.task1.exception.IntArrayException;

public interface ArrayValidator {
    public  boolean isValid(String line) throws IntArrayException;
}

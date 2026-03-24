package by.azarkevich.task1.validator.impl;

import by.azarkevich.task1.Main;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {

    private static final Logger logger = LogManager.getLogger(ArrayValidator.class);

    @Override
    public boolean isElementValid(String line) throws IntArrayException {
        logger.info("Function isElementValid for {" + line + "} called.");

        if (line == null || line.isBlank()) {
            return false;
        }

        return line.matches("^-?[0-9;\s]+$");
    }
}

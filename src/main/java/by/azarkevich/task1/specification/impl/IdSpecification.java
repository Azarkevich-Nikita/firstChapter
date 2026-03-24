package by.azarkevich.task1.specification.impl;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdSpecification implements Specification {
    private static final Logger logger = LogManager.getLogger(IdSpecification.class);
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(IntArray array) {
        logger.info("isSatisfiedBy() called for IdSpecification");
        return array != null && array.getId() == id;
    }
}

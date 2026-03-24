package by.azarkevich.task1.specification.impl;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.specification.Specification;

public class IdSpecification implements Specification {
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(IntArray array) {
        return array != null && array.getId() == id;
    }
}

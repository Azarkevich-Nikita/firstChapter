package by.azarkevich.task1.specification;

import by.azarkevich.task1.entity.IntArray;

public interface Specification {
    boolean isSatisfiedBy(IntArray array);
}

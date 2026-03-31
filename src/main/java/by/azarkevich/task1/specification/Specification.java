package by.azarkevich.task1.specification;

import by.azarkevich.task1.entity.IntArray;

public interface Specification {
    boolean isSatisfiedBy(IntArray array);

    default Specification or(Specification spec) {
        return item -> this.isSatisfiedBy(item) || spec.isSatisfiedBy(item);
    }

    default Specification and(Specification spec) {
        return item -> this.isSatisfiedBy(item) && spec.isSatisfiedBy(item);
    }

    default Specification not() {
        return item -> !this.isSatisfiedBy(item);
    }
}

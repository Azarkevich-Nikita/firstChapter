package by.azarkevich.task1.repository;

import by.azarkevich.task1.comparator.IntArrayComparator;
import by.azarkevich.task1.entity.ArrayParameters;
import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.specification.impl.ArrayParameterSpecification;
import by.azarkevich.task1.specification.impl.IdSpecification;
import by.azarkevich.task1.specification.impl.ParameterOperation;
import by.azarkevich.task1.specification.impl.ParameterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntArrayRepositoryTest {
    private final IntArrayRepository repository = IntArrayRepository.getInstance();
    private final Warehouse warehouse = Warehouse.getInstance();

    @BeforeEach
    void setUp() {
        repository.clear();
    }

    @Test
    void addShouldSaveArrayAndWarehouseParameters() {
        IntArray array = new IntArray(new int[]{1, 2, 3}, 100L);

        repository.add(array);

        List<IntArray> found = repository.query(new IdSpecification(100L));
        ArrayParameters parameters = warehouse.get(100L);
        assertEquals(1, found.size());
        assertNotNull(parameters);
        assertEquals(6, parameters.getSum());
        assertEquals(3, parameters.getMax());
        assertEquals(1, parameters.getMin());
        assertEquals(2, parameters.getAverage());
        assertEquals(3, parameters.getCount());
    }

    @Test
    void queryShouldFindArraysBySumSpecification() {
        IntArray first = new IntArray(new int[]{1, 2}, 1L);
        IntArray second = new IntArray(new int[]{10, 20}, 2L);
        repository.add(first);
        repository.add(second);

        List<IntArray> found = repository.query(
                new ArrayParameterSpecification(ParameterType.SUM, ParameterOperation.GREATER, 10)
        );

        assertEquals(1, found.size());
        assertEquals(2L, found.get(0).getId());
    }

    @Test
    void sortShouldOrderByIdAndFirstElement() {
        IntArray first = new IntArray(new int[]{8, 1}, 3L);
        IntArray second = new IntArray(new int[]{2, 9}, 1L);
        IntArray third = new IntArray(new int[]{5, 0}, 2L);
        repository.add(first);
        repository.add(second);
        repository.add(third);

        repository.sort(IntArrayComparator.ID);
        assertEquals(1L, repository.getAll().get(0).getId());
        assertEquals(2L, repository.getAll().get(1).getId());
        assertEquals(3L, repository.getAll().get(2).getId());

        repository.sort(IntArrayComparator.FIRST_ELEMENT);
        assertEquals(2L, repository.getAll().get(0).getId());
        assertEquals(3L, repository.getAll().get(2).getId());
    }

    @Test
    void updateElementShouldRecalculateWarehouse() throws IntArrayException {
        IntArray array = new IntArray(new int[]{4, 6}, 7L);
        repository.add(array);

        array.set(1, 20);

        ArrayParameters parameters = warehouse.get(7L);
        assertNotNull(parameters);
        assertEquals(24, parameters.getSum());
        assertEquals(12, parameters.getAverage());
        assertEquals(20, parameters.getMax());
    }

    @Test
    void removeShouldDeleteFromRepositoryAndWarehouse() {
        IntArray array = new IntArray(new int[]{5, 5}, 33L);
        repository.add(array);

        boolean removed = repository.remove(array);

        assertTrue(removed);
        assertEquals(0, repository.query(new IdSpecification(33L)).size());
        assertNull(warehouse.get(33L));
    }
}

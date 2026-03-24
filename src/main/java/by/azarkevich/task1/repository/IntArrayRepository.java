package by.azarkevich.task1.repository;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.specification.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IntArrayRepository {
    private static IntArrayRepository instance;
    private final List<IntArray> arrays = new ArrayList<>();
    private final Warehouse warehouse = Warehouse.getInstance();

    private IntArrayRepository() {
    }

    public static IntArrayRepository getInstance() {
        if (instance == null) {
            instance = new IntArrayRepository();
        }
        return instance;
    }

    public boolean add(IntArray array) {
        if (array == null || containsId(array.getId())) {
            return false;
        }
        arrays.add(array);
        array.attach(warehouse);
        warehouse.update(array);
        return true;
    }

    public boolean remove(IntArray array) {
        if (array == null) {
            return false;
        }
        for (int i = 0; i < arrays.size(); i++) {
            IntArray current = arrays.get(i);
            if (current.getId() == array.getId()) {
                current.detach(warehouse);
                warehouse.remove(current.getId());
                arrays.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<IntArray> query(Specification specification) {
        List<IntArray> result = new ArrayList<>();
        for (IntArray array : arrays) {
            if (specification.isSatisfiedBy(array)) {
                result.add(array);
            }
        }
        return result;
    }

    public void sort(Comparator<IntArray> comparator) {
        arrays.sort(comparator);
    }

    public List<IntArray> getAll() {
        return new ArrayList<>(arrays);
    }

    public void clear() {
        for (IntArray array : arrays) {
            array.detach(warehouse);
            warehouse.remove(array.getId());
        }
        arrays.clear();
    }

    private boolean containsId(long id) {
        for (IntArray array : arrays) {
            if (array.getId() == id) {
                return true;
            }
        }
        return false;
    }
}

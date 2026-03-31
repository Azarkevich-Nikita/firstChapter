package by.azarkevich.task1.repository;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.specification.Specification;
import by.azarkevich.task1.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IntArrayRepository {
    private static final Logger logger = LogManager.getLogger(IntArrayRepository.class);
    private static IntArrayRepository instance;
    private final List<IntArray> arrays = new ArrayList<>();
    private final Warehouse warehouse = Warehouse.getInstance();

    private IntArrayRepository() {
    }

    public static IntArrayRepository getInstance() {
        if (instance == null) {
            instance = new IntArrayRepository();
            logger.info("IntArrayRepository singleton created");
        }
        return instance;
    }

    public void add(int index, IntArray element) {
        logger.info("add(index, element) called for repository");
        arrays.add(index, element);
        element.attach(warehouse);
        warehouse.update(element);
    }

    public IntArray get(int index) {
        logger.info("get(index) called for repository");
        return arrays.get(index);
    }

    public boolean add(IntArray array) {
        logger.info("add() called for repository");
        if (array == null || containsId(array.getId())) {
            logger.error("Array is null or id already exists in repository");
            return false;
        }
        arrays.add(array);
        array.attach(warehouse);
        warehouse.update(array);
        return true;
    }

    public void remove(long id) {
        logger.info("remove(id) called for repository");
        if (arrays.removeIf(array -> array.getId() == id)) {
            warehouse.remove(id);
            logger.info("Array with ID {} removed from repository", id);
        } else {
            logger.warn("Attempt to remove non-existent array with ID {}", id);
        }
    }

    public boolean remove(IntArray array) {
        logger.info("remove(array) called for repository");
        if (array == null) {
            logger.error("Array is null in remove(array)");
            return false;
        }
        int before = arrays.size();
        remove(array.getId());
        return arrays.size() != before;
    }

    public Optional<IntArray> update(IntArray intArray) {
        logger.info("update() called for repository");
        if (intArray == null) {
            return Optional.empty();
        }
        for (int i = 0; i < arrays.size(); i++) {
            if (arrays.get(i).getId() == intArray.getId()) {
                arrays.get(i).detach(warehouse);
                intArray.attach(warehouse);
                arrays.set(i, intArray);
                warehouse.update(intArray);
                return Optional.of(intArray);
            }
        }
        return Optional.empty();
    }

    public List<IntArray> query(Specification specification) {
        logger.info("query() called for repository");
        List<IntArray> result = new ArrayList<>();
        for (IntArray array : arrays) {
            if (specification.isSatisfiedBy(array)) {
                result.add(array);
            }
        }
        return result;
    }

    public void sort(Comparator<IntArray> comparator) {
        logger.info("sort() called for repository");
        arrays.sort(comparator);
    }

    public List<IntArray> sortToNewList(Comparator<IntArray> comparator) {
        logger.info("sortToNewList() called for repository");
        return arrays.stream().sorted(comparator).collect(Collectors.toList());
    }

    public List<IntArray> getAll() {
        return new ArrayList<>(arrays);
    }

    public void clear() {
        logger.info("clear() called for repository");
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

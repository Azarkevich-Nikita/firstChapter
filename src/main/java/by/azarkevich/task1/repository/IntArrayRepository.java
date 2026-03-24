package by.azarkevich.task1.repository;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public boolean remove(IntArray array) {
        logger.info("remove() called for repository");
        if (array == null) {
            logger.error("Array is null in remove()");
            return false;
        }
        for (int i = 0; i < arrays.size(); i++) {
            IntArray current = arrays.get(i);
            if (current.getId() == array.getId()) {
                current.detach(warehouse);
                warehouse.remove(current.getId());
                arrays.remove(i);
                logger.info("Array removed from repository by id {}", current.getId());
                return true;
            }
        }
        logger.info("Array not found in repository for id {}", array.getId());
        return false;
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

package by.azarkevich.task1.repository;

import by.azarkevich.task1.entity.ArrayParameters;
import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.observer.ArrayObserver;
import by.azarkevich.task1.service.ArrayService;
import by.azarkevich.task1.service.impl.ArrayServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class Warehouse implements ArrayObserver {
    private static Warehouse instance;
    private final Map<Long, ArrayParameters> storage = new HashMap<>();
    private final ArrayService arrayService = new ArrayServiceImpl();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayParameters get(long id) {
        return storage.get(id);
    }

    public void put(long id, ArrayParameters parameters) {
        storage.put(id, parameters);
    }

    public void remove(long id) {
        storage.remove(id);
    }

    @Override
    public void update(IntArray array) {
        if (array == null) {
            return;
        }
        try {
            ArrayParameters parameters = new ArrayParameters(
                    arrayService.min(array),
                    arrayService.max(array),
                    arrayService.sum(array),
                    arrayService.average(array),
                    array.size()
            );
            put(array.getId(), parameters);
        } catch (IntArrayException e) {
            throw new IllegalStateException("Could not update warehouse parameters", e);
        }
    }
}

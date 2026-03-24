package by.azarkevich.task1.entity;

import by.azarkevich.task1.exception.IntArrayException;
import by.azarkevich.task1.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntArray {
    private static final Logger logger = LogManager.getLogger(IntArray.class);

    private long id;
    private int[] array;
    private final List<ArrayObserver> observers = new ArrayList<>();

    public IntArray() {
        this.array = new int[0];
        logger.info("IntArray created. Size: " + array.length);
    }

    public IntArray(int[] array,  long id) {
        this.id = id;
        this.array = array.clone();
        logger.info("IntArray created. Size: " + array.length);
    }

    public long getId(){
        logger.info("get id from IntArray called");
        return id;
    }

    public void setId(long id){
        logger.info("set id from IntArray called");
        this.id = id;
    }

    public int[] getArray() {
        logger.info("get array from IntArray called");
        return array.clone();
    }

    public void setArray(int[] array) {
        logger.info("set array from IntArray called");
        this.array = array.clone();
        notifyObservers();
    }

    public int size() {
        logger.info("get size from IntArray called");
        return array.length;
    }

    public int get(int index) throws IntArrayException {
        logger.info("get index from IntArray called");
        if(index < 0 || index >= array.length){
            logger.error("get index out of bounds in IntArray");
            throw new IntArrayException("Index out of array length");
        }
        return array[index];
    }

    public void set(int index, int value) throws IntArrayException {
        logger.info("set value by index in IntArray called");
        if(index < 0 || index >= array.length){
            logger.error("set index out of bounds in IntArray");
            throw new IntArrayException("Index out of array length");
        }
        array[index] = value;
        notifyObservers();
    }

    public void attach(ArrayObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ArrayObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        logger.info("toString() from IntArray called");
        return  "IntArray = " + Arrays.toString(array) + " with ID = " + id + ".";
    }

    @Override
    public int hashCode() {
        logger.info("hashCode from IntArray called");
        int result = Long.hashCode(id);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        logger.info("equals from IntArray called");
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArray array2)) {
            return false;
        }
        return id == array2.id && Arrays.equals(array, array2.array);
    }
}

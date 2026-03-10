package by.azarkevich.task1.entity;

import by.azarkevich.task1.exception.IntArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntArray {
    private static final Logger logger = LogManager.getLogger(IntArray.class);

    private long id;
    private int[] array;

    public IntArray() {
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
        logger.info("set index out of bounds in IntArray");
        if(index < 0 || index >= array.length){
            logger.error("set index out of bounds in IntArray");
            throw new IntArrayException("Index out of array length");
        }
        array[index] = value;
    }

    @Override
    public String toString() {
        logger.info("toString() from IntArray called");
        return  "IntArray = " + Arrays.toString(array) + " with ID = " + id + ".";
    }

    @Override
    public int hashCode() {
        logger.info("hashCode from IntArray called");
        final int salt = 12;
        int prime = 27;
        return prime * salt + Arrays.hashCode(array);
    }

    public boolean equals(IntArray array2) throws IntArrayException{
        logger.info("equals from IntArray called");
        if(array2 == null || array2.size() == 0){
            logger.error("Array length out of IntArray");
            throw new IntArrayException("Arrau is null or empty");
        }
        if(array2.size() != this.array.length){
            logger.error("Array length out of IntArray");
            return false;
        }
        for(int i = 0; i < this.array.length; i++){
            if(this.array[i] != array2.get(i)){
                return false;
            }
        }
        return true;
    }
}

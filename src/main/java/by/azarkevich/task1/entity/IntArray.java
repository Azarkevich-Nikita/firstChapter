package by.azarkevich.task1.entity;

import by.azarkevich.task1.exception.IntArrayException;

import java.util.Arrays;


public class IntArray {
    private long id;
    private int[] array;

    public IntArray() {}

    public IntArray(int[] array,  long id) {
        this.id = id;
        this.array = array.clone();
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array.clone();
    }

    public int getSize() {
        return array.length;
    }

    public int getElement(int index) throws IntArrayException {
        if(index < 0 || index >= array.length){
            throw new IntArrayException("Index out of array length");
        }
        return array[index];
    }

    public void setElement(int index, int value) throws IntArrayException {
        if(index < 0 || index >= array.length){
            throw new IntArrayException("Index out of array length");
        }
        array[index] = value;
    }

    @Override
    public String toString() {
        return  "IntArray = " + Arrays.toString(array) + " with ID = " + id + ".";
    }

    @Override
    public int hashCode() {
        final int salt = 12;
        int prime = 27;
        return prime * salt + Arrays.hashCode(array);
    }

    public boolean equals(int[] array2) throws IntArrayException{//TODO Maybe should use Object instand of int[]
        if(array2 == null || array2.length == 0){
            throw new IntArrayException("Arrau is null or empty");
        }
        if(array2.length != this.array.length){
            return false;
        }
        for(int i = 0; i < this.array.length; i++){
            if(this.array[i] != array2[i]){
                return false;
            }
        }
        return true;
    }
}

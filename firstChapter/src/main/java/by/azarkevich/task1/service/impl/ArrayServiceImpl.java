package by.azarkevich.task1.service.impl;

import by.azarkevich.task1.service.ArrayService;

public class ArrayServiceImpl implements ArrayService {
    @Override
    public int max(int[] array){
        if(array == null || array.length == 0){
            return 0;//TODO
        }
        int maxValue = array[0];
        for(int val : array){
            if(val > maxValue){
                maxValue = val;
            }
        }
        return maxValue;
    }

    @Override
    public int min(int[] array){
        if(array == null || array.length == 0){
            return 0;//TODO
        }
        int minValue = array[0];
        for(int val : array){
            if(val < minValue){
                minValue = val;
            }
        }
        return minValue;
    }

    @Override
    public int sum(int[] array){
        if(array == null || array.length == 0){
            return 0;//TODO
        }
        int sum = 0;
        for(int val : array){
            sum += val;
        }
        return sum;
    }

    @Override
    public int average(int[] array){
        return sum(array) / array.length;
    }
}

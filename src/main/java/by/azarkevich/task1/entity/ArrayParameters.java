package by.azarkevich.task1.entity;

public class ArrayParameters {
    private final int min;
    private final int max;
    private final int sum;
    private final int average;
    private final int count;

    public ArrayParameters(int min, int max, int sum, int average, int count) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
        this.count = count;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getSum() {
        return sum;
    }

    public int getAverage() {
        return average;
    }

    public int getCount() {
        return count;
    }
}

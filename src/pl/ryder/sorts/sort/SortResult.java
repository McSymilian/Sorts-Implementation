package pl.ryder.sorts.sort;

import java.util.ArrayList;
import java.util.List;

public class SortResult <T> {
    private List<T> inputArray;
    private List<T> outputArray;
    private int comparisonsNumber;

    private int swapsNumber;

    public int getSwapsNumber() {
        return swapsNumber;
    }

    public void setSwapsNumber(int swapsNumber) {
        this.swapsNumber = swapsNumber;
    }

    public SortResult(List<T> inputArray, List<T> outputArray, int comparisonsNumber, int swapsNumber) {
        this.inputArray = inputArray;
        this.outputArray = outputArray;
        this.comparisonsNumber = comparisonsNumber;
        this.swapsNumber = swapsNumber;
    }

    public SortResult(SortResult<T> copy) {
        this.inputArray = new ArrayList<>(copy.inputArray);
        this.outputArray = new ArrayList<>(copy.outputArray);
        this.comparisonsNumber = copy.comparisonsNumber;
        this.swapsNumber = copy.swapsNumber;
    }

    public int getComparisonsNumber() {
        return comparisonsNumber;
    }

    public void setComparisonsNumber(int comparisonsNumber) {
        this.comparisonsNumber = comparisonsNumber;
    }

    public List<T> getInputArray() {
        return inputArray;
    }

    public void setInputArray(List<T> inputArray) {
        this.inputArray = inputArray;
    }

    public List<T> getOutputArray() {
        return outputArray;
    }

    public void setOutputArray(List<T> outputArray) {
        this.outputArray = outputArray;
    }
}

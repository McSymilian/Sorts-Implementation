package pl.ryder.sorts.sort.merge;

import pl.ryder.sorts.sort.SortResult;

import java.util.List;

public class MergeSortResult<T> extends SortResult<T> {



    public MergeSortResult(List<T> inputArray, List<T> outputArray, int comparisonsNumber, int swapNumber, int mergeNumber) {
        super(inputArray, outputArray, comparisonsNumber, swapNumber);
        this.mergeNumber = mergeNumber;
    }
    public MergeSortResult(SortResult<T> copy, int mergeNumber) {
        super(copy);
        this.mergeNumber = mergeNumber;
    }

    public int getMergeNumber() {
        return mergeNumber;
    }

    public void setMergeNumber(int mergeNumber) {
        this.mergeNumber = mergeNumber;
    }

    int mergeNumber;
}

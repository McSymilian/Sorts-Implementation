package pl.ryder.sorts.sort.quick;

import pl.ryder.sorts.sort.SortResult;

import java.util.ArrayList;
import java.util.List;

public class QuickSortResult<T> extends SortResult<T> {
    public List<Integer> getPivots() {
        return pivots;
    }

    private final List<Integer> pivots;

    public QuickSortResult(List<T> inputArray, List<T> outputArray, int comparisonsNumber,int swapsNumber, List<Integer> pivots) {
        super(inputArray, outputArray, comparisonsNumber, swapsNumber);
        this.pivots = new ArrayList<>(pivots);
    }

    public QuickSortResult(SortResult<T> copy, List<Integer> pivots) {
        super(copy);
        this.pivots = new ArrayList<>(pivots);
    }
}

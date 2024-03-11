package pl.ryder.sorts.sort.heap;

import pl.ryder.sorts.sort.SortResult;
import pl.ryder.sorts.sort.Sorter;

import java.util.List;

public class HeapSort <T extends Comparable<T>> extends Sorter<T> {

    private void buildHeap(List<T> array, int bound) {
        boolean swapped = false;
        int i = bound;
        while (i > 0) {
            incrementComparisons();
            if (array.get(i).compareTo(array.get((i - 1) / 2)) > 0) {
                swapped = true;
                swap(array, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
            else i--;
        }

        if (swapped)
            buildHeap(array, bound);
        else {
            swap(array, 0, bound);
        }
    }

    @Override
    public SortResult<T> sort(List<T> array) {
        setInput(array);
        setComparisonNumber(0);
        setSwapsNumber(0);

        setOutput(array);
        for (int i = array.size() - 1; i > 0 ; i--)
            buildHeap(getOutput(), i);


        return buildResult();
    }
}

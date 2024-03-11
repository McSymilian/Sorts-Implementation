package pl.ryder.sorts.sort.selection;

import pl.ryder.sorts.sort.SortResult;
import pl.ryder.sorts.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> extends Sorter<T> {

    private Integer findMinIndex(List<T> array, int previousIndex) {
        int lastIndex = array.size() - 1;

        T smallest = array.get(lastIndex);
        int smallestIndex = array.size() - 1;
        for (int i = previousIndex; i < lastIndex; i++) {
            T current = array.get(i);
            incrementComparisons();
            if (current.compareTo(smallest) < 0) {
                smallest = current;
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    @Override
    public SortResult<T> sort(List<T> array) {
        setInput(array);
        setComparisonNumber(0);
        setSwapsNumber(0);

        List<T> ans = new ArrayList<>(array);
        for (int i = 0; i < ans.size(); i++)
            swap(ans, i, findMinIndex(ans, i));


        setOutput(ans);
        return buildResult();
    }
}

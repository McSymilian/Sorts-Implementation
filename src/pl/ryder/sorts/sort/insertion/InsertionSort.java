package pl.ryder.sorts.sort.insertion;

import pl.ryder.sorts.sort.SortResult;
import pl.ryder.sorts.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> extends Sorter<T> {
    @Override
    public SortResult<T> sort(List<T> array) {
        setInput(array);
        setComparisonNumber(0);
        setSwapsNumber(0);

        List<T> ans = new ArrayList<>(array);
        for (int i = 1; i < ans.size(); i++) {
            incrementComparisons();
            if (ans.get(i).compareTo(ans.get(i - 1)) < 0) {
                swap(ans, i, i - 1);
                if (i == 1)
                    i = 0;
                else
                    i -= 2;
            }
        }

        setOutput(ans);

        return buildResult();
    }
}

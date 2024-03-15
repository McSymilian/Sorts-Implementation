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
        int n = ans.size();
        for (int i = 1; i < n; ++i) {
            T key = ans.get(i);
            int j = i - 1;
            incrementComparisons();
            while (j >= 0 && ans.get(j).compareTo(key) > 0) {
                ans.set(j + 1, ans.get(j));
                j = j - 1;
            }
            swap(new ArrayList<>(array), 0, 0);
            ans.set(j + 1, key);
        }

        setOutput(ans);

        return buildResult();
    }
}

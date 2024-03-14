package pl.ryder.sorts.sort.quick;

import pl.ryder.sorts.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public class QuickSort <T extends Comparable<T>> extends Sorter<T> {
    private List<Integer> getPivots() {
        return pivots;
    }

    private final List<Integer> pivots = new ArrayList<>();

    private void quick(List<T> base, int left, int right) {
        if (right <= left)
            return;

        int q = partition(base, left, right);
        quick(base, left, q - 1);
        quick(base, q + 1, right);

    }
    int partition(List<T> base, int left, int right) {
        T x = base.get(left);
        int i = left;

        for(int j = left + 1;j <= right; j++) {
            incrementComparisons();
            if (base.get(j).compareTo(x) < 1) {
                i = i + 1;
                swap(base, i, j);
            }
        }

        swap(base, i, left);

        return i;
    }

    @Override
    public QuickSortResult<T> sort(List<T> array) {
        setInput(array);
        setComparisonNumber(0);
        setSwapsNumber(0);
        getPivots().clear();

        List<T> ans = new ArrayList<>(array);
        quick(ans, 0, ans.size() - 1);

        setOutput(ans);

        return buildResult();
    }

    @Override
    protected QuickSortResult<T> buildResult() {
        return new QuickSortResult<>(super.buildResult(), getPivots());
    }
}

package pl.ryder.sorts.sort.quick;

import pl.ryder.sorts.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public class QuickSort <T extends Comparable<T>> extends Sorter<T> {
    private List<Integer> getPivots() {
        return pivots;
    }

    private final List<Integer> pivots = new ArrayList<>();

    private List<T> quick(List<T> base, int pivot) {
        if (base.size() <= 1)
            return base;

        getPivots().add(pivot);

        final List<T> left = new ArrayList<>();
        final List<T> right = new ArrayList<>();

        final T pivotVal = base.get(pivot);

        for (var val: base.subList(0, base.size() - 1)) {
            incrementComparisons();
            if (val.compareTo(pivotVal) >= 0)
                right.add(val);

            else
                left.add(val);
        }

        base.clear();
        base.addAll(quick(left, left.size() - 1));
        base.add(pivotVal);
        base.addAll(quick(right, right.size() - 1));

        return base;
    }

    @Override
    public QuickSortResult<T> sort(List<T> array) {
        setInput(array);
        setComparisonNumber(0);
        setSwapsNumber(0);
        getPivots().clear();

        List<T> ans = new ArrayList<>(array);
        quick(ans, ans.size() - 1);

        setOutput(ans);

        return buildResult();
    }

    @Override
    protected QuickSortResult<T> buildResult() {
        return new QuickSortResult<>(super.buildResult(), getPivots());
    }
}

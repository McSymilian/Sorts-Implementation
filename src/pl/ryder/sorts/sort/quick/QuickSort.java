package pl.ryder.sorts.sort.quick;

import pl.ryder.sorts.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public class QuickSort <T extends Comparable<T>> extends Sorter<T> {
    private List<Integer> getPivots() {
        return pivots;
    }

    private final List<Integer> pivots = new ArrayList<>();

    private void quick(List<T> base, int pivot) {
        if (base.size() < 2)
            return;

        List<T> left = new ArrayList<>();
        List<T> right = new ArrayList<>();
        T p = base.get(pivot);

        for (int i = 0; i < base.size(); i++) {
            if (pivot == i) continue;
            incrementComparisons();
            if (base.get(i).compareTo(p) > 0) {
                swap(new ArrayList<>(List.of(p)), 0, 0);
                right.add(base.get(i));
            }
            else {
                swap(new ArrayList<>(List.of(p)), 0, 0);
                left.add(base.get(i));
            }
        }

        quick(left, left.size() - 1);
        quick(right, right.size() - 1);

        base.clear();
        base.addAll(left);
        base.add(p);
        base.addAll(right);
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

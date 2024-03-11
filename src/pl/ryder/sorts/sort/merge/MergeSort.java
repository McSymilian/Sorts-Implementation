package pl.ryder.sorts.sort.merge;

import pl.ryder.sorts.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> extends Sorter<T> {
    private int mergeNumber = 0;
    private List<T> sortInside(List<T> array) {
        List<T> ans = new ArrayList<>(array);
        if (ans.size() > 1) {
            mergeNumber++;
            int beg = 0;
            int mid = ans.size() / 2;
            int end = ans.size();

            List<T> leftArr = ans.subList(beg, mid);
            List<T> rightArr = ans.subList(mid, end);

            leftArr = sortInside(leftArr);
            rightArr = sortInside(rightArr);

            int i = 0;
            int j = 0;
            int k = 0;
            int endL = leftArr.size();
            int endR = rightArr.size();
            while (i < endL && j < endR) {
               incrementComparisons();

                ans.set(
                        k++,
                        switch ((int) Math.signum(leftArr.get(i).compareTo(rightArr.get(j)))) {
                            case -1, 0 -> leftArr.get(i++);
                            default -> rightArr.get(j++);
                        });
            }

            while (i < endL)
                ans.set(k++, leftArr.get(i++));

            while (j < endR)
                ans.set(k++, rightArr.get(j++));
        }

        return ans;
    }
    @Override
    public MergeSortResult<T> sort(List<T> array) {
        setInput(array);
        setComparisonNumber(0);
        mergeNumber = 0;

        setOutput(sortInside(array));

        return buildResult();
    }

    @Override
    protected MergeSortResult<T> buildResult() {
        return new MergeSortResult<>(super.buildResult(), mergeNumber);
    }
}

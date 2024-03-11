package pl.ryder.sorts.sort.bubble;

import pl.ryder.sorts.sort.SortResult;
import pl.ryder.sorts.sort.Sorter;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort <T extends Comparable<T>> extends Sorter<T> {
    @Override
    public SortResult<T> sort(List<T> array) {
        setInput(array);
        setComparisonNumber(0);
        setSwapsNumber(0);

        List<T> ans = new ArrayList<>(array);

        for(int i = 0, end = ans.size() - 1; i < end; i++){
            for(int j = 0; j < end - i; j++) {
                incrementComparisons();
                if(ans.get(j).compareTo(ans.get(j + 1)) > 0) {
                    swap(ans, j, j + 1);
                }
            }
        }

        setOutput(ans);
        return buildResult();
    }
}

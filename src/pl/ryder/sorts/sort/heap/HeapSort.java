package pl.ryder.sorts.sort.heap;

import pl.ryder.sorts.sort.SortResult;
import pl.ryder.sorts.sort.Sorter;

import java.util.List;

public class HeapSort <T extends Comparable<T>> extends Sorter<T> {
    void heapify(List<T> list, int N, int i)
    {
        int largest = i; 
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        incrementComparisons();
        if (l < N && list.get(l).compareTo(list.get(largest)) > 0)
            largest = l;
        incrementComparisons();
        if (r < N && list.get(r).compareTo(list.get(largest)) > 0)
            largest = r;
        
        if (largest != i) {
            swap(list, i, largest);
            
            heapify(list, N, largest);
        }
    }

    @Override
    public SortResult<T> sort(List<T> list) {
        setInput(list);
        setComparisonNumber(0);
        setSwapsNumber(0);

        int N = list.size();
        
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(list, N, i);
        
        for (int i = N - 1; i > 0; i--) {
            swap(list, i, 0);
            
            heapify(list, i, 0);
        }
        setOutput(list);

        return buildResult();
    }
}

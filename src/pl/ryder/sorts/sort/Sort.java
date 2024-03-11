package pl.ryder.sorts.sort;

import java.util.List;
public interface Sort <T extends Comparable<T>> {
    SortResult<T> sort(List<T> array);
}

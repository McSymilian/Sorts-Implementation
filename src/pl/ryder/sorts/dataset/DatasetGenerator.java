package pl.ryder.sorts.dataset;

import java.util.Comparator;
import java.util.List;

public interface DatasetGenerator<T> {
    List<T> generate(int length);

    Comparator<T> getComparator();
}

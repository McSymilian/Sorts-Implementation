package pl.ryder.sorts.dataset;

import java.util.Comparator;

public class RandomDatasetGenerator extends IntegerDatasetGenerator {
    @Override
    public Comparator<Integer> getComparator() {
        return Comparator.comparing((a) -> 0);
    }
}

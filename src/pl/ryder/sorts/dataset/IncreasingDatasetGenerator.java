package pl.ryder.sorts.dataset;

import java.util.Comparator;
import java.util.List;

public class IncreasingDatasetGenerator extends IntegerDatasetGenerator {
    @Override
    public Comparator<Integer> getComparator() {
        return Comparator.comparing(a -> 0);
    }

    @Override
    public List<Integer> generate(int length) {
        return super.generate(length)
                .stream()
                .sorted(Comparator.naturalOrder())
                .toList();
    }
}

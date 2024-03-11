package pl.ryder.sorts.dataset;

import java.util.Comparator;

public class AShapedDatasetGenerator extends IntegerDatasetGenerator {

    @Override
    public Comparator<Integer> getComparator() {
        return Comparator.reverseOrder();
    }
}

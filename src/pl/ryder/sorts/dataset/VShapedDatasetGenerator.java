package pl.ryder.sorts.dataset;

import java.util.Comparator;

public class VShapedDatasetGenerator extends IntegerDatasetGenerator {


    @Override
    public Comparator<Integer> getComparator() {
        return Comparator.naturalOrder();
    }
}

package pl.ryder.sorts;

import pl.ryder.sorts.dataset.RandomDatasetGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSortTest {

    private final List<Integer> testData = new RandomDatasetGenerator().generate(32000);

    public List<Integer> getTestData() {
        return testData;
    }
}

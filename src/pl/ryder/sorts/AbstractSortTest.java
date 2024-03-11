package pl.ryder.sorts;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSortTest {

    private final List<Integer> testData = new ArrayList<>(List.of(14, 8, 28, 9, 0, 3, 1));

    public List<Integer> getTestData() {
        return testData;
    }
}

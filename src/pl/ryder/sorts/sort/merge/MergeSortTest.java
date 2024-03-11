package pl.ryder.sorts.sort.merge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.ryder.sorts.AbstractSortTest;
import pl.ryder.sorts.sort.Sort;

class MergeSortTest extends AbstractSortTest {

    private final Sort<Integer> sort = new MergeSort<>();

    @Test
    void sort() {
        Assertions.assertArrayEquals(
                getTestData().stream()
                        .sorted()
                        .toArray(Integer[]::new),
                sort.sort(getTestData())
                        .getOutputArray()
                        .toArray(Integer[]::new)
        );
    }
}
package pl.ryder.sorts.sort.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.ryder.sorts.AbstractSortTest;
import pl.ryder.sorts.sort.Sort;

class HeapSortTest extends AbstractSortTest {
    private final Sort<Integer> sort = new HeapSort<>();

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
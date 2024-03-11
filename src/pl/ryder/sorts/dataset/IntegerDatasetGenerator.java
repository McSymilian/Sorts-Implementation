package pl.ryder.sorts.dataset;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IntegerDatasetGenerator implements DatasetGenerator<Integer> {
    private final static Random random = new Random(System.nanoTime());

    protected static Random getRandom() {
        return random;
    }

    @Override
    public List<Integer> generate(int length) {
        List<Integer> base = new ArrayList<>(length);

        for (int i = 0; i < length; i++)
            base.add(getRandom().nextInt(1, length * 10));

        List<Integer> res = new ArrayList<>();
        AtomicBoolean back = new AtomicBoolean(false);
        base.stream()
                .sorted(getComparator())
                .forEachOrdered(num -> {
                    if (back.get())
                        res.add(num);
                    else
                        res.addFirst(num);

                    back.set(!back.get());
                });

        return res;
    }
}

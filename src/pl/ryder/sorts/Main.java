package pl.ryder.sorts;

import pl.ryder.sorts.dataset.AShapedDatasetGenerator;
import pl.ryder.sorts.dataset.DatasetGenerator;
import pl.ryder.sorts.dataset.DecreasingDatasetGenerator;
import pl.ryder.sorts.dataset.IncreasingDatasetGenerator;
import pl.ryder.sorts.dataset.RandomDatasetGenerator;
import pl.ryder.sorts.dataset.VShapedDatasetGenerator;
import pl.ryder.sorts.sort.SortResult;
import pl.ryder.sorts.sort.Sorter;
import pl.ryder.sorts.sort.bubble.BubbleSort;
import pl.ryder.sorts.sort.heap.HeapSort;
import pl.ryder.sorts.sort.insertion.InsertionSort;
import pl.ryder.sorts.sort.merge.MergeSort;
import pl.ryder.sorts.sort.quick.QuickSort;
import pl.ryder.sorts.sort.selection.SelectionSort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {

        getDatasetsGenerators().forEach(datasetGenerator -> {

            final String dir = "results" + "/" + datasetGenerator.getClass().getSimpleName().replace("Generator", "");

            var f = new File(dir);
            f.mkdirs();

            measureSortingTimes(generateDatasets(datasetGenerator))
                    .forEach((type, list) -> {

                        String resFilePath = dir + "/" + type + ".csv";

                        File file = new File(resFilePath);

                        try (Writer writer = new FileWriter(file)) {
                            writer.append("length;time;time_deviation;swaps;swaps_deviation;comparisons;comparison_deviation;operations;operations_deviation\n");
                            list.stream()
                                .collect(groupingBy(it -> it.getSortResults().getOutputArray().size()))
                                .values()
                                .stream()
                                .map(AverageResult::countUp)
                                .sorted(Comparator.comparingInt(AverageResult::length))
                                .forEach(res -> {
                                    try {
                                        double millisecond = 10e6D;
                                        writer.append(String.valueOf(res.length()))
                                                .append(";")
                                                .append(String.valueOf(res.time() / millisecond))
                                                .append(";")
                                                .append(String.valueOf(res.timeDeviation() / millisecond))
                                                .append(";")
                                                .append(String.valueOf(res.swaps()))
                                                .append(";")
                                                .append(String.valueOf(res.swapsDeviation()))
                                                .append(";")
                                                .append(String.valueOf(res.comparisons()))
                                                .append(";")
                                                .append(String.valueOf(res.comparisonsDeviation()))
                                                .append(";")
                                                .append(String.valueOf(res.operations()))
                                                .append(";")
                                                .append(String.valueOf(res.operationsDeviation()))
                                                .append("\n");
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                    });
        });

    }

    private static Map<String, List<Result<SortResult<Integer>, Integer>>> measureSortingTimes(List<List<Integer>> dataset) {
        List<Sorter<Integer>> sorters = getSorters();

        Map<String, List<Result<SortResult<Integer>, Integer>>> measurements = new HashMap<>();

        sorters.forEach(sorter -> {
            String sorterName = sorter.getClass().getSimpleName();
            measurements.put(sorterName, new ArrayList<>());

            dataset.forEach(testSet -> {
                Result<SortResult<Integer>, Integer> result = new Result<>();

                result.startTimer();

                var res = sorter.sort(new ArrayList<>(testSet));

                result.stopTimer();
                result.setSortResults(res);
                measurements.get(sorterName).add(result);
            });
        });

        return measurements;
    }

    private static ArrayList<Sorter<Integer>> getSorters() {
        return new ArrayList<>(List.of(
                new MergeSort<>(),
                new HeapSort<>(),
                new BubbleSort<>(),
                new SelectionSort<>(),
                new InsertionSort<>(),
                new QuickSort<>()
        ));
    }

    private static List<List<Integer>> generateDatasets(DatasetGenerator<Integer> datasetGenerator) {

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            for (int j = 0; j < 30; j++)
                res.add(datasetGenerator.generate((int) Math.pow(2, i)));


        return res;
    }

    private static List<DatasetGenerator<Integer>> getDatasetsGenerators() {
        return List.of(
                new AShapedDatasetGenerator(),
                new VShapedDatasetGenerator(),
                new RandomDatasetGenerator(),
                new IncreasingDatasetGenerator(),
                new DecreasingDatasetGenerator()
        );
    }
}
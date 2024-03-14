package pl.ryder.sorts;

import pl.ryder.sorts.sort.SortResult;

import java.util.List;

public record AverageResult(
        double time,
        double timeDeviation,
        double comparisons,
        double comparisonsDeviation,
        double swaps,
        double swapsDeviation,
        double operations,
        double operationsDeviation,
        int length
) {
    public static AverageResult countUp(List<Result<SortResult<Integer>, Integer>> dataset) {
        double averageTime = dataset.stream().map(Result::getDuration).reduce(0L, Long::sum) / (double) dataset.size();
        double timeDeviation = Math.sqrt(
                (dataset.stream()
                        .map(it -> (double) it.getDuration())
                        .reduce((a, b) -> a + Math.pow(b - averageTime, 2))
                        .orElse(0D)
                ) / dataset.size());

        double averageComparisons = dataset.stream().map(it -> it.getSortResults().getComparisonsNumber()).reduce(0, Integer::sum) / (double) dataset.size();
        double comparisonsDeviation = Math.sqrt(
                (dataset.stream()
                        .map(it -> (double) it.getSortResults().getComparisonsNumber())
                        .map(it -> it - averageComparisons)
                        .map(it -> it * it)
                        .reduce(Double::sum)
                        .orElse(0D)
                ) / dataset.size());

        double averageSwaps = dataset.stream().map(it -> it.getSortResults().getSwapsNumber()).reduce(0, Integer::sum) / (double) dataset.size();
        double swapsDeviation = Math.sqrt(
                (dataset.stream()
                        .map(it -> (double) it.getSortResults().getSwapsNumber())
                        .reduce((a, b) -> a + Math.pow(b - averageSwaps, 2))
                        .orElse(0D)
                ) / dataset.size());

        double averageOperations = dataset.stream().map(it -> it.getSortResults().getSwapsNumber() + it.getSortResults().getComparisonsNumber()).reduce(0, Integer::sum) / (double) dataset.size();
        double operationsDeviation = countDeviation(dataset, averageOperations);


        return new AverageResult(
                averageTime,
                timeDeviation,
                averageComparisons,
                comparisonsDeviation,
                averageSwaps,
                swapsDeviation,
                averageOperations,
                operationsDeviation,
                dataset.getFirst().getSortResults().getInputArray().size()
        );
    }

    private static double countDeviation(List<Result<SortResult<Integer>, Integer>> dataset, double average) {
        double sum = 0;
        for (int i = 0; i < dataset.size(); i++) {
            sum += Math.pow(dataset.get(i).getSortResults().getSwapsNumber() + dataset.get(i).getSortResults().getComparisonsNumber() - average, 2);
        }
        return Math.sqrt(sum / dataset.size());
    }
}

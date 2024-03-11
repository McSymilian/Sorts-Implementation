package pl.ryder.sorts.sort;

import java.util.ArrayList;
import java.util.List;

public abstract class Sorter<T extends Comparable<T>> implements Sort<T> {
    private List<T> input;
    private List<T> output;

    private int comparisonNumber = 0;

    private int swapsNumber = 0;

    protected int incrementComparisons() {
        return comparisonNumber++;
    }


    private int getSwapsNumber() {
        return swapsNumber;
    }

    protected void setSwapsNumber(int swapsNumber) {
        this.swapsNumber = swapsNumber;
    }



    public List<T> getInput() {
        return input;
    }

    protected void setInput(List<T> input) {
        if (input == null)
            this.input = null;
        else
            this.input = new ArrayList<>(input);
    }

    public List<T> getOutput() {
        return output;
    }

    protected void setOutput(List<T> output) {
        if (output == null)
            this.output = null;
        else
            this.output = new ArrayList<>(output);
    }

    public int getComparisonNumber() {
        return comparisonNumber;
    }

    protected void setComparisonNumber(int comparisonNumber) {
        this.comparisonNumber = comparisonNumber;
    }

    protected void swap(List<T> array, int a, int b) {
        swapsNumber++;
        T temp = array.get(a);

        array.set(a, array.get(b));

        array.set(b, temp);
    }

    protected SortResult<T> buildResult() {
        return new SortResult<>(getInput(), getOutput(), getComparisonNumber(), getSwapsNumber());
    }
}

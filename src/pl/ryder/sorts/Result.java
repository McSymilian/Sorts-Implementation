package pl.ryder.sorts;

import pl.ryder.sorts.sort.SortResult;

public class Result <T extends SortResult<K>, K> {

    private T sortResults;
    private Long startTime;
    private Long stopTime;

    public Result(T sortResults, Long startTime, Long stopTime) {
        this.sortResults = sortResults;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public Result() {}

    public void startTimer() {
        setStartTime(System.nanoTime());
    }

    public void stopTimer() {
        setStopTime(System.nanoTime());
    }

    public Long getDuration() {
        return stopTime - startTime;
    }

    public T getSortResults() {
        return sortResults;
    }

    public void setSortResults(T sortResults) {
        this.sortResults = sortResults;
    }

    public Long getStartTime() {
        return startTime;
    }

    private void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getStopTime() {
        return stopTime;
    }

    private void setStopTime(Long stopTime) {
        this.stopTime = stopTime;
    }
}

package au.com.treeshake.linkchecker.domain;

public class DurationTimer {

    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getDurationInMillis() {
        return (endTime - startTime) / 1_000_000;
    }
}

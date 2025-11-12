public class MyResourceSynchronized {
    private long counter = 0;

    public synchronized void add(long value) {
        this.counter += value;
    }

    public long getCounter() {
        return counter;
    }
}
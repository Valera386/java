public class MyResource {
    private long counter = 0;

    public void add(long value) {
        this.counter += value;
    }

    public long getCounter() {
        return counter;
    }
}

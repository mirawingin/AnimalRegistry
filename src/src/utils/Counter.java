package utils;

public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;

    public void add() throws Exception {
        if (closed) {
            throw new Exception("Counter is already closed!");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (!closed) {
            closed = true;
            System.out.println("Counter closed.");
        } else {
            throw new Exception("Counter was already closed!");
        }
    }
}

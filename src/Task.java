public class Task implements Node, Runnable{
    static Object lock = new Object();
    Task prev = null;
    Task next = null;

    String load;
    Runnable runnable;

    public Task(String load) {
        this.load = load;
    }

    public String getLoad() {
        return load;
    }

    @Override
    public Node getPrev() {
        return this.prev;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setPrev(Node node) {
        this.prev = (Task) node;
    }

    @Override
    public void setNext(Node node) {
        this.next = (Task) node;
    }


    @Override
    public void run() {
        runnable.run();
        synchronized (lock) {
            System.out.println(this.load);
        }

    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
}

public class Monitor {
    private DeadLockPolice police;
    private int id;
    private int count;

    public Monitor(int id, DeadLockPolice police) {
        this.id = id;
        this.count = 0;
        this.police = police;
    }

    public synchronized void inc(int workerId) {
        while (count == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (police.allow(this.id, workerId)) {
            this.count++;
            notifyAll();
        }
    }

    public synchronized void dec(int workerId) {
        while (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.count--;
        notifyAll();
    }
}

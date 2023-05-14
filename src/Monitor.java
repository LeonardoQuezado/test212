public class Monitor {
    DeadLockPolice police;

    int id;
    int count;

    public Monitor(int id) {
        this.id = id;
        this.count = 0;
    }

    public int getId() {
        return id;
    }

    public synchronized void inc(int id) {
        //Operacoes com police
        while (count == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.count++;
        notifyAll();
    }

    public synchronized void dec(int id) {
        //Operacoes com police
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

    public void setPolice(DeadLockPolice police) {
        //Sincronize
        this.police = police;
    }
}

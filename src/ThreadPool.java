public class ThreadPool {
    Queue requests;
    Deque tasks[];
    Scheduler scheduler;
    Worker workers[];
    int nThreads;

    public ThreadPool(int nThread) {
        this.nThreads = nThread;
        this.requests = new Deque();
        this.tasks = buildTasks();
        this.scheduler = buildScheduler();
        this.workers = buildWorkers();

    }

    public Deque[] buildTasks() {
        Deque tasks[] = new Deque[this.nThreads];
        for (int i = 0; i < this.nThreads; i++) {
            tasks[i] = new Deque();
        }
        return tasks;
    }

    public Scheduler buildScheduler() {
        Scheduler scheduler = new Scheduler(this.requests, this.tasks);
        scheduler.start();
        return scheduler;
    }

    public Worker[] buildWorkers() {
        Worker workers[] = new Worker[this.nThreads];
        for (int i = 0; i < this.nThreads; i++) {
            workers[i] = new Worker(i, this.tasks[i]);
            workers[i].start();
        }
        return workers;
    }

    public void submit(String str) {
        Request request = new Request(str);
        synchronized (this.requests) {
            this.requests.push(request);
            this.requests.notifyAll();
        }
    }
}

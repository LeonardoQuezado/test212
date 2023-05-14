import java.util.HashMap;

public class Worker extends Thread{
    int id;
    boolean isWorking = true;
    Deque tasks;
    Monitor resources[];
    HashMap<String, Runnable> instructions;
    public Worker(int id, Deque tasks) {
        this.id = id;
        this.tasks = tasks;
    }

    public void run() {
        while (this.isWorking) {
            synchronized (this.tasks) {
                while (this.tasks.isEmpty()) {
                    try {
                        this.tasks.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            Task task;
            synchronized (this.tasks) {
                task = (Task) this.tasks.popFront();
            }
            task.setRunnable(instructions.get(task.getLoad()));
            task.run();
        }
    }

    public void setResources(Monitor resources[]) {
        this.resources = resources;
    }

    public void setInstructions(Monitor resources[]) {
        setResources(resources);
        for (int i = 0; i < resources.length; i++) {
            int final_i = i;
            Runnable inc = () -> resources[final_i].inc(this.id);
            this.instructions.put(String.format("inc%d", i), inc);
            Runnable dec = () -> resources[final_i].dec(this.id);
            this.instructions.put(String.format("dec%d", i), dec);
        }
    }
}

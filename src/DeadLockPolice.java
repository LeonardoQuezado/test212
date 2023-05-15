public class DeadLockPolice {
    private DirectGraph graph;

    public DeadLockPolice(int size) {
        this.graph = new DirectGraph(size);
    }

    public synchronized void link(int v, int w) {
        this.graph.link(v, w);
    }

    public synchronized void unlink(int v, int w) {
        this.graph.unlink(v, w);
    }

    public synchronized boolean allow(int resource, int thread) {
        this.unlink(thread, resource);
        this.link(resource, thread);
        if (this.graph.hasCycle(resource)) {
            this.unlink(resource, thread);
            return false;
        }
        return true;
    }
}

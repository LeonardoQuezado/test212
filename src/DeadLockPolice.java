/*
    O DeadLockPolice é também um monitor,
    portando deve ter seus métodos sincronizados;
    (Ver exemplo das filas de task)
 */
public class DeadLockPolice {
    DirectedGraph graph;

    public DeadLockPolice(int size) {
        this.graph = new DirectedGraph(size);
    }

    public void link(int v, int w) {
        this.graph.link(v, w);
    }

    public void unlink(int v, int w) {
        this.graph.unlink(v, w);
    }

    public boolean allow(int resource, int thread) {
        this.unlink(thread, resource);
        this.link(resource, thread);
        if(this.graph.hasCicle(resource)) {
            this.unlink(resource, thread);
            return false;
        }
        return true;
    }
}

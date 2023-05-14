public class DirectedGraph {
    Queue adjList[];
    int size;

    public DirectedGraph(int size) {
        this.size = size;
        this.adjList = buildQueue();
    }

    private Queue[] buildQueue() {
        Queue adjList[] = new Queue[this.size];
        for (int i = 0; i < this.size; i++) {
            adjList[i] = new Queue();
        }
        return adjList;
    }

    public void link(int v, int w) {
        //v -> w
    }

    public void unlink(int v, int w) {
        //v -x-> w
    }

    public boolean hasCicle(int root) {
        //DFS
        return false;
    }
}

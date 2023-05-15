import java.util.ArrayList;
import java.util.List;

public class DirectGraph {
    private int size;
    private List<List<Integer>> adjacencyList;

    public DirectGraph(int size) {
        this.size = size;
        this.adjacencyList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void link(int v, int w) {
        if (!adjacencyList.get(v).contains(w)) {
            adjacencyList.get(v).add(w);
        }
    }

    public void unlink(int v, int w) {
        adjacencyList.get(v).remove(Integer.valueOf(w));
    }

    public boolean hasCycle(int resource) {
        boolean[] visited = new boolean[size];
        boolean[] recursionStack = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (isCyclicUtil(i, visited, recursionStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclicUtil(int vertex, boolean[] visited, boolean[] recursionStack) {
        if (recursionStack[vertex]) {
            return true;
        }

        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;
        recursionStack[vertex] = true;

        List<Integer> neighbors = adjacencyList.get(vertex);
        for (Integer neighbor : neighbors) {
            if (isCyclicUtil(neighbor, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[vertex] = false;

        return false;
    }
}

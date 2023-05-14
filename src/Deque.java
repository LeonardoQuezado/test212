public class Deque extends Queue {
    public Node popFront() {
        synchronized (this) {
            return this.pop();
        }
    }

    public Node popBack() {
        synchronized (this) {
            Node node = this.tail;
            if (node != null) {
                this.tail = this.tail.getPrev();
                if (this.size == 1) this.head = null;
                else {
                    this.tail.setNext(null);
                }
                this.size--;
            }
            return node;
        }
    }
}

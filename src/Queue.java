public class Queue {
    Node head = null;
    Node tail = null;
    int size = 0;

    public void push(Node node) {
        synchronized (this) {
            if (isEmpty()) {
                this.head = node;
            } else {
                this.tail.setNext(node);
                node.setPrev(this.tail);
            }
            this.tail = node;
            this.size++;
        }
    }

    public Node pop() {
        synchronized (this) {
            Node node = this.head;
            if (node != null) {
                this.head = this.head.getNext();
                if (this.size == 1) this.tail = null;
                else {
                    this.head.setPrev(null);
                }
                this.size--;
            }
            return node;
        }
    }

    public boolean isEmpty() {
        return this.head==null;
    }
}

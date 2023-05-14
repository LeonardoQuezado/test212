public class Request implements Node{
    Request prev = null;
    Request next = null;
    String load;

    public Request(String str) {
        this.load = str;
    }

    @Override
    public Node getPrev() {
        return this.prev;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setPrev(Node node) {
        this.prev = (Request) node;
    }

    @Override
    public void setNext(Node node) {
        this.next = (Request) node;
    }

    public void setLoad(String str) {
        this.load = str;
    }

    public String getLoad() {
        return this.load;
    }
}

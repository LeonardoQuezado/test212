public class Main {
    public static void main(String[] args) {
        ThreadPool tp = new ThreadPool(4);
        Monitor monitor[] = new Monitor[10];
        for (int i = 0; i < 10; i++) {
            monitor[i] = new Monitor(i);
        }
        tp.submit("String - 1");
        tp.submit("String - 2");
        tp.submit("String - 3");
        tp.submit("String - 4");
    }
}

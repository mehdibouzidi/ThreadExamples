package thread.examples.threadsafeillusion;

public class SimpleThreadSafeIllusion implements Runnable{

    static int counter = 0;
    private int id;

    @Override
    synchronized
    public void run() {
        counter++;
        System.out.println("Thread N°"+id+" | Counter: "+counter);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

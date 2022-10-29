package thread.examples.simplethread;

public class SimpleThread implements Runnable{
    static int counter = 0;
    private int id;

    @Override
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

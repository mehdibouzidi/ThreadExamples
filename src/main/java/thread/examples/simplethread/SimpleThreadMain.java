package thread.examples.simplethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadMain {
    public static void main(String[] args) {
        threadUnsafe();
    }



    private static void threadUnsafe() {
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.setId(1);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(simpleThread);
        executorService.execute(simpleThread);
        executorService.execute(simpleThread);
        executorService.shutdown();
    }

    private static void noOrder() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        SimpleThread simpleThread = new SimpleThread();
        simpleThread.setId(1);
        SimpleThread simpleThread2 = new SimpleThread();
        simpleThread2.setId(2);
        SimpleThread simpleThread3 = new SimpleThread();
        simpleThread3.setId(3);
        SimpleThread simpleThread4 = new SimpleThread();
        simpleThread4.setId(4);
        SimpleThread simpleThread5 = new SimpleThread();
        simpleThread5.setId(5);


        executorService.execute(simpleThread);
        executorService.execute(simpleThread2);
        executorService.execute(simpleThread3);
        executorService.execute(simpleThread4);
        executorService.execute(simpleThread5);
        executorService.shutdown();
    }

    private static void maintainedOrder() {
        SimpleThread simpleThread = new SimpleThread();
        simpleThread.setId(1);
        SimpleThread simpleThread2 = new SimpleThread();
        simpleThread2.setId(2);
        SimpleThread simpleThread3 = new SimpleThread();
        simpleThread3.setId(3);
        SimpleThread simpleThread4 = new SimpleThread();
        simpleThread4.setId(4);
        SimpleThread simpleThread5 = new SimpleThread();
        simpleThread5.setId(5);

        simpleThread.run();
        simpleThread2.run();
        simpleThread3.run();
        simpleThread4.run();
        simpleThread5.run();
    }
}

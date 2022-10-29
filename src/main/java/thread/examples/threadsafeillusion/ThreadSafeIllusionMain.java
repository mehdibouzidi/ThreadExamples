package thread.examples.threadsafeillusion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafeIllusionMain {
    public static void main(String[] args) {

    }

    /**
     * Dans ce cas là on voit bien que le compteur est incrémenté par plusieurs thread en même temps et qu'il y avait
     * un accès concurrentiel sur cette variable.
     * Le fait est qu'on est plusieurs instances différentes, empêche la visibilité des threads entre eux, et du coup
     * ils savent pas s'il y a d'autre threads qui sont entrain d'incrémenter le "counter"
     * */
    private static void statisIsNotThreadSafe() {
        SimpleThreadSafeIllusion simpleThreadSafeIllusion = new SimpleThreadSafeIllusion();
        simpleThreadSafeIllusion.setId(1);
        SimpleThreadSafeIllusion simpleThreadSafeIllusion2 = new SimpleThreadSafeIllusion();
        simpleThreadSafeIllusion2.setId(2);
        SimpleThreadSafeIllusion simpleThreadSafeIllusion3 = new SimpleThreadSafeIllusion();
        simpleThreadSafeIllusion3.setId(3);
        SimpleThreadSafeIllusion simpleThreadSafeIllusion4 = new SimpleThreadSafeIllusion();
        simpleThreadSafeIllusion4.setId(4);
        SimpleThreadSafeIllusion simpleThreadSafeIllusion5 = new SimpleThreadSafeIllusion();
        simpleThreadSafeIllusion5.setId(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(simpleThreadSafeIllusion);
        executorService.execute(simpleThreadSafeIllusion2);
        executorService.execute(simpleThreadSafeIllusion3);
        executorService.execute(simpleThreadSafeIllusion4);
        executorService.execute(simpleThreadSafeIllusion5);
        executorService.shutdown();
    }

    /**
     * Dans cette méthode on a l'impression que "counter" est thread-safe alors parce qu'on a synchronisé la méthode qui l'implémente.
     * La vérité c'est qu'il ne l'est pas car il est "static", les variables "static" ne sont pas thread-safe, sauf si, comme dans notre cas
     * une seule instancce fait le boulot, dans ce cas là elle a tjrs une visibilité sur la variable static.
     *
     * Contre-Exemple dans la méthode: statisIsNotThreadSafe
     * */
    private static void threadSafeIllusion() {
        SimpleThreadSafeIllusion simpleThreadSafeIllusion = new SimpleThreadSafeIllusion();
        simpleThreadSafeIllusion.setId(1);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(simpleThreadSafeIllusion);
        executorService.execute(simpleThreadSafeIllusion);
        executorService.execute(simpleThreadSafeIllusion);
        executorService.shutdown();
    }
}

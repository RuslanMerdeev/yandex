package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPools {

    static final int THREAD_NUMBER = 20;
    static final int THREAD_COUNT = 50000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
        List<Future<?>> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            threads.add(executorService.submit(new Incrementor()));
        }
        while (threads.stream().allMatch(Objects::isNull)) {}
        executorService.shutdown();

        System.out.println(Incrementor.count);
    }

    static class Incrementor implements Runnable {

        static AtomicInteger count = new AtomicInteger();

        @Override
        public void run() {
            for (int i = 0; i < THREAD_COUNT; i++) {
                count.getAndIncrement();
            }
        }
    }
}

package org.bees.box.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BeeThreadPool2 {

    private static final int CORE_CPUS = Runtime.getRuntime().availableProcessors();
    private static final int TASK_SIZE = 1000;

    // a throol pool may be managed by spring
    private static ExecutorService executor = new ThreadPoolExecutor(
            CORE_CPUS, 10, 60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(60));

    public static void main(String[] args) {

        String a = "runrum";
        BeeThreadPool2 beeThreadPool2 = new BeeThreadPool2();
        executor.submit(() -> beeThreadPool2.new ProcessUm(a));

    }

    class ProcessUm implements Runnable {

        private String a;

        public ProcessUm(String a) {
            this.a = a;
        }

        @Override
        public void run() {
            System.out.println(a);
        }
    }

}

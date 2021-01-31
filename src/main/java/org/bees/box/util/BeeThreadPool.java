package org.bees.box.util;

import java.util.concurrent.*;

public class BeeThreadPool {

    private static final int CORE_CPU = Runtime.getRuntime().availableProcessors();


    public static void main(String[] args) {
        final BeeThreadPool threadPoolTest = new BeeThreadPool();
        for (int i = 0; i < 8; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        Future<String> future = threadPoolTest.submit();
                        try {
                            String s = future.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (Error e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        //子线程不停gc，模拟偶发的gc
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.gc();
                }
            }
        }).start();
    }

    /**
     * 异步执行任务
     * @return
     */
    public Future<String> submit() {
        //关键点，通过Executors.newSingleThreadExecutor创建一个单线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(50);
                return System.currentTimeMillis() + "";
            }
        });
        executorService.execute(futureTask);
        return futureTask;
    }
}



package systems.jobs.threads;

import java.util.Queue;

import systems.jobs.tasks.Task;

public class RunnableThread implements Runnable {

    private boolean isAwake;

    private volatile Queue<Task> taskQueue;

    public RunnableThread(Queue<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " Initialised");
        while (true) {
            System.out.println(threadName);
            if (!taskQueue.isEmpty()) {
                taskQueue.poll().execute();
                System.out.println(threadName + " EXECUTING");
            }
        }
    }
}

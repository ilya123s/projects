package systems.jobs.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import systems.jobs.tasks.Task;

/**
 * This is the global thread pool of the problem. When called upon to be
 * initialised, a thread is made per core and all threads are handled by this
 * thread pool. A task queue is also initialised here and made available to all
 * threads.
 * 
 * @author Ilya
 *
 */
public class ThreadPool {

    private static List<Thread> threadList;

    private static int maxTaskCount;

    private volatile static Queue<Task> taskQueue;

    private static ThreadPool threadPool;

    public static void intialiseThreadPool(int coreCount, int maxTaskCount) {
        if (null == threadPool) {
            threadPool = new ThreadPool(coreCount, maxTaskCount);
        }

    }

    private ThreadPool(int coreCount, int maxTaskCount) {
        threadList = new ArrayList<Thread>();
        taskQueue = new LinkedList<Task>();
        ThreadPool.maxTaskCount = maxTaskCount;

        for (int i = 0; i < coreCount - 1; i++) {
            RunnableThread newRunnableThread = new RunnableThread(taskQueue);
            Thread thread = new Thread(newRunnableThread);
            thread.setName(new String("Thread number " + i));
            thread.setDaemon(true);
            threadList.add(thread);
        }
        this.startAllThreads();
        Thread.currentThread().setName("Thread number " + (coreCount - 1));
        threadList.add(Thread.currentThread());

    }

    /**
     * This starts all the threads and will and will check if the thread has
     * already been started. If it hasn't then it will be stored, otherwise does
     * nothing.
     */
    private void startAllThreads() {
        for (Thread thread : threadList) {
            if (!thread.isAlive()) {
                thread.start();
            }
        }

    }

    /**
     * Method will call run on all threads regardless of their state.
     */
    public static void kickAll() {
        threadList.notifyAll();
    }

    /**
     * Method will set all threads to sleep regardless of state.
     * 
     * @throws InterruptedException
     */
    public static void waitAll() throws InterruptedException {
        for (Thread thread : threadList) {
            thread.wait();
        }
    }

    public static synchronized void addTask(Task task) {

        System.out.println("Queue size " + taskQueue.size());
        if (taskQueue.size() < maxTaskCount) {
            taskQueue.add(task);
            System.out.println("TASK ADDED");
        }
    }

    /**
     * Returns the number of active threads.
     * 
     * @return int
     */
    public static int getThreadCount() {
        return threadList.size();
    }

}

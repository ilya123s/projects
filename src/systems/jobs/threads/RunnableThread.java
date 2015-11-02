package systems.jobs.threads;

import java.util.Currency;
import java.util.Queue;

import systems.jobs.tasks.Task;

public class RunnableThread implements Runnable {

	private int threadNumber;

	private boolean isAwake;

	private volatile Queue<Task> taskQueue;

	public RunnableThread(int threadNumber, Queue<Task> taskQueue) {
		this.threadNumber = threadNumber;
		this.taskQueue = taskQueue;
	}

	@Override
	public void run() {

		System.out.println(threadNumber);
		while (true) {
			System.out.println(threadNumber);
			if (!taskQueue.isEmpty()) {
				taskQueue.poll().execute();
				System.out.println(threadNumber + " EXECUTING");
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

package systems.jobs.threads;

import java.util.Queue;

import systems.jobs.tasks.Task;

public class Thread implements Runnable {

	private int threadNumber;

	private boolean isAwake;
	
	private volatile Queue<Task> taskQueue;

	public Thread(int threadNumber, Queue<Task> taskQueue) {
		this.threadNumber = threadNumber;
		this.taskQueue = taskQueue;
		isAwake = true;
	}

	@Override
	public void run() {

		while (isAwake | taskQueue.isEmpty()) {
			taskQueue.poll().execute();
			System.out.println(threadNumber);
		}

	}
	
	public void setSleep(){
		isAwake = false;
	}

}

package systems.jobs.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import systems.jobs.tasks.Task;

public class ThreadPool {

	private List<Thread> threadList;

	private int maxTaskCount;

	private volatile Queue<Task> taskQueue;

	public ThreadPool(int coreCount, int maxTaskCount) {
		threadList = new ArrayList<Thread>();
		taskQueue = new LinkedList<Task>();
		this.maxTaskCount = maxTaskCount;

		for (int i = 0; i < coreCount; i++) {
			Thread newThread = new Thread(i, taskQueue);
			threadList.add(newThread);
		}

	}

	public synchronized void addTask(Task task) {

		if (taskQueue.size() < maxTaskCount) {
			taskQueue.add(task);
		}
	}

}
